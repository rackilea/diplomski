String stringToSearch = "About ||PrimarySchool|| %  of children in ||Country|| attend primary school. ||SecondarySchoolFemale|| % of girls and ||SecondarySchoolMale|| % of boys finish secondary school. Literacy is ||LiteracyFemale|| % for females and ||LiteracyMale|| % for males.";
Pattern pattern = Pattern.compile("\\|\\|([^|]*)\\|\\|");
Matcher matcher = pattern.matcher(stringToSearch);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}