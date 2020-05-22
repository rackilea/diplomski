<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
            http://maven.apache.org/xsd/maven-4.0.0.xsd">
  ...

  <properties>
    <!-- properties used to rename css files with version number. -->
    <css.version>${project.version}</css.version>
    <!-- Temp directory where to copy renamed files, later added by maven-war-plugin as web-resources. -->
    <rename.tmp.directory>${project.build.directory}/rename_tmp</rename.tmp.directory>
  </properties>

  <!-- There is a problem when running the webapp from Eclipse: m2e-wtp acquires 
  the web-resources before any lifecycle can be launched, so, before 
  maven-antrun-plugin can rename the files. We define a profile so that 
  maven-antrun-plugin copies files directly into the m2e-wtp web-resources directory, 
  when running from Eclipse.  -->
  <profiles>
    <profile>
      <id>m2e</id>
      <!-- This profile is only active when the property "m2e.version"
      is set, which is the case when building in Eclipse with m2e, 
      see https://stackoverflow.com/a/21574285/1768736. -->
      <activation>
        <property>
          <name>m2e.version</name>
        </property>
      </activation>
      <properties>
        <rename.tmp.directory>${project.build.directory}/m2e-wtp/web-resources/</rename.tmp.directory>
      </properties>
    </profile>
  </profiles>

  ... 

  <build>
    <plugins>
      <plugin>
        <artifactId>maven-antrun-plugin</artifactId>
        <executions>
          <execution>
            <goals>
              <goal>run</goal>
            </goals>
            <id>rename-resources</id>
            <!-- perform copy before the package phase, 
            when maven-war-plugin builds the WAR file -->
            <phase>process-resources</phase>
            <configuration>
              <target>
                <!-- copy renamed files. -->
                 <copy todir="${rename.tmp.directory}/css/">
                   <fileset dir="src/main/webapp/css/">
                     <include name="**/*.css" />
                   </fileset>
                   <!-- See other Mappers available at http://ant.apache.org/manual/Types/mapper.html -->
                   <mapper type="glob" from="*.css" to="*-${css.version}.css"/>
                 </copy>
               </target>
            </configuration>
          </execution>
        </executions>
      </plugin>

      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-war-plugin</artifactId>
        <configuration>
          <!-- We do no let the maven-war-plugin take care of files that will be renamed. 
          Paths defined relative to warSourceDirectory (default is ${basedir}/src/main/webapp) -->
          <warSourceExcludes>css/</warSourceExcludes>
          <webResources>
          <!-- include the resources renamed by maven-antrun-plugin, 
          at the root of the WAR file -->
            <resource>
              <directory>${rename.tmp.directory}</directory>
              <includes>
                <include>**/*</include>
              </includes>
            </resource>
          </webResources>
        </configuration>
      </plugin>

      ...
    </plugins>


    <!-- When running server from Eclipse, we need to tell m2e to execute 
    maven-antrun-plugin to rename files, by default it doesn't. We need to modify the life cycle mapping. -->
    <pluginManagement>
      <plugins>
        <!-- This plugin is not a real one, it is only used by m2e to obtain 
        config information. This is why it needs to be put in the section 
        pluginManagement, otherwise Maven would try to download it. -->
        <plugin>
          <groupId>org.eclipse.m2e</groupId>
          <artifactId>lifecycle-mapping</artifactId>
          <version>1.0.0</version>
          <configuration>
            <lifecycleMappingMetadata>
              <pluginExecutions>
                <pluginExecution>
                  <pluginExecutionFilter>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-antrun-plugin</artifactId>
                    <versionRange>[1.0.0,)</versionRange>
                    <goals>
                      <goal>run</goal>
                    </goals>
                  </pluginExecutionFilter>
                  <action>
                    <execute>
                      <!-- set to true, otherwise changes are not seen, 
                      e.g., to a css file, and you would need to perform 
                      a project update each time. -->
                      <runOnIncremental>true</runOnIncremental>
                    </execute >
                  </action>
                </pluginExecution>
              </pluginExecutions>
            </lifecycleMappingMetadata>
          </configuration>
        </plugin>
      </plugins>
    </pluginManagement>

    ...

  </build>

    ...
</project>