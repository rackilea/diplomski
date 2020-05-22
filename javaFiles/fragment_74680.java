SELECT pg_typeof(a)::text AS type
      ,(SELECT typname FROM pg_type WHERE oid = pg_typeof(a)) AS base_type
      ,array_dims(a) AS dims
FROM   (SELECT '{{11,12,13},{21,22,23}}'::int[]) x(a);

   type    | base_type |    dims
-----------+-----------+------------
 integer[] | _int4     | [1:2][1:3]