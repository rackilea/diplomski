String s = "Starting backup at 14-JUL-13\n" + 
        "channel d1: starting compressed incremental level 0 datafile backup set\n" + 
        "channel d1: specifying datafile(s) in backup set\n" + 
        "input datafile file number=00004 name=/oradata/reports1/qqq01.dbf\n" + 
        "input datafile file number=00001 name=/oradata/reports1/aaa01.dbf\n" + 
        "input datafile file number=00002 name=/oradata/reports1/xxx01.dbf\n" + 
        "input datafile file number=00003 name=/oradata/reports1/bbbs01.dbf\n" + 
        "<...>\n" + 
        "\n" + 
        "Starting backup at 15-JUL-13\n" + 
        "current log archived\n" + 
        "channel d1: starting compressed archived log backup set\n" + 
        "channel d1: specifying archived log(s) in backup set\n" + 
        "input archived log thread=1 sequence=580 RECID=288 STAMP=820739223\n" + 
        "input archived log thread=1 sequence=581 RECID=289 STAMP=820739223\n" + 
        "<...>\n" + 
        "\n" + 
        "Starting backup at 16-JUL-13\n" + 
        "<...>";
Matcher m = Pattern.compile("(?s)(Starting backup at \\d{1,2}-[A-Z]{3,4}-\\d{1,2})\\n(.*?)(?=\\n\\n|$)").matcher(s);
while(m.find())
{
    System.out.println(m.group(1));
    System.out.println(m.group(2));
}