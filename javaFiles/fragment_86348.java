public static void main(String[] args) {

    String a = "file";
    String b = "f";
    String c = "";
    StringBuilder sb = new StringBuilder();
    boolean contains;

    for (int i = 0 ; i < a.length() ; i++){
        contains = false;
        for (int j = 0 ; j < b.length() ; j++){
            if (a.charAt(i) == b.charAt(j)) contains = true;
        }
        if (!contains) sb.append(a.charAt(i));
    }

    System.out.println(sb);

}