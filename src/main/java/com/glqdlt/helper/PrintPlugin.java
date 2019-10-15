package com.glqdlt.helper;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * @author glqdlt
 */
@Mojo(name = "print")
public class PrintPlugin extends AbstractMojo {

    @Parameter(property = "excludePath")
    private String excludePath;

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    @Parameter(property = "targetPath", required = true)
    private String targetPath;

    @Parameter(property = "excludeExtension")
    private String[] excludeExtensions;

    public String[] getExcludeExtensions() {
        return excludeExtensions;
    }

    public void setExcludeExtensions(String[] excludeExtensions) {
        this.excludeExtensions = excludeExtensions;
    }

    public void execute() throws MojoExecutionException, MojoFailureException {

        FileEcho a = new FileEcho(excludeExtensions) {
            @Override
            void info(String message) {
                getLog().info(message);
            }
        };
        try {
            a.print(targetPath);
        } catch (Throwable e) {
            getLog().error(e.getMessage(), e);
        }
    }

    public String getExcludePath() {
        return excludePath;
    }

    public void setExcludePath(String excludePath) {
        this.excludePath = excludePath;
    }
}
