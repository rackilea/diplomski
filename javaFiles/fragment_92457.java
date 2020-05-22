CPPFLAGS:=-I"${JAVA_HOME}/include" -I"${JAVA_HOME}/include/linux"

JNI_LIB:=libHelloJNI.so
JNI_OUT:=$(JNI_LIB) HelloJNI.o HelloJNI.h HelloJNI.class
CFLAGS:=-fPIC
LDFLAGS:=-shared

.PHONY: all
all: $(JNI_OUT)

%.h: %.class
    javah -jni HelloJNI

$(JNI_LIB): HelloJNI.o
    $(LINK.o) $^ $(LOADLIBES) $(LDLIBS) -o $@

HelloJNI.o: HelloJNI.c HelloJNI.h

%.class: %.java
    javac HelloJNI.java

.PHONY: run
run:
    java -Djava.library.path=. HelloJNI

.PHONY: clean
clean:
    $(RM) $(JNI_OUT)