Connection con = null;
    Statement statement = null;
    java.util.Date dateUtil = new Date();
    java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
    java.sql.Timestamp timestamp = new Timestamp(dateUtil.getTime());

    try {
        con = DBConnection.createConnection();
        statement = con.createStatement();
        Enumeration en = request.getParameterNames();
        LinkedHashMap<String, Integer>  evaluation = new LinkedHashMap<>();
        HashMap<Integer,String >  classifications = new HashMap<>();  
        String getSql = "select ATTRIBUTENAME,POSITIONNO from FEEDBACKATTRUBUTES where ATTRIBUTETYPE ='STARRING'";
        ResultSet resultSet = statement.executeQuery(getSql);
        while (resultSet.next()) {
            classifications.put(resultSet.getInt("POSITIONNO"),resultSet.getString("ATTRIBUTENAME"));
        }

        while (en.hasMoreElements()) {
            Object objOri = en.nextElement();
            String param = (String) objOri;
            String value = request.getParameter(param);
            System.out.println("Parameter Name is '" + param + "' and Parameter Value is '" + value + "'");
            evaluation.put(param,Integer.parseInt(value));
         }  

            String updateSql = "INSERT INTO CUSTOMERFEEDBACK (CUSTOMERID, CUSTOMERNAME, BILLNO, BILLDATE, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ATTRIBUTE7, ATTRIBUTE8, ATTRIBUTE9, ATTRIBUTE10, REMARKS, CREATEDTIMESTAMP, SMSSENT)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(updateSql);
            ps.setString(1, "123456");
            ps.setString(2, "Dheeraj");
            ps.setString(3,"-");
            ps.setDate(4,dateSql);
            Iterator<Map.Entry<String, String>> evaluationIterator = evaluation.entrySet().iterator();
            int i = 5;
            while (i<15) {
                if(evaluationIterator.hasNext()){
                Map.Entry<String, String> entry = evaluationIterator.next();
                ps.setString(i, entry.getKey()+":"+classifications.get(entry.getValue()));
                }
                else{
                    ps.setString(i, "");
                }
                i++;
            }
            ps.setString(15, "remark");
            ps.setTimestamp(16, timestamp);
            ps.setString(17, "N");

            ps.addBatch();
            ps.executeBatch();




    } catch (SQLException e) {
        System.out.println("SQL EXCPTION   91");
        e.printStackTrace();
    }