public static void main(String[] args) {
    List<String> list = Arrays.asList("abc","def","ghi","jkl","mno","pqr","stw");
    String strStart = "def";
    String strEnd   = "mno";
    List<String> subList = list.subList(list.indexOf(strStart), list.indexOf(strEnd)+1);
    System.out.println(subList);
}