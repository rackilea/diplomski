xx> java -version

java version "1.8.0_161"
Java(TM) SE Runtime Environment (build 1.8.0_161-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.161-b12, mixed mode)

xx> ajc -sourceroots src -d bin -cp "C:\Program Files\Java\AspectJ\lib\aspectjrt.jar"

xx> java -cp bin;"C:\Program Files\Java\AspectJ\lib\aspectjrt.jar" test.Parent

Parent is doing something
Child is doing something