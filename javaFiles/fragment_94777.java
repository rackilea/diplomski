....
PreparedStatement stmt = null;
try {
     String sorgu = 
    "Select per.* from per_kimlik_bilgileri per where  concat(pkb_tc_no, '/' , pkb_ad 
    ,'/' , pkb_soyad , '/' , pkb_sicil_no , '/' , pkb_gorev_yeri , '/' , pkb_unvan_k , '/'
    , pkb_gorev_k , '/' , pkb_istihdam_tipi ,'/', pkb_gor_drm) REGEXP ?|?  " ; 

    PreparedStatement preparedStatement = conn.prepareStatement(sorgu);

    preparedStatement.setString(1, name);
    preparedStatement.setString(2, val);

    ResultSet rs = preparedStatement.executeQuery();
    ......