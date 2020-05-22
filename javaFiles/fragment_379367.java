[INFO] Scanning for projects...
[WARNING] 
[WARNING] Some problems were encountered while building the effective model for com.onelogin:samlAutentica:war:2.0.1
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework.ldap:spring-ldap-core:jar -> version 2.3.1.RELEASE vs 1.3.1.RELEASE @ line 165, column 17
[WARNING] 'dependencies.dependency.(groupId:artifactId:type:classifier)' must be unique: org.springframework:spring-webmvc:jar -> version 3.1.2.RELEASE vs 3.0.3.RELEASE @ line 215, column 17
[WARNING] 
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING] 
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING] 
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building samlAutentica 2.0.1
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ samlAutentica ---
[INFO] com.onelogin:samlAutentica:war:2.0.1
[INFO] +- com.onelogin:java-saml:jar:2.0.1:compile
[INFO] |  +- com.onelogin:java-saml-core:jar:2.0.1:compile
[INFO] |  |  +- (org.slf4j:slf4j-api:jar:1.7.12:compile - version managed from 1.7.14; omitted for duplicate)
[INFO] |  |  +- (joda-time:joda-time:jar:2.9.4:compile - omitted for duplicate)
[INFO] |  |  +- (org.apache.commons:commons-lang3:jar:3.4:compile - omitted for duplicate)
[INFO] |  |  +- (org.apache.santuario:xmlsec:jar:2.0.7:compile - omitted for duplicate)
[INFO] |  |  \- (commons-codec:commons-codec:jar:1.10:compile - omitted for duplicate)
[INFO] |  +- org.slf4j:slf4j-api:jar:1.7.12:compile
[INFO] |  +- joda-time:joda-time:jar:2.9.4:compile
[INFO] |  +- org.apache.commons:commons-lang3:jar:3.4:compile
[INFO] |  +- (org.apache.santuario:xmlsec:jar:2.0.7:compile - omitted for conflict with 1.5.8)
[INFO] |  \- commons-codec:commons-codec:jar:1.10:compile
[INFO] +- org.apache.axis:axis:jar:1.4:compile
[INFO] +- log4j:log4j:jar:1.2.15:provided (scope not updated to compile)
[INFO] |  \- (javax.mail:mail:jar:1.4:provided - omitted for duplicate)
[INFO] +- org.apache.logging.log4j:log4j-1.2-api:jar:2.3:compile
[INFO] |  +- org.apache.logging.log4j:log4j-api:jar:2.3:compile
[INFO] |  \- org.apache.logging.log4j:log4j-core:jar:2.3:compile
[INFO] |     \- (org.apache.logging.log4j:log4j-api:jar:2.3:compile - omitted for duplicate)
[INFO] +- org.apache.ws.security:wss4j:jar:1.5.6:compile
[INFO] |  +- commons-logging:commons-logging:jar:1.1:compile
[INFO] |  |  +- (log4j:log4j:jar:1.2.12:compile - omitted for conflict with 1.2.15)
[INFO] |  |  +- logkit:logkit:jar:1.0.1:compile
[INFO] |  |  +- avalon-framework:avalon-framework:jar:4.1.3:compile
[INFO] |  |  \- (javax.servlet:servlet-api:jar:2.3:compile - omitted for conflict with 2.5)
[INFO] |  +- (org.apache.santuario:xmlsec:jar:1.4.2:compile - omitted for conflict with 2.0.7)
[INFO] |  +- xalan:xalan:jar:2.7.1:compile
[INFO] |  |  \- xalan:serializer:jar:2.7.1:compile
[INFO] |  |     \- (xml-apis:xml-apis:jar:1.3.04:compile - omitted for conflict with 1.0.b2)
[INFO] |  \- bouncycastle:bcprov-jdk14:jar:140:compile
[INFO] +- javax.servlet:servlet-api:jar:2.5:provided (scope not updated to compile)
[INFO] +- org.springframework.ldap:spring-ldap-core:jar:1.3.1.RELEASE:compile
[INFO] |  +- (commons-logging:commons-logging:jar:1.0.4:compile - omitted for conflict with 1.1)
[INFO] |  +- (commons-lang:commons-lang:jar:2.5:compile - omitted for conflict with 2.6)
[INFO] |  +- (org.springframework:spring-core:jar:3.0.5.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  +- (org.springframework:spring-beans:jar:3.0.5.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  \- org.springframework:spring-tx:jar:3.0.5.RELEASE:compile
[INFO] |     +- (aopalliance:aopalliance:jar:1.0:compile - omitted for duplicate)
[INFO] |     +- (org.springframework:spring-aop:jar:3.0.5.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |     +- (org.springframework:spring-beans:jar:3.0.5.RELEASE:compile - omitted for duplicate)
[INFO] |     +- (org.springframework:spring-context:jar:3.0.5.RELEASE:compile - omitted for conflict with 3.0.6.RELEASE)
[INFO] |     \- (org.springframework:spring-core:jar:3.0.5.RELEASE:compile - omitted for duplicate)
[INFO] +- javax.xml:jaxrpc-api:jar:1.1:compile
[INFO] +- commons-lang:commons-lang:jar:2.6:compile
[INFO] +- org.jdom:jdom:jar:1.1:compile
[INFO] +- dom4j:dom4j:jar:1.6.1:compile
[INFO] |  \- xml-apis:xml-apis:jar:1.0.b2:compile
[INFO] +- org.springframework.security:spring-security-cas:jar:3.1.0.RELEASE:compile
[INFO] |  +- (org.springframework.security:spring-security-web:jar:3.1.0.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  +- org.jasig.cas.client:cas-client-core:jar:3.1.12:compile
[INFO] |  |  \- (commons-logging:commons-logging:jar:1.1:compile - omitted for duplicate)
[INFO] |  +- org.springframework:spring-web:jar:3.0.6.RELEASE:compile
[INFO] |  |  +- (aopalliance:aopalliance:jar:1.0:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-beans:jar:3.0.6.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  |  +- (org.springframework:spring-context:jar:3.0.6.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  |  \- (org.springframework:spring-core:jar:3.0.6.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  +- (org.springframework.security:spring-security-core:jar:3.1.0.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  +- (org.springframework:spring-context:jar:3.0.6.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  +- (org.springframework:spring-beans:jar:3.0.6.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  \- (org.springframework:spring-core:jar:3.0.6.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] +- org.springframework.security:spring-security-config:jar:3.0.5.RELEASE:compile
[INFO] |  \- (org.springframework.security:spring-security-core:jar:3.0.5.RELEASE:compile - omitted for conflict with 3.1.0.RELEASE)
[INFO] +- org.springframework.security:spring-security-core:jar:3.0.5.RELEASE:compile
[INFO] |  +- (org.springframework:spring-expression:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  +- (org.springframework:spring-context:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.6.RELEASE)
[INFO] |  +- (org.springframework:spring-tx:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  +- (org.springframework:spring-aop:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- org.aspectj:aspectjrt:jar:1.6.8:compile
[INFO] |  \- org.aspectj:aspectjweaver:jar:1.6.8:compile
[INFO] +- org.springframework.security:spring-security-taglibs:jar:3.0.5.RELEASE:compile
[INFO] |  +- (org.springframework.security:spring-security-web:jar:3.0.5.RELEASE:compile - omitted for conflict with 3.1.0.RELEASE)
[INFO] |  +- org.springframework.security:spring-security-acl:jar:3.0.5.RELEASE:compile
[INFO] |  |  +- (org.springframework.security:spring-security-core:jar:3.0.5.RELEASE:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-context-support:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  |  \- (org.springframework:spring-jdbc:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.6.RELEASE)
[INFO] |  \- (org.springframework:spring-web:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.6.RELEASE)
[INFO] +- org.springframework.security:spring-security-web:jar:3.0.5.RELEASE:compile
[INFO] |  +- (org.springframework.security:spring-security-core:jar:3.0.5.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-web:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.6.RELEASE)
[INFO] +- org.springframework:spring-aop:jar:3.0.3.RELEASE:compile
[INFO] |  +- aopalliance:aopalliance:jar:1.0:compile
[INFO] |  +- (org.springframework:spring-asm:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  \- (org.springframework:spring-core:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] +- org.springframework:spring-asm:jar:3.0.3.RELEASE:compile
[INFO] +- org.springframework:spring-beans:jar:3.0.3.RELEASE:compile
[INFO] |  \- (org.springframework:spring-core:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] +- org.springframework:spring-context:jar:3.0.3.RELEASE:compile
[INFO] |  +- (org.springframework:spring-aop:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] |  +- (org.springframework:spring-expression:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-asm:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework:spring-context-support:jar:3.0.3.RELEASE:compile
[INFO] |  +- (org.springframework:spring-beans:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-core:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] +- org.springframework:spring-core:jar:3.0.3.RELEASE:compile
[INFO] |  +- (org.springframework:spring-asm:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (commons-logging:commons-logging:jar:1.1.1:compile - omitted for conflict with 1.1)
[INFO] +- org.springframework:spring-expression:jar:3.0.3.RELEASE:compile
[INFO] |  \- (org.springframework:spring-core:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] +- org.springframework:spring-jdbc:jar:3.0.3.RELEASE:compile
[INFO] |  +- (org.springframework:spring-beans:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-tx:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.5.RELEASE)
[INFO] +- net.sf.jasperreports:jasperreports:jar:3.7.5:compile
[INFO] |  +- commons-beanutils:commons-beanutils:jar:1.8.0:compile
[INFO] |  |  \- (commons-logging:commons-logging:jar:1.1.1:compile - omitted for conflict with 1.1)
[INFO] |  +- commons-collections:commons-collections:jar:2.1:compile
[INFO] |  +- commons-digester:commons-digester:jar:1.7:compile
[INFO] |  |  +- (commons-beanutils:commons-beanutils:jar:1.6:compile - omitted for conflict with 1.8.0)
[INFO] |  |  +- (commons-logging:commons-logging:jar:1.0:compile - omitted for conflict with 1.1)
[INFO] |  |  +- (commons-collections:commons-collections:jar:2.1:compile - omitted for duplicate)
[INFO] |  |  \- (xml-apis:xml-apis:jar:1.0.b2:compile - omitted for duplicate)
[INFO] |  +- (commons-logging:commons-logging:jar:1.0.2:compile - omitted for conflict with 1.1)
[INFO] |  +- com.lowagie:itext:jar:2.1.7:compile
[INFO] |  |  +- bouncycastle:bcmail-jdk14:jar:138:compile
[INFO] |  |  +- (bouncycastle:bcprov-jdk14:jar:138:compile - omitted for conflict with 140)
[INFO] |  |  \- org.bouncycastle:bctsp-jdk14:jar:1.38:compile
[INFO] |  |     +- org.bouncycastle:bcprov-jdk14:jar:1.38:compile
[INFO] |  |     \- org.bouncycastle:bcmail-jdk14:jar:1.38:compile
[INFO] |  |        \- (org.bouncycastle:bcprov-jdk14:jar:1.38:compile - omitted for duplicate)
[INFO] |  +- jfree:jcommon:jar:1.0.15:compile
[INFO] |  +- jfree:jfreechart:jar:1.0.12:compile
[INFO] |  |  \- (jfree:jcommon:jar:1.0.15:compile - omitted for duplicate)
[INFO] |  +- (xml-apis:xml-apis:jar:1.3.02:compile - omitted for conflict with 1.0.b2)
[INFO] |  \- eclipse:jdtcore:jar:3.1.0:compile
[INFO] +- org.json:json:jar:20160810:compile
[INFO] +- org.springframework:spring:jar:2.5.6:compile
[INFO] |  \- (commons-logging:commons-logging:jar:1.1.1:compile - omitted for conflict with 1.1)
[INFO] +- org.springframework:spring-webmvc:jar:3.0.3.RELEASE:compile
[INFO] |  +- (org.springframework:spring-asm:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-beans:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-context-support:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-core:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  +- (org.springframework:spring-expression:jar:3.0.3.RELEASE:compile - omitted for duplicate)
[INFO] |  \- (org.springframework:spring-web:jar:3.0.3.RELEASE:compile - omitted for conflict with 3.0.6.RELEASE)
[INFO] +- org.opensaml:opensaml:jar:1.1:compile
[INFO] +- javax.mail:mail:jar:1.4:compile
[INFO] |  \- javax.activation:activation:jar:1.1:compile
[INFO] +- jaxen:jaxen:jar:1.1-beta-6:compile
[INFO] |  +- (jaxen:jaxen:jar:1.1-beta-4:compile - omitted for cycle)
[INFO] |  +- (dom4j:dom4j:jar:1.5.2:compile - omitted for conflict with 1.6.1)
[INFO] |  +- (jaxen:jaxen:jar:1.0-FCS:compile - omitted for cycle)
[INFO] |  +- jdom:jdom:jar:1.0:compile
[INFO] |  +- xerces:xmlParserAPIs:jar:2.6.2:compile
[INFO] |  +- xerces:xercesImpl:jar:2.6.2:compile
[INFO] |  \- xom:xom:jar:1.0b3:compile
[INFO] |     +- (xerces:xmlParserAPIs:jar:2.6.1:compile - omitted for conflict with 2.6.2)
[INFO] |     +- (xerces:xercesImpl:jar:2.2.1:compile - omitted for conflict with 2.6.2)
[INFO] |     +- com.ibm.icu:icu4j:jar:2.6.1:compile
[INFO] |     +- (xalan:xalan:jar:2.6.0:compile - omitted for conflict with 2.7.1)
[INFO] |     \- org.ccil.cowan.tagsoup:tagsoup:jar:0.9.7:compile
[INFO] +- commons-discovery:commons-discovery:jar:0.4:compile
[INFO] |  \- (commons-logging:commons-logging:jar:1.0.4:compile - omitted for conflict with 1.1)
[INFO] +- wsdl4j:wsdl4j:jar:1.6.2:compile
[INFO] +- com.liferay:nl.captcha.simplecaptcha:jar:1.1.1:compile
[INFO] +- org.springframework.webflow:spring-webflow:jar:2.3.3.RELEASE:compile
[INFO] |  +- (commons-logging:commons-logging:jar:1.1.1:compile - omitted for conflict with 1.1)
[INFO] |  +- opensymphony:ognl:jar:2.6.11:compile
[INFO] |  +- org.springframework.webflow:spring-binding:jar:2.3.3.RELEASE:compile
[INFO] |  |  +- (commons-logging:commons-logging:jar:1.1.1:compile - omitted for conflict with 1.1)
[INFO] |  |  +- (opensymphony:ognl:jar:2.6.11:compile - omitted for duplicate)
[INFO] |  |  +- (org.springframework:spring-beans:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  |  +- (org.springframework:spring-context:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  |  +- (org.springframework:spring-core:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  |  \- (org.springframework:spring-expression:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  +- org.springframework.webflow:spring-js:jar:2.3.3.RELEASE:compile
[INFO] |  |  +- (commons-logging:commons-logging:jar:1.1.1:compile - omitted for conflict with 1.1)
[INFO] |  |  +- org.springframework.webflow:spring-js-resources:jar:2.3.3.RELEASE:compile
[INFO] |  |  +- (org.springframework:spring-beans:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  |  +- (org.springframework:spring-context:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  |  +- (org.springframework:spring-core:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  |  +- (org.springframework:spring-web:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.6.RELEASE)
[INFO] |  |  \- (org.springframework:spring-webmvc:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  +- (org.springframework:spring-beans:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  +- (org.springframework:spring-context:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  +- (org.springframework:spring-core:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  +- (org.springframework:spring-expression:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] |  +- (org.springframework:spring-web:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.6.RELEASE)
[INFO] |  \- (org.springframework:spring-webmvc:jar:4.0.0.RELEASE:compile - omitted for conflict with 3.0.3.RELEASE)
[INFO] \- org.apache.santuario:xmlsec:jar:1.5.8:compile
[INFO]    \- (commons-logging:commons-logging:jar:1.1.1:compile - omitted for conflict with 1.1)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.336s
[INFO] Finished at: Fri Sep 29 15:03:00 EEST 2017
[INFO] Final Memory: 13M/245M
[INFO] ------------------------------------------------------------------------