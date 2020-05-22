yourSentence = input.nextLine();
// String actualSentence = yourSentence.toLowerCase();

for (int j = 0; j < yourSentence.length(); j++) 
{
    switch( yourSentence.charAt( j ) ) {
        case 'a':
        case 'A':
            ++countVowel[0];
            break;
        case 'e':
        case 'E':
            ++countVowel[1];
            break;
        case 'i':
        case 'I':
            ++countVowel[2];
            break;
        case 'o':
        case 'O':
            ++countVowel[3];
            break;
        case 'u':
        case 'U':
            ++countVowel[4];
            break;
    }
}