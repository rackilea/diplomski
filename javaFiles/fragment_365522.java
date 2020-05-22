for(int j=0;j<array_list.size();j++)
{
    boolean allIn = true;
    for (String phoneName: brand_list)
    {
        String[] phoneWords = phoneName.split(" ");

        for (int wordIndex = 0; wordIndex < phoneWords.length; wordIndex++)
        {
            String regexPattern = "(.*)" + phoneWords[wordIndex] + "(.*)";
            pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(array_list.get(j).toString());

            if (!matcher.find()) 
            {
                allIn = false;
            }
        }
    }
    System.out.println(allIn); // should be false here if one of the words
                               // couldn't be found in the strings and
                               // should be true otherwise
}