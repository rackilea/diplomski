for i in `ls jars/*.jar`; 
do 
    export CLASSPATH=$CLASSPATH:$i; 
done
export CLASSPATH=.:$CLASSPATH
javac `find * -name *.java`