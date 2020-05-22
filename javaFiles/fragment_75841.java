#!/bin/bash
# The logic to start up your application should be put in this
# script. The application will work only if it binds to
# $OPENSHIFT_DIY_IP:8080
# nohup $OPENSHIFT_REPO_DIR/diy/testrubyserver.rb $OPENSHIFT_DIY_IP $OPENSHIFT_REPO_DIR/diy |& /usr/bin/logshifter -tag diy &


 cd $OPENSHIFT_DATA_DIR

 export JAVA_HOME=/etc/alternatives/java_sdk_1.8.0
 export PATH=$JAVA_HOME/bin:$PATH

 libs="libs"

 export LIB=$OPENSHIFT_REPO_DIR$libs

 src="src"

 export JAVA_FILES=$OPENSHIFT_REPO_DIR$src

 export MATCHFACES=$OPENSHIFT_REPO_DIR$src/matchfaces
 # the below is not working
 # export CLASSPATH=$OPENSHIFT_REPO_DIR/bin:$OPENSHIFT_REPO_DIR/libs/FaceSDK.jar:$OPENSHIFT_REPO_DIR/libs/jna.jar:$OPENSHIFT_REPO_DIR/libs/JavaBridge.jar

 cd $LIB

 # Giving read write and execute permissions to JavaBridge.jar for user role
  chmod u+r JavaBridge.jar

 chmod u+w JavaBridge.jar

 chmod u+x JavaBridge.jar

 # Giving read write and execute permissions to JavaBridge.jar for groups role
 chmod g+r JavaBridge.jar

 chmod g+w JavaBridge.jar

 chmod g+x JavaBridge.jar

 # Giving read write and execute permissions to JavaBridge.jar for Others role
 chmod o+r JavaBridge.jar

 chmod o+w JavaBridge.jar

 chmod o+x JavaBridge.jar

# Giving read write and execute permissions to FaceSDK.jar for user role
chmod u+r FaceSDK.jar

chmod u+w FaceSDK.jar

chmod u+x FaceSDK.jar

# Giving read write and execute permissions to FaceSDK.jar for groups role
chmod g+r FaceSDK.jar

chmod g+w FaceSDK.jar

chmod g+x FaceSDK.jar

# Giving read write and execute permissions to FaceSDK.jar for Others role
 chmod o+r FaceSDK.jar

 chmod o+w FaceSDK.jar

 chmod o+x FaceSDK.jar

 # Giving read write and execute permissions to jna.jar for user role
 chmod u+r jna.jar

 chmod u+w jna.jar

 chmod u+x jna.jar

 # Giving read write and execute permissions to jna.jar for groups role
 chmod g+r jna.jar

 chmod g+w jna.jar

 chmod g+x jna.jar

 # Giving read write and execute permissions to FaceSDK.jar for Others role
 chmod o+r jna.jar

 chmod o+w jna.jar

 chmod o+x jna.jar

 nohup ls -l > ${OPENSHIFT_DIY_LOG_DIR}/output1.log 2>&1 &


 cd $OPENSHIFT_REPO_DIR

 if [[ -z "$OPENSHIFT_INTERNAL_IP" ]]; then export OPENSHIFT_INTERNAL_IP="$OPENSHIFT_DIY_IP"; fi
 if [[ -z "$OPENSHIFT_INTERNAL_PORT" ]]; then export OPENSHIFT_INTERNAL_PORT="$OPENSHIFT_DIY_PORT"; fi

 # nohup dir $LIB > ${OPENSHIFT_DIY_LOG_DIR}/output1.log 2>&1 &

 nohup javac -classpath .;$LIB"/JavaBridge.jar;"$LIB"/FaceSDK.jar;"$LIB"/jna.jar" $MATCHFACES/*.java > ${OPENSHIFT_DIY_LOG_DIR}/compile.log 2>&1 &

nohup java -classpath  .;$LIB"/JavaBridge.jar;"$LIB"/FaceSDK.jar;"$LIB"/jna.jar" $MATCHFACES/Listener > ${OPENSHIFT_DIY_LOG_DIR}/Listener.log 2>&1 &

# nohup java -cp bin test.MyHttpServer >    ${OPENSHIFT_DIY_LOG_DIR}/MyHttpServer.log 2>&1 &