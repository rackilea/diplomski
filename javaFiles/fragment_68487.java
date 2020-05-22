CREATE FUNCTION myapp_login(uname text, password text) RETURNS text AS $$
DECLARE
    t      text;
BEGIN
    PERFORM * FROM app_users WHERE username = uname AND pwd = password;
    IF FOUND THEN
        INSERT INTO sessions(user_name) VALUES (uname) RETURNING token INTO t;
        EXECUTE format('SET SESSION "my_app.session_user" TO %s', t);
        RETURN t;
    END IF;
    SET SESSION "my_app.session_user" = '';
    RETURN NULL;
END;
$$ LANGUAGE plpgsql STRICT SECURITY DEFINER;
REVOKE EXECUTE ON FUNCTION myapp_login(text, text) FROM PUBLIC;
GRANT EXECUTE ON FUNCTION myapp_login(text, text) TO myapp_role;