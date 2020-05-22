public static void main(String[] args) throws IOException {
    String str = "[{\"ID\":\"A001\",\"Name\":\"Captain America\",\"State\":\"Brooklyn\"},{\"ID\":\"A002\",\"Name\":\"Iron Man\",\"State\":\"New York\"}]";
    Pattern p = Pattern.compile("(?<=\"Name\":\")(.*?)(?=\",\"State\")");  
    Matcher m = p.matcher(str);
    while(m.find()){
        System.out.println(m.group(1));
    }
}