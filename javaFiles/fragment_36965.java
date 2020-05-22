interop ---- domainobjects ---- IFoo.java
                           ---- TypedObject.java
                           ---- pom.xml

        ---- functional    ---- fooimpl.clj
                           ---- pom.xml

        ---- consumer      ---- JavaConsumer.java
                           ---- JavaConsumerTest.groovy
                           ---- pom.xml
        ---- pom.xml

######################################################################################

package com.tobeconsumed.byjava;

import java.util.List;

public interface IFoo {
    List<TypedObject> createListOfTypedObjects(String message);
}


package com.tobeconsumed.byjava;

public class TypedObject {

    private String property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <artifactId>interop</artifactId>
    <groupId>interop</groupId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <groupId>interop</groupId>
  <artifactId>domainobjects</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>domainobjects</name>
  <description>Contains all of the domain objects.</description>

  <dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.8.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.codehaus.groovy</groupId>
      <artifactId>groovy-all</artifactId>
      <version>1.7.4</version>
    </dependency>    
  </dependencies>

  <build>

    <finalName>domainobjects</finalName>

    <plugins>
        <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>2.3.1</version>
        <configuration>
          <source>1.6</source>
          <target>1.6</target>
          <project>
            <build>
                <scriptSourceDirectory>src/main/java</scriptSourceDirectory>
                <testSourceDirectory>src/test/java</testSourceDirectory>
            </build>
          </project>
        </configuration>
        <executions>
         <execution>
           <id>compile</id>
           <phase>compile</phase>
           <goals>
             <goal>compile</goal>
           </goals>
         </execution>
         <execution>
           <id>test-java</id>
           <phase>test</phase>
           <goals>
             <goal>testCompile</goal>
           </goals>
         </execution>
       </executions>
      </plugin>
      <plugin>
        <groupId>org.codehaus.gmaven</groupId>
        <artifactId>gmaven-plugin</artifactId>
        <version>1.2</version>
        <extensions>true</extensions>
        <configuration>
            <project>
            <build>
                <sourceDirectory>src/main/groovy</sourceDirectory>
                <testSourceDirectory>src/test/groovy</testSourceDirectory>
            </build>
            </project>
        </configuration>
      </plugin>
      <plugin>
    <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-antrun-plugin</artifactId>
            <executions>
                <execution>
                    <id>compile</id>
                    <phase>compile</phase>
                    <configuration>
                        <tasks>
                            <mkdir dir="${basedir}/src/main/groovy"/>
                            <taskdef name="groovyc"
                                classname="org.codehaus.groovy.ant.Groovyc">
                                <classpath refid="maven.compile.classpath"/>
                            </taskdef>
                            <mkdir dir="${project.build.outputDirectory}"/>
                            <groovyc destdir="${project.build.outputDirectory}"
                                srcdir="${basedir}/src/main/groovy/" listfiles="true">
                                <classpath refid="maven.compile.classpath"/>
                            </groovyc>
                        </tasks>
                    </configuration>
                    <goals>
                        <goal>run</goal>
                    </goals>
                </execution>
                <execution>
                    <id>test-compile</id>
                    <phase>test-compile</phase>
                    <configuration>
                        <tasks>
                            <mkdir dir="${basedir}/src/test/groovy"/>
                            <taskdef name="groovyc"
                                classname="org.codehaus.groovy.ant.Groovyc">
                                <classpath refid="maven.compile.classpath"/>
                            </taskdef>
                            <mkdir dir="${project.build.testOutputDirectory}"/>
                            <groovyc destdir="${project.build.testOutputDirectory}"
                                srcdir="${basedir}/src/test/groovy/" listfiles="true">
                                <classpath refid="maven.test.classpath"/>
                            </groovyc>
                        </tasks>
                    </configuration>
                    <goals>
                        <goal>run</goal>
                    </goals>
                </execution>
            </executions>
       </plugin>      
    </plugins>
  </build>

</project>


######################################################################################

(ns com.tobeconsumed.byjava.fooimpl
  (:import com.tobeconsumed.byjava.IFoo)
  (:gen-class
    :implements [com.tobeconsumed.byjava.IFoo]))

(defn -createListOfTypedObjects
  "Creates and returns a list of TypedObjects"
  [this message]
  (println message)
  [(TypedObject.), (TypedObject.), (TypedObject.), (TypedObject.)])

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <artifactId>interop</artifactId>
    <groupId>interop</groupId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <groupId>interop</groupId>
  <artifactId>functional</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <name>functional</name>
  <description>Some functional code.</description>

  <repositories>
    <repository>
      <id>clojars</id>
      <url>http://clojars.org/repo/</url>
    </repository>
    <repository>
      <id>clojure-releases</id>
      <url>http://build.clojure.org/releases</url>
    </repository>
    <repository>
      <id>clojure-snapshots</id>
      <url>http://build.clojure.org/snapshots</url>
    </repository>
    <repository>
      <id>central</id>
      <url>http://repo1.maven.org/maven2</url>
    </repository>
  </repositories>

  <dependencies>
    <dependency>
      <groupId>interop</groupId>
      <artifactId>domainobjects</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.clojure</groupId>
      <artifactId>clojure</artifactId>
      <version>1.2.0</version>
      <type>pom</type>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.clojure</groupId>
      <artifactId>clojure-contrib</artifactId>
      <version>1.2.0</version>
      <type>pom</type>
      <scope>compile</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
        <plugin>
        <groupId>com.theoryinpractise</groupId>
        <artifactId>clojure-maven-plugin</artifactId>
        <version>1.3.3</version>
        <configuration>
            <project>
                <build>
                    <sourceDirectory>src/main/clojure</sourceDirectory>
                    <testSourceDirectory>src/test/clojure</testSourceDirectory>
                </build>
            </project>
        </configuration>
        <executions>
         <execution>
           <id>compile</id>
           <phase>compile</phase>
           <goals>
             <goal>compile</goal>
           </goals>
         </execution>
         <execution>
           <id>test-clojure</id>
           <phase>test</phase>
           <goals>
             <goal>test</goal>
           </goals>
         </execution>
       </executions>
      </plugin>
    </plugins>
  </build>

</project>


######################################################################################



package consumer;

import java.util.List;

import com.tobeconsumed.byjava.IFoo;
import com.tobeconsumed.byjava.TypedObject;
import com.tobeconsumed.byjava.fooimpl;

public class JavaConsumer {

    public List<TypedObject> callCreateListOfTypedObjects() {
        IFoo foo = new fooimpl();
        List<TypedObject> listOfTypedObject = foo.createListOfTypedObjects("Returning typed a list");
        return listOfTypedObject;
    }

}


package consumer;

import junit.framework.TestCase;

public class JavaConsumerTest extends TestCase {

    private JavaConsumer javaConsumer;

    protected void setUp() throws Exception {
        javaConsumer = new JavaConsumer();
        super.setUp();
    }

    protected void tearDown() throws Exception {
        javaConsumer = null;
        super.tearDown();
    }

    public void testCallShowMessage() {
        assertNotNull(javaConsumer);
        def result = javaConsumer.callCreateListOfTypedObjects();

        assert 4 == result.size()
    }

}


<?xml version="1.0"?>
<project xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd" xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
  <modelVersion>4.0.0</modelVersion>
  <parent>
    <artifactId>interop</artifactId>
    <groupId>interop</groupId>
    <version>0.0.1-SNAPSHOT</version>
  </parent>
  <groupId>interop</groupId>
  <artifactId>consumer</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>
  <name>consumer</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>interop</groupId>
      <artifactId>functional</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>interop</groupId>
      <artifactId>domainobjects</artifactId>
      <version>0.0.1-SNAPSHOT</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.8.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>org.codehaus.groovy</groupId>
      <artifactId>groovy-all</artifactId>
      <version>1.7.4</version>
    </dependency>    
  </dependencies>
  <build>

    <finalName>consumer</finalName>

    <plugins>
        <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>2.3.1</version>
        <configuration>
          <source>1.6</source>
          <target>1.6</target>
          <project>
            <build>
                <scriptSourceDirectory>src/main/java</scriptSourceDirectory>
                <testSourceDirectory>src/test/java</testSourceDirectory>
            </build>
          </project>
        </configuration>
        <executions>
         <execution>
           <id>compile</id>
           <phase>compile</phase>
           <goals>
             <goal>compile</goal>
           </goals>
         </execution>
         <execution>
           <id>test-java</id>
           <phase>test</phase>
           <goals>
             <goal>testCompile</goal>
           </goals>
         </execution>
       </executions>
      </plugin>
      <plugin>
        <groupId>org.codehaus.gmaven</groupId>
        <artifactId>gmaven-plugin</artifactId>
        <version>1.2</version>
        <extensions>true</extensions>
        <configuration>
            <project>
            <build>
                <sourceDirectory>src/main/groovy</sourceDirectory>
                <testSourceDirectory>src/test/groovy</testSourceDirectory>
            </build>
            </project>
        </configuration>
      </plugin>
      <plugin>
    <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-antrun-plugin</artifactId>
            <executions>
                <execution>
                    <id>compile</id>
                    <phase>compile</phase>
                    <configuration>
                        <tasks>
                            <mkdir dir="${basedir}/src/main/groovy"/>
                            <taskdef name="groovyc"
                                classname="org.codehaus.groovy.ant.Groovyc">
                                <classpath refid="maven.compile.classpath"/>
                            </taskdef>
                            <mkdir dir="${project.build.outputDirectory}"/>
                            <groovyc destdir="${project.build.outputDirectory}"
                                srcdir="${basedir}/src/main/groovy/" listfiles="true">
                                <classpath refid="maven.compile.classpath"/>
                            </groovyc>
                        </tasks>
                    </configuration>
                    <goals>
                        <goal>run</goal>
                    </goals>
                </execution>
                <execution>
                    <id>test-compile</id>
                    <phase>test-compile</phase>
                    <configuration>
                        <tasks>
                            <mkdir dir="${basedir}/src/test/groovy"/>
                            <taskdef name="groovyc"
                                classname="org.codehaus.groovy.ant.Groovyc">
                                <classpath refid="maven.compile.classpath"/>
                            </taskdef>
                            <mkdir dir="${project.build.testOutputDirectory}"/>
                            <groovyc destdir="${project.build.testOutputDirectory}"
                                srcdir="${basedir}/src/test/groovy/" listfiles="true">
                                <classpath refid="maven.test.classpath"/>
                            </groovyc>
                        </tasks>
                    </configuration>
                    <goals>
                        <goal>run</goal>
                    </goals>
                </execution>
            </executions>
       </plugin>      
    </plugins>
  </build>
</project>

######################################################################################

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>interop</groupId>
  <artifactId>interop</artifactId>
  <packaging>pom</packaging>
  <version>0.0.1-SNAPSHOT</version>
  <name>interop</name>

  <repositories>
    <repository>
      <id>central</id>
      <url>http://repo1.maven.org/maven2</url>
    </repository>
  </repositories>

  <dependencies>
  </dependencies>

  <build>
    <plugins>
    </plugins>
  </build>
  <modules>
    <module>functional</module>
    <module>consumer</module>
    <module>domainobjects</module>
  </modules>

</project>