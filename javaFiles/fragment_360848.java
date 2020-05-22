void letterChain(string stack[5], int k, const vector<string> &words)
{
    if ( k == 5 ) // have 5 words, print solution
    {
        for ( int i = 0; i < 5; ++i )
            cout << stack[i] << " ";
        cout << endl;

        return;
    }

    for ( int i = 0; i < words.size(); ++i ) // try to put a word at the current level of the stack
    {
        // if words[i] is already used, we cant use it again (if we can, just remove this part)
        bool used = false;
        for ( int j = 0; j < k; ++j )
            if ( stack[j] == words[i] )
                used = true;

        if ( !used ) // remove this if you can use a word multiple times
        {
            if ( k == 0 || words[i][0] == stack[k - 1][2] ) // if the letters match
            {
                stack[k] = words[i]; // add it to the stack
                letterChain(stack, k + 1, words); // recursive call
            }
        }
    }
}

int main()
{
    vector<string> words;
    words.push_back("CAT");
    words.push_back("TOW");
    words.push_back("WAR");
    words.push_back("RAD");
    words.push_back("DOG");
    words.push_back("GOD");
    words.push_back("RAG");
    words.push_back("RAR");

    string stack[5];

    letterChain(stack, 0, words);
}