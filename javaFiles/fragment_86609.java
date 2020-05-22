String input = "window.open('http://saudisale.com/arPrivatePage.aspx?id=21871638','_blank','channelmode =1,scrollbars=1,status=0,titlebar=0,toolbar=0,resizable=1');";

String regex = "window.open\\(['\"]*(.*?)(\\s*['\"]*,.*?)";
Pattern pattern = Pattern.compile(regex); 
Matcher matcher = pattern.matcher(input);
while (matcher.find()) {

    String output = (matcher.group().replaceAll(regex, "$1"));
    System.out.println(output);
}