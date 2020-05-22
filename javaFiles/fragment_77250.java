#! /bin/bash

################
# package.sh
#
# Packages java code as a native OS X application
#
# - Fetches source for a Java Swing HelloWorld application from the web
# - Compiles the source
# - Packages the source into a native Mac application
# - Installs the native Mac application
# - Runs the native Mac Application
#
# Requires:
#   OS X 10.8+
#   Java 8b77+ (http://jdk8.java.net/download.html) 
#   super user rights on the execution account
#
# To Use:
#   chmod +x package.sh
#   ./package.sh
# As the script executes sudo commands, enter your 
# superuser password as needed.
################


# select java version
set JAVA_HOME=`/usr/libexec/java_home -v 1.8`
$JAVA_HOME/bin/java -version

# cleanup work directory and any existing application install
if [ -d work ]; then
  rm -rf work
fi

if [ -d /Applications/HelloWorld.app ]; then
  sudo rm -rf /Applications/HelloWorld.app
fi

# create work directory and use it
mkdir work
cd work

# fetch a simple HelloWorldSwing sample java source from the web
mkdir start
cd start
curl -O http://docs.oracle.com/javase/tutorial/uiswing/examples/start/HelloWorldSwingProject/src/start/HelloWorldSwing.java
cd ..

# compile the HelloWorldSwing java source
$JAVA_HOME/bin/javac start/HelloWorldSwing.java

# create a jar file 
$JAVA_HOME/bin/jar cvf HelloWorldSwing.jar start/*.class

# make an executable jar file
$JAVA_HOME/bin/javafxpackager -createjar -srcdir . -appclass start.HelloWorldSwing -srcfiles HelloWorldSwing.jar -noembedlauncher -outdir . -outfile HelloWorld.jar

# package the jar and java runtime as a native application with installer
$JAVA_HOME/bin/javafxpackager -deploy -srcdir . -srcfiles HelloWorld.jar -outdir . -outfile HelloWorld -appclass start.HelloWorldSwing -native -name HelloWorld

# codesign the application using your apple developer ID (if you have one)
# allows the app to be accepted by the Apple GateKeeper - https://developer.apple.com/resources/developer-id/
# codesign -s "Developer ID Application" bundles/HelloWorld.app

# mount the installer disk image
hdiutil attach bundles/HelloWorld.dmg

# install the HelloWorld application from the disk image
sudo cp -R /Volumes/HelloWorld/HelloWorld.app /Applications

# unmount the installer disk image
umount `mount | grep HelloWorld | cut -d " " -f1`

# leave the work directory
cd ..

# run our newly installed application
open -a HelloWorld