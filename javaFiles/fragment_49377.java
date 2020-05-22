select expiry, dayname(expiry) as expiry_weekday, user, 

                         CASE weekday(expiry)
                           WHEN 0 THEN date_add(expiry,INTERVAL -7 DAY) -- MON -> MON
                           WHEN 1 THEN date_add(expiry,INTERVAL -7 DAY) -- TUE -> TUE
                           WHEN 2 THEN date_add(expiry,INTERVAL -7 DAY) -- WED -> WED
                           WHEN 3 THEN date_add(expiry,INTERVAL -7 DAY) -- THU -> THU
                           WHEN 4 THEN date_add(expiry,INTERVAL -7 DAY) -- FRI -> FRI
                           WHEN 5 THEN date_add(expiry,INTERVAL -8 DAY) -- SAT -> FRI
                           WHEN 6 THEN date_add(expiry,INTERVAL -9 DAY) -- SUN -> FRI
                         END
                          as notification_date,

                         dayname(CASE weekday(expiry)
                                 WHEN 0 THEN date_add(expiry,INTERVAL -7 DAY) -- MON -> MON
                                 WHEN 1 THEN date_add(expiry,INTERVAL -7 DAY) -- TUE -> TUE
                                 WHEN 2 THEN date_add(expiry,INTERVAL -7 DAY) -- WED -> WED
                                 WHEN 3 THEN date_add(expiry,INTERVAL -7 DAY) -- THU -> THU
                                 WHEN 4 THEN date_add(expiry,INTERVAL -7 DAY) -- FRI -> FRI
                                 WHEN 5 THEN date_add(expiry,INTERVAL -8 DAY) -- SAT -> FRI
                                 WHEN 6 THEN date_add(expiry,INTERVAL -9 DAY) -- SUN -> FRI
                                 END
                                ) as notification_weekday
FROM pwd_expiry ;