VAR
  v    { global variable }

FUNCTION calculation(a,b) 
  VAR
    c  { local variable }
  BEGIN
    v = b * a
    c = b / a
    IF (v mod c == 0) THEN
      return v
    ELSE 
      return c
    END IF
  END