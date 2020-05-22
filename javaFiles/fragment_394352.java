java.util.regex.Pattern pattern = 
java.util.regex.Pattern.compile("\\w+\\.\\w+");

java.util.regex.Matcher matcher = pattern.matcher("My_File_Name.txt");

System.out.println(matcher.matches());