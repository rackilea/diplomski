Set<String> words = new HashSet<>();
    String str = "Java Ruby PHP.  Java is good. PHP please looks at Java";
    Matcher mat = Pattern.compile("\\b(\\w+)(?=\\b.*\\1)").matcher(str);
    while(mat.find()){
        words.add(mat.group(1));
    }
    System.out.println(words);