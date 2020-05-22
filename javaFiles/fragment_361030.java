SET TIME ZONE 'America/Los_Angeles';

DROP TABLE IF EXISTS some_table_ ;

CREATE TEMP TABLE IF NOT EXISTS some_table_  (
    "some_datetime_" TIMESTAMP WITH TIME ZONE NOT NULL
) ;

INSERT INTO some_table_
VALUES ( '2016-01-23 12:34:01' ); -- Lacking offset-from-UTC. *Not recommended*!

INSERT INTO some_table_
VALUES ( '2016-01-23 12:34:02Z' ); -- 'Z' means Zulu = UTC.

TABLE some_table_ ;