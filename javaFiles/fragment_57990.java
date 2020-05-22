public int nextWord (int starting)
{
    // go to the next word
    do{
            starting++;
    } while(!text.get(starting).equals(' '));
    // skip the space
    starting++;
    return starting;
}