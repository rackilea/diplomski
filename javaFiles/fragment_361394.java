String para = "abc abc abc abc abc abc abc abc abc abc \n" +
            "abc abc abc abc abc abc abc abc abc abc ";

String[] sentences = para.split("\n");
String finalString = "";
for (String s : sentences) {
    finalString = finalString + wrapString(s, 20).trim() + "\n";
}

System.out.println(finalString);