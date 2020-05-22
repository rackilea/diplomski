public static String parseString(String grammar, String interoperation) {
        if (grammar==null || interoperation == null || interoperation.equals("{}"))
            return null;

        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("[^\\s\"'\\[]+|\\[([^\\]]*)\\]|'([^']*)'");
        Matcher regexMatcher = regex.matcher(grammar);
        while (regexMatcher.find()) {
            if (regexMatcher.group(1) != null) {
                matchList.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                matchList.add(regexMatcher.group(2));
            } else {
                matchList.add(regexMatcher.group());
            }
        } 

        String[] xx = matchList.toArray(new String[0]);
        String wordsExpanded = String.join(" | ",xx);

        interoperation= interoperation.replaceAll("\\{", "")
                                        .replaceAll("\\}", "");

        Set<String> allInterOperations = Arrays.asList(interoperation.split(">"))
            .stream()
            .map(eachInterOperation -> {
            eachInterOperation = eachInterOperation.trim();
            eachInterOperation = eachInterOperation + ">";
            return eachInterOperation;
        }).collect(Collectors.toSet());

        String result = Arrays.asList(wordsExpanded.split("\\|"))
            .stream()
            .map(eachWordExpanded -> {
                eachWordExpanded = eachWordExpanded.trim();
                eachWordExpanded = eachWordExpanded.replaceAll("\\{", "");
                eachWordExpanded = eachWordExpanded.replaceAll("\\}", "");

                for(String eachInterOperation : allInterOperations){
                    if(eachWordExpanded.contains(eachInterOperation)){
                        Pattern pattern = Pattern.compile("(\\(.*?\\))\\s*(<.*?>)");
                        Matcher matcher = pattern.matcher(eachWordExpanded);
                        while (matcher.find()) {
                            if (matcher.group(2).equals(eachInterOperation)) 
                                eachWordExpanded = matcher.group(1).replaceAll("[\\(\\)]", "").trim();
                        }
                    }else{
                        continue;
                    }
                }
                return eachWordExpanded;
            }).collect(Collectors.joining("|"));

        return result;
    }   

}