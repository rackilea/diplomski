public static void main(String[] args) {

    String str = "hell";
    StringBuilder buff = new StringBuilder();
    buff.append(str.charAt(0))
            .append(str.charAt(1))
            .append(str)
            .append(str.charAt(0))
            .append(str.charAt(1));
    System.out.println(buff.toString());// prints 'hehellhe'
}