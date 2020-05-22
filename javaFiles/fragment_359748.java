•   There are a number of reasons a data import could fail, most likely due to problem with
 the configuration of data-config.xml. To see for sure what's going on you'll have to look in
 C:\tomcat6\logs\catalina.*.

    •   If you happen to find that your import is failing due to system running out of memory,
 however, there's an easy, SQL Server specific fix. Add responseBuffering=adaptive and
 selectMethod=cursor to the url attribute of the dataSource node in data-config.xml. That stops the
 JDBC driver from trying to load the entire result set into memory before reads can occur.

    •   Note that by default the index gets created in C:\Tomcat6\bin\solr\data\index. To change this path
 just edit solrconfig.xml & change <dataDir>${solr.data.dir:./solr/data}</dataDir>.

    •   In new Solr versions, I think 3.0 and above you have to place the 2 data import handler
 jars in your solr lib directory (i.e. for example apache-solr-dataimporthandler-3.3.0.jar & apache-
solr-dataimporthandler-extras-3.3.0.jar). Search for them in your Solr zip you downloaded. In older
 Solr versions this is not required because they are bundled with solr.war. Since we have placed the
 data import handlers in the lib directory so we need to specify their paths in solrconfig.xml. Add
 this line to solrconfig.xml: (Example: <lib dir="C:/solr/lib/" regex="apache-solr-dataimporthandler-
\d.*\.jar" />)