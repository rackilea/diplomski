String str = "abbacde";
char[] chars = str.toCharArray();
for (char c : chars) {
    String replacement = replacements.get(c);
    str = str.replaceAll(""+c, replacement);
}

System.out.println(str); // αввαcɒє