visualvm_jdkhome=
for j in /usr/lib/jvm/java-7-openjdk-$ARCH /usr/lib/jvm/java-8-openjdk-$ARCH /usr/lib/jvm/default-java; do
    if [ -x $j/bin/javac ]; then
       visualvm_jdkhome=$j
       break
    fi
done