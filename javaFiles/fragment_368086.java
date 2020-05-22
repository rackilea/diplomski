$ nohup java -XX:NativeMemoryTracking=summary -Xms2M -Xmx2M HelloWorld &
[2] 6661
nohup: ignoring input and appending output to 'nohup.out'

$ ps aux | awk 'NR==1; /[H]elloWorld/'
USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
chaospie  6661  5.0  0.1 2662860 23104 pts/2   Sl   19:21   0:00 java -XX:NativeMemoryTracking=summary -Xms2M -Xmx2M HelloWorld

$ jcmd 6661 VM.native_memory summary
6661:

Native Memory Tracking:

Total: reserved=1360145KB, committed=61177KB
-                 Java Heap (reserved=2048KB, committed=2048KB)
                            (mmap: reserved=2048KB, committed=2048KB)

-                     Class (reserved=1066093KB, committed=14189KB)
                            (classes #402)
                            (malloc=9325KB #146)
                            (mmap: reserved=1056768KB, committed=4864KB)

-                    Thread (reserved=20646KB, committed=20646KB)
                            (thread #21)
                            (stack: reserved=20560KB, committed=20560KB)
                            (malloc=62KB #110)
                            (arena=23KB #40)

-                      Code (reserved=249632KB, committed=2568KB)
                            (malloc=32KB #299)
                            (mmap: reserved=249600KB, committed=2536KB)

-                        GC (reserved=10467KB, committed=10467KB)
                            (malloc=10383KB #129)
                            (mmap: reserved=84KB, committed=84KB)

-                  Compiler (reserved=132KB, committed=132KB)
                            (malloc=1KB #21)
                            (arena=131KB #3)

-                  Internal (reserved=9453KB, committed=9453KB)
                            (malloc=9421KB #1402)
                            (mmap: reserved=32KB, committed=32KB)

-                    Symbol (reserved=1358KB, committed=1358KB)
                            (malloc=902KB #86)
                            (arena=456KB #1)

-    Native Memory Tracking (reserved=143KB, committed=143KB)
                            (malloc=86KB #1363)
                            (tracking overhead=57KB)

-               Arena Chunk (reserved=175KB, committed=175KB)
                            (malloc=175KB)