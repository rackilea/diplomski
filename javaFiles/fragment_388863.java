Matcher m = Pattern.compile(Pattern.quote("^||^")).matcher(line);
int count = 0;
while ( m.find() ) 
    count++;

System.out.println(count + "char count between");