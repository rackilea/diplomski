<plugin>
            <!-- Copies static web files from src/main/webapp to target/${webappDirectory} -->
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>2.1.1</version>
            <executions>
               <execution>
                  <!-- the exploded goal gets executed during compile phase -->
                  <phase>compile</phase>
                  <goals>
                     <goal>exploded</goal>
<!--                      <goal>war</goal> -->
                  </goals>
               </execution>
            </executions>
            <configuration>
            <failOnMissingWebXml>false</failOnMissingWebXml>
                <warName>${project.artifactId}</warName>
                <!-- Exclude GWT client local classes from the deployment, lest
                classpath scanners such as Hibernate and Weld get confused when the webapp 
                is bootstrapping. -->
                <packagingExcludes>**/javax/**/*.*,**/client/local/**/*.class</packagingExcludes>
                <warSourceExcludes>WEB-INF/web.xml</warSourceExcludes>             
                <!-- the exploded war structure ends up in target/${webappDirectory} -->
                <webappDirectory>${webappDirectory}</webappDirectory>
            </configuration>
         </plugin>