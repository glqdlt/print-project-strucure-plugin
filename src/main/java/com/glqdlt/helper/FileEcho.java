package com.glqdlt.helper;

import java.io.File;

/**
 * Date 2019-10-15
 *
 * @author glqdlt
 */
public abstract class FileEcho {

    private String[] excludeExtension;

    public String[] getExcludeExtension() {
        return excludeExtension;
    }

    public void setExcludeExtension(String[] excludeExtension) {
        this.excludeExtension = excludeExtension;
    }

    public FileEcho() {
    }

    public FileEcho(String[] excludeExtension) {
        this.excludeExtension = excludeExtension;
    }

    abstract void info(String message);

    public void print(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            info(file.getPath());
            File[] child = file.listFiles();
            if (child != null) {
                for (File c : child) {
                    print(c.getPath());
                }
            }
        } else if (file.isFile()) {
            String f = file.getPath();
            if (excludeExtension != null) {
                boolean isSkip = false;
                for (String ext : excludeExtension) {
                    if (ext.indexOf(".") != 0) {
                        ext = "." + ext;
                    }
                    if (f.endsWith(ext)) {
                        isSkip = true;
                    }
                }
                if(!isSkip){
                    info(" -"+f);
                }
            } else {
                info(f);
            }
        }
    }
}
