String str = "mydb://foo:bar@localhost:27017"; 
Pattern p = Pattern.compile("^mydb://([^:]+):([^@]+)@[^:]+:\\d+$");
Matcher matcher = p.matcher(str);
if (matcher.find())
    System.out.println("User: " + matcher.group(1) + ", Password: "
                        + matcher.group(2));