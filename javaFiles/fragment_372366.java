String s1 = "My mom cook everyday";
String s2 = "I eat everyday";
String s3 = "Am I fat?";  
List<String> tokens = new ArrayList<String>();  

tokens.addAll(Arrays.asList(s1.split("\\s+")));
tokens.addAll(Arrays.asList(s2.split("\\s+")));
tokens.addAll(Arrays.asList(s3.split("\\s+")));

System.out.println(tokens);