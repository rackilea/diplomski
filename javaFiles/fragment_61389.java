JC = javac
JCR = java

.SUFFIXES: .java .class
.java.class:
    $(JC) $*.java

CLASSES = \
    MainDriver.java \
    FSA.java \
    State.java \
    Transition.java 

TXT_FILES = \
    test1.txt \
    test2.txt \
    test3.txt \

default: classes exec-tests

classes: $(CLASSES:.java=.class)

clean:
    $(RM) *.class *~

exec-tests: classes
    set -e; \
    for file in $(TXT_FILES); do $(JCR) MainDriver $$file; done;


.PHONY: default clean classes exec-tests