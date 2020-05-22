String s = "from proxy..vw_xxx a join customer..vw_xxx b\n" + 
        "from proxy..vw_xxx\n" + 
        "insert into proxy..vw_xxx\n" + 
        "from customer..vw_xxx";
Matcher m = Pattern.compile("\\w+(?<!proxy)\\.\\.").matcher(s);
while(m.find())
{
    System.out.println(m.group());
}