function my-hadoop-env {
    #Hadoop variables - my version 
    export HADOOPTWO_INSTALL=/home/parallels/Development/Hadoop/hadoop-trunk/trunk2/hadoop-dist/target/hadoop-3.0.0-SNAPSHOT
    export PATH=$PATH:$HADOOPTWO_INSTALL/bin
    export PATH=$PATH:$HADOOPTWO_INSTALL/sbin
    export HADOOP_MAPRED_HOME=$HADOOPTWO_INSTALL
    export HADOOP_COMMON_HOME=$HADOOPTWO_INSTALL
    export HADOOP_HDFS_HOME=$HADOOPTWO_INSTALL
    export YARN_HOME=$HADOOPTWO_INSTALL
    export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOPTWO_INSTALL/lib/native
    export HADOOP_OPTS="$HADOOP_OPTS -Djava.library.path=$HADOOPTWO_INSTALL/lib/"
}

function hadoop-env {
    #Hadoop variables - version 2.2.0
    export HADOOP_INSTALL=/home/parallels/Development/Hadoop/hadoop-2.2.0
    export PATH=$PATH:$HADOOP_INSTALL/bin
    export PATH=$PATH:$HADOOP_INSTALL/sbin
    export HADOOP_MAPRED_HOME=$HADOOP_INSTALL
    export HADOOP_COMMON_HOME=$HADOOP_INSTALL
    export HADOOP_HDFS_HOME=$HADOOP_INSTALL
    export YARN_HOME=$HADOOP_INSTALL
    export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_INSTALL/lib/native
    export HADOOP_OPTS="$HADOOP_OPTS -Djava.library.path=$HADOOP_INSTALL/lib/"
}