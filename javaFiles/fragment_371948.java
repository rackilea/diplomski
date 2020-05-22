public static void main(String[] args) 
{
    String exp = "15+20+(3.84*25)*(78/3.8)";
    String regex = "(\\d+\\.\\d+)|(\\d+)|([+-/*///^])|([/(/)])";

    Matcher m = Pattern.compile(regex).matcher(exp);

    LinkedList list = new LinkedList();

    while (m.find()) {
        list.add(m.group());
    }

    System.out.println(list);
}