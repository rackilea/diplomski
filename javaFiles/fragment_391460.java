# per the README from the JRE, these files are for the browser plugin and are not needed otherwise
#bin/javaw.exe
bin/javaws.exe
bin/javacpl.exe
bin/jucheck.exe
bin/jusched.exe
bin/wsdetect.dll
bin/NPJPI*.dll
bin/NPJava*
bin/NPOJI610.dll
bin/RegUtils.dll
bin/axbridge.dll
bin/deploy.dll
bin/jpicom.dll
bin/javacpl.cpl
bin/jpiexp.dll
bin/jpinscp.dll
bin/jpioji.dll
bin/jpishare.dll
lib/deploy.jar
lib/plugin.jar
lib/javaws.jar
lib/javaws/messages*
lib/javaws/miniSplash.jpg
bin/new_plugin**
bin/jureg*
bin/ssv*
bin/jqs*
bin/jp2*
lib/deploy/**/*

# if you do not need any RMI stuff
# wildcard to catch .exe files on Windows
# note rmi.dll is not excluded, which is needed by jconsole; add rmi.dll if you do not need jsonsole
bin/jbroker*
bin/java-rmi*
bin/rmid*
bin/rmiregistry*
bin/tnameserv*
bin/orbd*
bin/servertool*

# do not include QuickTime
# this will be in the jre dir for machines that have QT installed
lib/ext/QTJava.zip