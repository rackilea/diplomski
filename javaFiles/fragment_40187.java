ant clean
ant jar 
#because these two works fine

for i in `ls dist/*.jar; ls dist/lib/*.jar`
do
   jarsigner -storepass mystorepass -keypass mykeypass $i myname
   #sign all the .jars
done

cp launch.jnlp dist/launch.jnlp 
#copy the .jnlp