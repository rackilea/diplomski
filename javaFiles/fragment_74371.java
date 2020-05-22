$ sqlite3 /some/where/mydatabase.db
SQLite version 3.8.5 2014-06-04 14:06:34
Enter ".help" for usage hints.
sqlite> BEGIN EXCLUSIVE;
sqlite> -- the DB is now locked ...
sqlite> COMMIT;