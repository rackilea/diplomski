Pattern pattern = Pattern.compile("\\d+");
Matcher matcher = pattern.matcher("07-000");
StringBuilder sb = new StringBuilder();
while (matcher.find()) 
{
     sb.append( matcher.group() );
}

System.out.println( "All the numbers are : " +  sb.toString() );