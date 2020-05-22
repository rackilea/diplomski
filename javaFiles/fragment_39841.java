String str = "ioooioooiooiiiiooo";
    StringBuilder sb = new StringBuilder();
    Matcher matcher = Pattern.compile("i+|o+").matcher(str);
    while (matcher.find()) {
        sb.append(str.charAt(matcher.start())).append(',');
    }
    if (sb.length() > 0) { 
        sb.deleteCharAt(sb.length()-1);
    }
    System.out.println(sb);