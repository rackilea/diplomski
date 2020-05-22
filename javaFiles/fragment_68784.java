declare dummy int;
  ...... 
  START TRANSACTION;
      SELECT id INTO dummy FROM A 
      WHERE id = p_a_id FOR UPDATE;
      INSERT INTO c( a_id, c_field ) values ( p_a_id, round(rand() * 100) );
      UPDATE a
         SET  a_field = (
                   SELECT sum(b_field) 
                   FROM b WHERE b.a_id = a.id 
              )
         WHERE 
                id = p_a_id;
       commit;