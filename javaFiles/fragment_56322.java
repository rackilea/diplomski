String phrase = "THCUSATTYYE";
int useThisStart = phrase.indexOf("USA");
if (useThisStart > -1) {
    for (int i = useThisStart; i < useThisStart + 3; i++) {
        System.out.println(phrase.substring(i));
    }
}