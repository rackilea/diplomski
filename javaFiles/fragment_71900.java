for (Pattern scriptPattern : patterns){
                    Matcher m = scriptPattern.matcher(line)
                     while (m.find()) {
                 String d = m.group();
                 if(d != null) {
                     System.out.print(d);

                 }

            }
    }