src/main/config
    +dev
        +app.properties
    +int
        +app.properties

src/main/resources
    +context.xml

app.properties (dev)
    +ejb.ServiceBean.JNDI_NAME=XXX
app.properties (int)
    +ejb.ServiceBean.JNDI_NAME=YYY

In context.xml
<jee:remote-slsb id="myServiceBean" 
                     jndi-name="${ejb.ServiceBean.JNDI_NAME}" 
                     business-interface="..." 
                     >
<jee:environment>

In pom.xml

<properties> 
    <env_dyn>dev</env_dyn> 
...
... 
<build>
    <resources> 
            <resource>
                <directory>src/main/resources</directory>
                <filtering>true</filtering>
            </resource>
    </resources> 
    <filters>
            <filter>src/main/config/${env_dyn}/app.properties</filter>
    </filters>
...
...

mvn clean install=> ejb.ServiceBean.JNDI_NAME=XXX in context.xml because default properties>env_dyn=dev     
mvn clean install -Denv_dyn=dev => ejb.ServiceBean.JNDI_NAME=XXX in context.xml
mvn clean install -Denv_dyn=rec => ejb.ServiceBean.JNDI_NAME=YYY in context.xml