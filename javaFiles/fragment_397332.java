Matcher matcher = Pattern.compile(pattern).matcher();

    if (matcher.matches()) {
        String s[] = new String[matcher.groupCount()) {
           for (int i=0;i<matches.groupCount();i++) {
               s[i] = matcher.group(i);
            }
         }
    }