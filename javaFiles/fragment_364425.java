public static void main(String[] args) {
    String control = "<div class='myclass'>TRUE</div>";
    Pattern pattern = Pattern.compile(">(.*)<");
    Matcher matcher = pattern.matcher(control);
    String result = null;
    if(matcher.find()) {
        result = matcher.group(1);
    }
    System.out.print(result);
}