Table definition:

    CREATE TABLE departments (
      ID           NUMBER(10)    NOT NULL,
      DESCRIPTION  VARCHAR2(50)  NOT NULL);

    ALTER TABLE departments ADD (
      CONSTRAINT dept_pk PRIMARY KEY (ID));

    CREATE SEQUENCE dept_seq;