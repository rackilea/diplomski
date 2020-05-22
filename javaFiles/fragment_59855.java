SELECT Key,
       (SELECT Value
        FROM Values
        WHERE Key_ID = Keys._id
          AND Tag_ID = 111
       ) AS Tag_111,
       (SELECT Value
        FROM Values
        WHERE Key_ID = Keys._id
          AND Tag_ID = 222
       ) AS Tag_222,
       ...
FROM Keys;