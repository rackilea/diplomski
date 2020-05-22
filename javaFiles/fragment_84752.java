String[] data = {"1++1" , "1 ++1", "1+ 1"};
for (String str : data){
    for (String token : str.split("(?<=\\d)\\s*(?=[+])|(?<=[+])\\s*(?=\\d)")){
        System.out.println("token: <"+token+">");
    }
    System.out.println("--------");
}