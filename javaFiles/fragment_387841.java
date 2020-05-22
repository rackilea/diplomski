PreparedStatement ps = con.prepareStatement("
                                select * 
                                from PhoneData 
                                where upper(rtrim(COALESCE(names,''))) || 
                                      upper(rtrim(COALESCE(middleName,''))) ||  
                                      upper(rtrim(COALESCE(lastName,''))) = ?");