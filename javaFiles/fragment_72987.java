repositories{ 
mavenCentral() 
} 

configurations{ 
xslt 
} 

dependencies{ 
xslt "net.sf.saxon:saxon:8.7" 
} 

test << { 

 ant.xslt(in: 'C:/testng-results.xml', 
          style: 'C:/testng-results.xsl', 
          out:   'C:/index.java', 
          classpath: configurations.xslt.asPath 
 ) 
}