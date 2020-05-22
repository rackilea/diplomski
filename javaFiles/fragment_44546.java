SELECT count(CASE 
            WHEN name = :p_name
                THEN 1
            END) AS name_count
    ,count(CASE 
            WHEN email = :p_email
                THEN 1
            END) AS email_count
FROM users;