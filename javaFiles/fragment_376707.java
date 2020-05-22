String directory = "[jetty directory]";
String format = "/usr/bin/java -Djetty.logging.dir=%s/logs -Djetty.home=%s -Djetty.base=%s -Djava.io.tmpdir=/tmp -jar %s/start.jar jetty.state=%s/jetty.state jetty-logging.xml jetty-started.xml";

Process process = Runtime.getRuntime()
                     .exec(String.format(format, directory, directory, directory, directory, directory));

process.waitFor();