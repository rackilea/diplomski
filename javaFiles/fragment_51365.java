public static void main(String[] args) throws IOException {
    System.out.println(convert("45{"));
    System.out.println(convert("45A"));
    System.out.println(convert("45B"));
    System.out.println(convert("45}"));
    System.out.println(convert("45J"));
    System.out.println(convert("45K"));
}
public static long convert(String str){
    String alphabet = "{ABCDEFGHI}JKLMNOPQR";
    Map<String,String> map = Pattern.compile("")
                              .splitAsStream(alphabet)
                              .collect(Collectors.toMap(k->k, k->String.valueOf(alphabet.indexOf(k)%10)));
    boolean isNegative = false;
    if(Pattern.compile("[J-R\\}]+").matcher(str).find()){
        isNegative = true;
    }
    for(String letter : alphabet.split("")){
        str = str.replace(letter, map.get(letter));
    }
    long result = Long.parseLong(str);
    return isNegative ? - result: result;
}