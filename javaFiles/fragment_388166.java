String regex = "(?m)^(\\S+).*?((?:\\s+\\S+){3})$";
Matcher m = Pattern.compile(regex).matcher(POEM);
while (m.find()) {
    System.out.println(m.group(1) + m.group(2));
}

1. the slithy toves
2. in the wabe.
3. were the borogoves,
4. mome raths outgrabe.