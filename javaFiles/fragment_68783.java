------------------------
LATEST DETECTED DEADLOCK
------------------------
2013-09-05 23:08:27 1b8c
*** (1) TRANSACTION:
TRANSACTION 1388056, ACTIVE 0 sec starting index read, thread declared inside InnoDB 5000
mysql tables in use 2, locked 2
LOCK WAIT 5 lock struct(s), heap size 1248, 2 row lock(s), undo log entries 1
MySQL thread id 6, OS thread handle 0x1db0, query id 3107246 localhost 127.0.0.1 test updating
UPDATE a
         SET  a_field = (
                   SELECT sum(b_field) 
                   FROM b WHERE b.a_id = a.id 
                   FOR UPDATE)
         WHERE 
                id = p_a_id
*** (1) WAITING FOR THIS LOCK TO BE GRANTED:
RECORD LOCKS space id 222 page no 3 n bits 72 index `PRIMARY` of table `test`.`a` trx id 1388056 lock_mode X locks rec but not gap waiting
Record lock, heap no 3 PHYSICAL RECORD: n_fields 4; compact format; info bits 0
 0: len 4; hex 80000002; asc     ;;
 1: len 6; hex 000000152e16; asc     . ;;
 2: len 7; hex 2d0000013b285a; asc -   ;(Z;;
 3: len 4; hex 8000001e; asc     ;;

*** (2) TRANSACTION:
TRANSACTION 1388057, ACTIVE 0 sec starting index read, thread declared inside InnoDB 5000
mysql tables in use 2, locked 2
5 lock struct(s), heap size 1248, 2 row lock(s), undo log entries 1
MySQL thread id 7, OS thread handle 0x1b8c, query id 3107247 localhost 127.0.0.1 test updating
UPDATE a
         SET  a_field = (
                   SELECT sum(b_field) 
                   FROM b WHERE b.a_id = a.id 
                   FOR UPDATE)
         WHERE 
                id = p_a_id
*** (2) HOLDS THE LOCK(S):
RECORD LOCKS space id 222 page no 3 n bits 72 index `PRIMARY` of table `test`.`a` trx id 1388057 lock mode S locks rec but not gap
Record lock, heap no 3 PHYSICAL RECORD: n_fields 4; compact format; info bits 0
 0: len 4; hex 80000002; asc     ;;
 1: len 6; hex 000000152e16; asc     . ;;
 2: len 7; hex 2d0000013b285a; asc -   ;(Z;;
 3: len 4; hex 8000001e; asc     ;;

*** (2) WAITING FOR THIS LOCK TO BE GRANTED:
RECORD LOCKS space id 222 page no 3 n bits 72 index `PRIMARY` of table `test`.`a` trx id 1388057 lock_mode X locks rec but not gap waiting
Record lock, heap no 3 PHYSICAL RECORD: n_fields 4; compact format; info bits 0
 0: len 4; hex 80000002; asc     ;;
 1: len 6; hex 000000152e16; asc     . ;;
 2: len 7; hex 2d0000013b285a; asc -   ;(Z;;
 3: len 4; hex 8000001e; asc     ;;

*** WE ROLL BACK TRANSACTION (2)
------------