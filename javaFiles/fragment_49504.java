String caseDefendant = "vs."; 
Pattern caseDefendantPattern = Pattern.compile("(?<="+Pattern.quote(caseDefendant)+").*?(?=</span>)");
Matcher caseDefendantMatcher = caseDefendantPattern.matcher(pageContentString); 

if (caseDefendantMatcher.find()) {
    docketFile.write(caseDefendantMatcher.group().toString()); 
}

docketFile.write("^");