CREATE TABLE test.parent_table (
  id INT PRIMARY KEY
);

CREATE TABLE test.child_table (
  id        INT PRIMARY KEY,
  parent_id INT REFERENCES parent_table ( id ),
  prev_id   INT REFERENCES child_table ( id )
);