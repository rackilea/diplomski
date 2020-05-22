SESSION 1                               SESSION 2

create table ser_test( x text );

BEGIN TRANSACTION 
ISOLATION LEVEL SERIALIZABLE;


                                        BEGIN TRANSACTION 
                                        ISOLATION LEVEL SERIALIZABLE;

SELECT count(*) FROM ser_test ;

                                        SELECT count(*) FROM ser_test ;

INSERT INTO ser_test(x) VALUES ('bob');


                                        INSERT INTO ser_test(x) VALUES ('bob');

 COMMIT;

                                        COMMIT;