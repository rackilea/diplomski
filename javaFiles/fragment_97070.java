for (TermSuggestion.Entry entry : termSuggestion.getEntries())
{ 
    for (TermSuggestion.Entry.Option option : entry)
    { 
        String suggestText = option.getText().string();
        if (Character.isAlphabetic(suggestText.charAt(suggestText.length()))
        {
            System.out.println("Print String--->  "+result);
        }
    }
}