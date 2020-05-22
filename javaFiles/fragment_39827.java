String s = "Install: C:\\Program Files\\app\nDatabase: postgresql://127.0.0.1:42018/app\nStarted: 2016-12-28 10:40:05.908000\nLines: 1000000\nVersion: 4.1\nPID: 1736";
Pattern pattern = Pattern.compile("postgresql://[\\d.]+:(\\d+)\\b");
Matcher matcher = pattern.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group(1)); 
}