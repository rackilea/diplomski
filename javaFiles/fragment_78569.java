aploetz@cqlsh:stackoverflow2> SELECT * FROM crewByShip WHERE ship='Serenity' AND id=3;

 ship     | id | firstname | gender | lastname
----------+----+-----------+--------+----------
 Serenity |  3 |   Malcolm |      M | Reynolds

(1 rows)

Tracing session: 38d7f440-e8e1-11e4-9cb7-21b264d4c94d

 activity                                                                                        | timestamp                  | source         | source_elapsed
-------------------------------------------------------------------------------------------------+----------------------------+----------------+----------------
                                                                              Execute CQL3 query | 2015-04-22 06:17:54.692000 | 192.168.23.129 |              0
          Parsing SELECT * FROM crewByShip WHERE ship='Serenity' AND id=3; [SharedPool-Worker-1] | 2015-04-22 06:17:54.695000 | 192.168.23.129 |             87
                                                       Preparing statement [SharedPool-Worker-1] | 2015-04-22 06:17:54.696000 | 192.168.23.129 |            246
                                 Executing single-partition query on users [SharedPool-Worker-3] | 2015-04-22 06:17:54.697000 | 192.168.23.129 |           1185
                                              Acquiring sstable references [SharedPool-Worker-3] | 2015-04-22 06:17:54.698000 | 192.168.23.129 |           1197
                                               Merging memtable tombstones [SharedPool-Worker-3] | 2015-04-22 06:17:54.698000 | 192.168.23.129 |           1215
                                               Key cache hit for sstable 1 [SharedPool-Worker-3] | 2015-04-22 06:17:54.700000 | 192.168.23.129 |           1249
                               Seeking to partition beginning in data file [SharedPool-Worker-3] | 2015-04-22 06:17:54.700000 | 192.168.23.129 |           1278
 Skipped 0/1 non-slice-intersecting sstables, included 0 due to tombstones [SharedPool-Worker-3] | 2015-04-22 06:17:54.701000 | 192.168.23.129 |           3309
                                Merging data from memtables and 1 sstables [SharedPool-Worker-3] | 2015-04-22 06:17:54.701000 | 192.168.23.129 |           3333
                                        Read 1 live and 0 tombstoned cells [SharedPool-Worker-3] | 2015-04-22 06:17:54.702000 | 192.168.23.129 |           3368
                            Executing single-partition query on crewbyship [SharedPool-Worker-2] | 2015-04-22 06:17:54.702000 | 192.168.23.129 |           4607
                                              Acquiring sstable references [SharedPool-Worker-2] | 2015-04-22 06:17:54.704000 | 192.168.23.129 |           4633
                                               Merging memtable tombstones [SharedPool-Worker-2] | 2015-04-22 06:17:54.704000 | 192.168.23.129 |           4643
 Skipped 0/0 non-slice-intersecting sstables, included 0 due to tombstones [SharedPool-Worker-2] | 2015-04-22 06:17:54.705000 | 192.168.23.129 |           4678
                                Merging data from memtables and 0 sstables [SharedPool-Worker-2] | 2015-04-22 06:17:54.705000 | 192.168.23.129 |           4683
                                        Read 1 live and 0 tombstoned cells [SharedPool-Worker-2] | 2015-04-22 06:17:54.706000 | 192.168.23.129 |           4697
                                                                                Request complete | 2015-04-22 06:17:54.697676 | 192.168.23.129 |           5676