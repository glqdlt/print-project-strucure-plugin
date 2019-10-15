
## Intro

I was bored So I created a this plugin.

This plugin simply prints out all project files to the console.

## How To


maven pom.xml configuration

```xml
 <build>
        <plugins>
            <plugin>
                <groupId>com.glqdlt.helper</groupId>
                <artifactId>print-project-structure-plugin</artifactId>
                <configuration>
                    <targetPath>${project.basedir}</targetPath>
                    <excludeExtensions>
                        <extension>md</extension>
                        <extension>xml</extension>
                    </excludeExtensions>
                </configuration>
            </plugin>
        </plugins>
    </build>

```

maven goal command
```
mvn print-project-structure:print
```