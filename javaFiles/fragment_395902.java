CREATE TABLE test_table
(
    test_col integer not null
);

ALTER TABLE test_table
ADD constraint test_col_unique unique (test_col) deferrable initially deferred;