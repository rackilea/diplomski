boolean found = false;
for (j=0; j < word.length(); j++)
{    
    if (word.charAt(j) == asciiToChar)
    {
        found = true;
        break; // no need to search further
    }
}
if(!found) error++; // if the letter isn't used, add 1 error