public class Main {
    public static void main(String[] args){
        String example = "'BOOM', 'GRE,M', 'H SE', 1,2";
        Pattern regex = Pattern.compile("\'(.+?)\'|([^\\s,]+)");
        Matcher matcher = regex.matcher(example);
        while (matcher.find()) {
            if (matcher.group(1) != null){
                System.out.println(matcher.group(1));
            }else if(matcher.group(2)!=null){
                System.out.println(matcher.group(2));
            }
        }
    }
}