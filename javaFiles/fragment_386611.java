public static void main(String[] args) {
    String str = "The picture quality is great of this camera";
    StringTokenizer st = new StringTokenizer(str);
    int numberOfWords = 0;
    boolean start = false;
    while(st.hasMoreTokens()){
        String token = st.nextToken();
        if(token.equals("quality")){
            start = true;
            continue;
        }
        if(start) {
            if(token.equals("great")){
                start = false;
            }
            else {
                numberOfWords++;
            }
        }

    }
    System.out.println(numberOfWords);
}