ArrayList<String> str = new ArrayList<String>();

for(int i = 0 ; i < str.size() ; i++) {
    if(str.get(i).contains("your_user_input")) {
        System.out.println(str.get(i));
    }
}