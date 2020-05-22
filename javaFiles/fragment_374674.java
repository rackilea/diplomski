public void setHintWord(){
    correctLetters = new char[secretWord.length()];
    for(int i=0;i<secretWord.length();i++)
    {
        hintWord+="*";
        correctLetters[i] += '*';
    }
}