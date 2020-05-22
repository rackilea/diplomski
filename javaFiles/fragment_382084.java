compile: bin src cmp
bin: ; mkdir bin
src: ; find src -name "*.java" > sources.txt
cmp: ; javac -cp biuoop-1.4.jar -d bin @sources.txt
run: ; java -cp biuoop-1.4.jar:bin:src/resources Ass6Game
jar: ; jar -cmf Ass6Game.jar Manifest.txt -C bin . -C src resources