ALTER TABLE mytable
  ADD COLUMN newcolumn DECIMAL(10,2);

UPDATE mytable
   SET newcolumn = CAST(oldcolumn AS DECIMAL(10,2))
 WHERE true;

ALTER TABLE mytable
 DROP COLUMN oldcolumn,
 CHANGE newcolumn oldcolumn DECIMAL(10,2);