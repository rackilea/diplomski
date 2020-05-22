SELECT ST_AsText(
  ST_Line_Interpolate_Point(
    ST_GeomFromText('LINESTRING(0 0, 1 2, 10 2)'),
    generate_series(0, 100):: double precision / 100
  )
);