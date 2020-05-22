WITH table_name ( csv ) AS (
  SELECT ', foo,bar, c;qual="baz, b""lurb", d;junk="quux, syzygy", , ' FROM DUAL
)
SELECT csv,
       xxpay_csv_at( csv, 1, ', ' ) AS value1,
       xxpay_csv_at( csv, 2, ', ' ) AS value2,
       xxpay_csv_at( csv, 3, ', ' ) AS value3,
       xxpay_csv_at( csv, 4, ', ' ) AS value4,
       xxpay_csv_at( csv, 5, ', ' ) AS value5,
       xxpay_csv_at( csv, 6, ', ' ) AS value6
FROM   table_name