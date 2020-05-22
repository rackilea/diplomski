cqlsh:TEST_KS> INSERT INTO "MESSAGE_CF" (KEY, "DELETED_RECEIVER", "DELETED_SENDER", "SENDER") 
               VALUES ('user-1241324', 'Yes', 'No', 'user@mail.com');
cqlsh:TEST_KS> SELECT * FROM "MESSAGE_CF";                                                                   
 key          | DELETED_RECEIVER | DELETED_SENDER | RECEIVER | SENDER
--------------+------------------+----------------+----------+---------------
 user-1241324 |              Yes |             No |     null | user@mail.com