WITH Times ( lower_bound, upper_bound ) AS (
  SELECT TO_DATE( '2016-01-30 12', 'YYYY-MM-DD HH24' ), TO_DATE( '2016-01-31 12', 'YYYY-MM-DD HH24' ) FROM DUAL
),
Services ( service_id ) AS (
  SELECT 'S-1' FROM DUAL UNION ALL
  SELECT 'S-2' FROM DUAL
),
Hours ( hr )AS (
  SELECT lower_bound + ( LEVEL - 1 ) / 24
  FROM   times
  CONNECT BY lower_bound + (LEVEL - 1) / 24 <= upper_bound
)
SELECT s.service_id,
       h.hr AS time,
       COALESCE(
         ( SELECT 100 - SUM( LEAST( u.end_time, h.hr + 1/24 ) - GREATEST( start_time, h.hr ) ) * 2400
           FROM   Unavailability u
           WHERE  u.start_time < h.hr + 1/24
           AND    u.end_time   > h.hr
           AND    u.service_id = s.service_id
         ),
         100
       ) AS availability
FROM   Services s
       CROSS JOIN
       Hours h
ORDER BY 1, 2;