SET @ids = NULL;

UPDATE SOME_TABLE
SET activeRegister = true, updateTime = :updateTime
WHERE typeOfOperation = 1 and performUpdate = true
      AND (SELECT @ids := CONCAT_WS(',', id, @ids));

SELECT @ids;