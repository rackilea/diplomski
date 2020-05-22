int rowCount=Math.max(phoneUrls.size(),phoneName.size()); 
        for(int i = 1; i<rowCount;i++){

            String urls = (i<phoneUrls.size()) ? "'"+phoneUrls.get(i).absUrl("href")+"'" : "NULL";
            String names = (i<phoneName.size()) ? "'"+phoneName.get(i).text()+"'" : "NULL";
            String sql = "INSERT INTO skrouzt(url, name) " +
                "VALUES ( "+urls+","+names+" )";
            stmt.executeUpdate(sql);

        }