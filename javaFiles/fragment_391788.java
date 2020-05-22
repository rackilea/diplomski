UPDATE GLOBALSETTINGS 
   SET settingValue = case 
                        when settingName = 'SessionTTL' = then ? 
                        when settingName = 'MaxUsersActive' = then ? 
                        else settingValue
                      end
WHERE settingName in ('SessionTTL', 'MaxUsersActive');