String findFirstTitleInList(String searchString, List<String> titles)
{
    for(int i = 0; i < titles.size(); i++) //foreach loop might not be ordered on List
        if(searchString.contains(titles.get(i)))
            return titles.get(i);

    //does not contain
    return null;
}