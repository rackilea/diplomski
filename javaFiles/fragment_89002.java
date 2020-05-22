private class LetterHandler implements ActionListener
{
    private char letterVal;

    public LetterHandler(char lv)
    {
        letterVal = lv;
    }

    // checks if clicked button has the correct value as word char
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int x = 0; x < selectedWord.wordLength; x++)
        {
            if (selectedWord.wordValue.charAt(x) == letterVal)
            {
                wordSpacesArray.get(x).setText(String.valueOf(letterVal));
            }
        }
        checkWin();
        triesLeft--;
        triesLeftLabel.setText(String.valueOf(triesLeft));
    }

    // finds if all jlabels are complete or not
    public void checkWin()
    {
        for (int x = 0; x < wordSpacesArray.size(); x++)
        {
            String charVal = wordSpacesArray.get(x).getText();
            if (charVal.equals("?"))
            {
                // There is still an incomplete label
                return; 
            }
        }

        // When it reaches this line, no incomplete label was found
        System.out.println("You won");
    }
}