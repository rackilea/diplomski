JAR := biuoop-1.4.jar
SOURCES := $(shell find src -name '*.java')
# Or if src is a single directory without sub-directories
#SOURCES := $(wildcard src/*.java)

GAMEJAR := Ass6Game.jar

.PHONY: all
all: $(JAR)

bin:
        mkdir bin

$(JAR): $(SOURCES) | bin
        javac -cp $@ -d bin $^

# See http://www.gnu.org/software/make/manual/make.html#Force-Targets for what `FORCE` is doing here.
$(GAMEJAR): FORCE
        jar -cmf $@ Manifest.txt -C bin . -C src resources

FORCE: ;

.PHONY: run
run: $(GAMEJAR)
        java -cp $(JAR):bin:src/resources $(GAMEJAR)