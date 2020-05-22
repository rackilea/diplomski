String query = "SELECT 1 FROM store WHERE merch_name like '%#1%'";

    Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(query);
    boolean b = m.find();

    String string = null;

    if (b){
        // escape special character with `%`            
        string = "SELECT 1 FROM store WHERE merch_name like '%%#1%'";
    }else{
        string = query;
    }