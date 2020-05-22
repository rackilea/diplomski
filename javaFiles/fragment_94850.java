Pattern pattern = Pattern.compile("([\\/A-Za-z0-9]+)[\\s]+([a-z]+)[\\s]+([0-9]+)[\\s]+([0-9]+)[\\s]+([\\-0-9]+).*");
BufferedReader reader = new BufferedReader(new FileReader("/proc/swaps"));
String s = reader.readLine();
while (s!= null){                
    Matcher matcher = pattern.matcher(s);
    if (matcher.matches()){
        System.out.println(s);
        System.out.println(matcher.group(3));
        System.out.println(matcher.group(4));
    }
    s = reader.readLine();
}            
reader.close();