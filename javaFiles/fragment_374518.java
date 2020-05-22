44900.297: [GC pause (young) (initial-mark), 0.08894851 secs]
^^^^^^^^^^^ Elapsed seconds from JVM start
           ^^^^^^^^^ Collection pause at safe-point
                    ^^^^^^^^ In full young GC mode
                            ^^^^^^^^^^^^^^^ Last pause included initial mark
                                           ^^^^^^^^^^^^^^^^^^ Elapsed seconds in method
44900.386: [GC concurrent-mark-start]
^^^^^^^^^^^ Elapsed seconds from JVM start
           ^^^^^^^^^^^^^^^^^^^^^^^^^^ Concurrent mark thread started
   [Parallel Time:  83.7 ms]
^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Elapsed milliseconds for all GC worker threads to finish
      [GC Worker Start Time (ms):  44900297.6  44900297.6  44900297.6  44900297.6  44900297.6  44900297.7  44900297.7  44900297.7  44900297.7  44900297.7  44900297.7  44900297.7  44900297.7
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^... Elapsed seconds from JVM start that GC worker threads were started
       Avg: 44900297.7, Min: 44900297.6, Max: 44900297.7, Diff:   0.1]
^^^^^^^^^^^^^^^^^^^^^^ Average GC worker thread start time (elapsed seconds from JVM start)
                      ^^^^^^^^^^^^^^^^^ Minimum GC worker thread start time (elapsed seconds from JVM start)
                                       ^^^^^^^^^^^^^^^^^ Maximum GC worker thread start time (elapsed seconds from JVM start)
                                                        ^^^^^^^^^^^^^^ Total seconds to start all GC worker threads
      [Update RS (ms):  23.5  24.3  25.0  25.0  23.9  24.4  25.2  24.1  25.7  24.7  24.8  24.4  24.7
^^^^^^^^^^^^^^^^^^^^^^^^... Elapsed milliseconds for each GC worker thread to update cards in remembered sets during an evacuation pause
       Avg:  24.6, Min:  23.5, Max:  25.7, Diff:   2.1]
^^^^^^^^^^^^^^^^^ Average GC worker thread milliseconds to update RS
                 ^^^^^^^^^^^^ Minimum GC worker thread milliseconds to update RS
                             ^^^^^^^^^^^^ Maximum GC worker thread milliseconds to update RS
                                         ^^^^^^^^^^^^^^ Minimum/maximum delta of GC worker thread milliseconds to update RS
         [Processed Buffers : 16 19 19 23 20 24 18 18 18 17 20 16 19
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^... Total remembered set buffers processed by each GC worker thread
          Sum: 247, Avg: 19, Min: 16, Max: 24, Diff: 8]
^^^^^^^^^^... Summary information for total remembered set buffers processed by all GC worker thread
      [Ext Root Scanning (ms):  2.2  2.7  2.2  2.6  3.0  3.1  2.2  1.1  2.3  3.0  2.2  2.4  2.9
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^... Elapsed milliseconds for each GC worker thread to process heap roots during an evacuation pause
       Avg:   2.4, Min:   1.1, Max:   3.1, Diff:   2.0]
^^^^^^^... Summary information for total elapsed milliseconds for all GC worker thread to process heap roots during an evacuation pause
      [Mark Stack Scanning (ms):  0.0  0.0  0.0  0.0  0.0  0.0  0.0  0.0  0.0  0.0  0.0  0.0  0.0
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^... Elapsed milliseconds for each GC worker thread to scan strong roots in the mark stack during an evacuation pause
       Avg:   0.0, Min:   0.0, Max:   0.0, Diff:   0.0]
^^^^^^^... Summary information for total milliseconds for all GC worker thread to scan strong roots in the mark stack during an evacuation pause
      [Scan RS (ms):  14.1  14.6  14.5  14.3  14.6  14.2  14.4  14.5  14.0  13.9  14.6  14.5  14.0
^^^^^^^^^^^^^^^^^^^^^^... Elapsed milliseconds for each GC worker thread to scan for dirty cards in a heap region to update the remembered set
       Avg:  14.3, Min:  13.9, Max:  14.6, Diff:   0.8]
^^^^^^^^^^^^^... Summary information for total elapsed milliseconds for all GC worker thread to scan for dirty cards in a heap region to update the remembered set
      [Object Copy (ms):  41.4  39.5  39.4  39.0  39.6  39.5  39.1  41.4  39.0  39.3  39.3  39.8  39.5
^^^^^^^^^^^^^^^^^^^^^^^^^^... Elapsed milliseconds for each GC worker thread to scan root sets for pointers to include in this heap region's remembered set during an evacuation pause
       Avg:  39.7, Min:  39.0, Max:  41.4, Diff:   2.4]
^^^^^^^^^^^^^... Summary information for total elapsed milliseconds for all GC worker thread to scan root sets for pointers to include in this heap region's remembered set during an evacuation pause
      [Termination (ms):  1.3  1.4  1.5  1.6  1.5  1.4  1.6  1.4  1.5  1.7  1.5  1.4  1.3
^^^^^^^^^^^^^^^^^^^^^^^^^^... Elapsed milliseconds for each GC worker thread to terminate scanning root sets for pointers to include in this heap region's remembered set during an evacuation pause
       Avg:   1.5, Min:   1.3, Max:   1.7, Diff:   0.4]
^^^^^^^^^^^^^^... Summary information for total elapsed milliseconds for all GC worker thread to terminate scanning root sets for pointers to include in this heap region's remembered set during an evacuation pause
         [Termination Attempts : 1185 1205 1219 1436 1171 1231 1471 1237 1461 1526 1353 1259 1170
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^... Total attempts for each GC worker thread to terminate scanning root sets for pointers to include in this heap region's remembered set during an evacuation pause
          Sum: 16924, Avg: 1301, Min: 1170, Max: 1526, Diff: 356]
^^^^^^^^^^^^^^^... Summary information for total attempts for all GC worker thread to terminate scanning root sets for pointers to include in this heap region's remembered set during an evacuation pause
      [GC Worker End Time (ms):  44900380.2  44900380.2  44900380.2  44900380.2  44900380.2  44900380.3  44900380.2  44900380.2  44900380.2  44900380.2  44900380.2  44900380.2  44900380.2
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^... Elapsed seconds from JVM start that GC worker threads ended
       Avg: 44900380.2, Min: 44900380.2, Max: 44900380.3, Diff:   0.1]
^^^^^^^^^^^^... Summary information for total elapsed seconds from JVM start that GC worker threads ended for all GC worker threads
      [GC Worker Times (ms):  82.6  82.6  82.6  82.6  82.6  82.6  82.5  82.6  82.5  82.5  82.5  82.5  82.5
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^... Elapsed milliseconds for each GC worker threads
       Avg:  82.6, Min:  82.5, Max:  82.6, Diff:   0.1]
^^^^^^^^^^^^^... Summary information for total elapsed milliseconds for all GC worker threads
      [Other:   1.2 ms]
^^^^^^^^^^^^^^^^^^^^^^^ Other milliseconds during GC parallel processing; basically, total milliseconds minus: update RS, ext root scanning, mark stack scanning, scan RS, object copy, termination
   [Clear CT:   0.5 ms]
^^^^^^^^^^^^^^^^^^^^^^^ Total milliseconds cleaning up the dirty card tables list
   [Other:   4.8 ms]
^^^^^^^^^^^^^^^^^^^^ Total milliseconds in this GC pause not spent in parallel and clear CT
      [Choose CSet:   0.0 ms]
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Total milliseconds to choose young heap regions to add to the collection set
   [ 1331M->830M(1840M)]
^^^^^ Heap size change for this garbage collector
     ^^^^^ Total heap size before this collection pause
            ^^^^ Total heap size after this collection pause
                 ^^^^^ Total heap size capacity for this garbage collector
 [Times: user=1.07 sys=0.01, real=0.09 secs]
^^^^^^^^ Execution seconds (uses TraceCPUTime class; constructor initializes times to zero, destructor prints times)
        ^^^^^^^^^^ User execution seconds for all threads
                  ^^^^^^^^^ System execution seconds
                           ^^^^^^^^^^^ Real (wall clock) execution seconds
44901.205: [GC concurrent-mark-end, 0.8186002 sec]
^^^^^^^^^^^ Elapsed seconds from JVM start
           ^^^^^^^^^^^^^^^^^^^^^^^^ Concurrent mark thread ended
                                    ^^^^^^^^^^^^^ Total seconds executing concurrent mark thread
44901.205: [GC remark, 0.0258621 secs]
^^^^^^^^^^^ Elapsed seconds from JVM start
           ^^^^^^^^^^ Concurrent re-marking of all heap roots, final work
 [Times: user=0.02 sys=0.00, real=0.03 secs]
^^^^^^^^ Execution seconds (uses TraceCPUTime class; constructor initializes times to zero, destructor prints times)
        ^^^^^^^^^^ User execution seconds for all threads
                  ^^^^^^^^^ System execution seconds
                           ^^^^^^^^^^^ Real (wall clock) execution seconds
44901.231: [GC concurrent-count-start]
^^^^^^^^^^^ Elapsed seconds from JVM start
           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ Start concurrent marking of live objects
44901.479: [GC concurrent-count-end, 0.2478477]
^^^^^^^^^^^ Elapsed seconds from JVM start
           ^^^^^^^^^^^^^^^^^^^^^^^^^^^ End concurrent marking of live objects
                                   ^^^^^^^^^^^^ Total seconds to do concurrent marking of live objects
44901.479: [GC cleanup 940M->931M(1840M), 0.0073079 secs]
^^^^^^^^^^^ Elapsed seconds from JVM start
           ^^^^^^^^^^^ Concurrent marking cleanup (world is stopped at this checkpoint)
                      ^... Heap size change for this garbage collector
                       ^^^^ Total heap size before this operation
                             ^^^^ Total heap size after this operation
                                  ^^^^^ Total heap size capacity for this garbage collector
                                          ^^^^^^^^^^^^^^ Total seconds executing concurrent marking cleanup