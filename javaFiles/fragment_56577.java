String strJson = "[{ \"art_src_path\": \"source/subdir/hi-there.txt\",\"art_id\": \"6945-L9.txt\",\"art_date\": \"2018:03:10 01:10:33\"},"+
"{ \"art_src_path\": \"source/hello-world.txt\",\"art_id\": \"10426-L13.txt\",\"art_date\": \"2018:03:10 01:10:33\"},"+
"{ \"art_src_path\": \"source/subdir/testfile.txt\",\"art_id\": \"50518-L66.txt\",\"art_date\": \"2018:03:10 01:10:33\"}]" ;

        System.out.println("input = "+strJson) ;

        JSONParser parser = new JSONParser() ;
        JSONArray a = (JSONArray) parser.parse(strJson) ;

        for (Object o:a) {
            String path = (String) ((JSONObject) o).get("art_src_path") ;
            System.out.println("source path:"+path) ;
        }