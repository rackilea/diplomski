//Iterate the array
int result = 0;
for(String s: WordTokensArr) 
{

    //count the syllables and add to the result sum
    result += countSyllables(s);
}

return result;