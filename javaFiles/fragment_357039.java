String EXAMPLE_TEST = "\"they used to have journalistic integrity... what happened\" @cbcnews";
Pattern ptrn = Pattern.compile("@\\w+(?=(?:[^\"]|\"[^\"]*\")*$)");
Matcher matcher = ptrn.matcher(EXAMPLE_TEST);
if (matcher.find()) {
     System.out.println("Found!");
}