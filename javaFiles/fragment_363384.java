while(start!=-1)
{
    sentence = sentence.substring(0, start) + sentence.substring(start+word.length());
    end = start+word.length();
    if(end>=sentence.length())
        break;
    start = sentence.indexOf(word, 0); //this line must be 0 or nothing
}