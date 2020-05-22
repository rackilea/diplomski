<assembly xmlns="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.0 http://maven.apache.org/xsd/assembly-1.1.0.xsd"
>
    <id>${artifact.version}</id>
    <formats>
        <format>zip</format>
    </formats>

    <files>
        <file>
            <!-- an example script instead of using "java -cp ..." each time -->
            <source>${project.basedir}/src/main/bin/run.sh</source>
            <outputDirectory>.</outputDirectory>
            <destName>run.sh</destName>
            <fileMode>0754</fileMode>
        </file>
    </files>

    <fileSets>
        <fileSet>
            <directory>${project.basedir}/src/main/resources/</directory>
            <outputDirectory>/res/</outputDirectory>
            <includes>
                <!-- just examples... -->
                <include>*.sql</include>
                <include>*.properties</include>
            </includes>
        </fileSet>
        <fileSet>
            <directory>config/</directory>
            <outputDirectory>/config/</outputDirectory>
        </fileSet>
    </fileSets>

    <dependencySets>
        <dependencySet>
            <outputDirectory>/lib</outputDirectory>
            <excludes>
                <!-- add redundant/useless files here -->
            </excludes>
        </dependencySet>
    </dependencySets>
</assembly>