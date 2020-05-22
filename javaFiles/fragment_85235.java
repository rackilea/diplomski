CREATE OR REPLACE TYPE BD_TB_STRUCT AS OBJECT(
  start_ts TIMESTAMP(3),
  end_ts   TIMESTAMP(3),
  time_type NUMBER(19),
  duration NUMBER(12)
) FINAL;
/

CREATE OR REPLACE PROCEDURE merge_time_bounds(
  s1_bd_t IN  bd_tb_struct,
  s2_bd_t IN  bd_tb_struct,
  r_bd_t  OUT bd_tb_struct
)
IS
  p_start TIMESTAMP(3) := LEAST(    s1_bd_t.start_ts,  s2_bd_t.start_ts );
  p_end   TIMESTAMP(3) := GREATEST( s1_bd_t.end_ts,    s2_bd_t.end_ts );
BEGIN
  r_bd_t := new BD_TB_STRUCT( 
                  p_start,
                  p_end,
                  COALESCE( s1_bd_t.time_type, s2_bd_t.time_type ),
                  ( CAST( p_end AS DATE ) - CAST( p_start AS DATE ) ) * 24 * 60 * 60
                );
END;
/