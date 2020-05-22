StringBuilder wholeString=new StringBuilder();
String line=null;
while ((line = br.readLine()) != null) {
    wholeString.append(line).append(System.lineSeparator());
}

String[] array = wholeString.toString().split("(?=\nH)");