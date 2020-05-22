public class SqlSplit {

    public static void main(String[] args) {
        String query = "INSERT INTO CUSTOMERS (ID,NAME,AGE) VALUES (4, 'Chaitali', 25);";
        Pattern pattern = Pattern.compile("\\((.*?)\\)",Pattern.DOTALL);

        Matcher matcher = pattern.matcher(query);
        List<String[]> tokens = new ArrayList<String[]>();
        while(matcher.find()){
            tokens.add(matcher.group().replace("(","").replace(")","").split(","));     
        }

        Map<String,String> map = new HashMap<String,String>();
        if(tokens.size() == 2 && tokens.get(0).length == tokens.get(1).length){
            for(int x = 0; x < tokens.get(0).length; x++){
                map.put(tokens.get(0)[x], tokens.get(1)[x].replace("'", ""));
            }
        }

        for(Entry<String,String> entry: map.entrySet()){
            System.out.println("KEY:" + entry.getKey());
            System.out.println("VALUE:" + entry.getValue());
        }
    }
}