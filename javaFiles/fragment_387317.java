# download the archive http://www.cypherpunks.to/~peter/cl343_beta.zip
# extract the archive to any directory
# -a switch to ensure text files not extracted with DOS lineend
unzip -a cl343_beta.zip -d ${CL_HOME}/

# fix executable bits
chmod +x tools/mkhdr.sh

# re-generate the bindings
tools/mkhdr.sh

# modify some source files
# change in ${CL_HOME}/misc/config.h
   from  /* #define USE_JAVA */
   to    #define USE_JAVA
# change in ${CL_HOME}/bindings/java_jni.c
   from  #include <jni.h>
   to    #include "jni.h"

# copy JDK header files
cd ${CL_HOME}/bindings/
cp ${JAVA_HOME}/include/jni.h .
cp ${JAVA_HOME}/inlcude/linux/jni_md.h .

# build the library
cd ${CL_HOME}/
make
make shared