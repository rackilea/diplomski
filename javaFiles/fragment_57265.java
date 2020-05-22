CREATE OR REPLACE FUNCTION wrong_user_answers(testId INTEGER, userId INTEGER) 
   RETURNS setof t_user_answers 
   AS $wrong_user_answers$
   SELECT ua.*
      FROM t_tests as t
      JOIN t_user_answers as ua on ua.fk_test_id = t.pk_test_id
      WHERE t.pk_test_id = testId and ua.fk_user_id = userId and is_correct(ua) = false;
   $wrong_user_answers$ LANGUAGE sql;