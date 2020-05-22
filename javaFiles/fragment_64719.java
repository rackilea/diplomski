ALTER TABLE table-name
{
    ADD COLUMN column-definition |
    ADD CONSTRAINT clause |
    DROP [ COLUMN ] column-name [ CASCADE | RESTRICT ]
    DROP { PRIMARY KEY | FOREIGN KEY constraint-name | UNIQUE 
     constraint-name | CHECK constraint-name | CONSTRAINT constraint-name }
    ALTER [ COLUMN ] column-alteration |
    LOCKSIZE { ROW | TABLE }
}