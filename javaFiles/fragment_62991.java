WITH i AS (
      INSERT INTO TRENDING ( TOPIC , CATEGORY , QUESTION , ANSWER , PROFILEPIC , TICK , URL )
          VALUES( ?, ? , ? , ? , ? , now() , ? ) 
          Returning ID 
     )
UPDATE QUESTBANK
    SET wasanswered = 'yes' 
    WHERE id IN (SELECT ID FROM i);