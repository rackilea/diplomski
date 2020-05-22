SELECT a.attname, a.atttypid::regtype
FROM pg_attribute a
   JOIN pg_class c ON a.attrelid = c.oid
WHERE c.relname = 'address_type'
  AND c.relkind = 'c'
  AND NOT a.attisdropped
  AND a.attnum > 0
ORDER BY a.attnum;