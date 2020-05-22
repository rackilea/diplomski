int row = 0;
int column = 0;
whileloop: while (/* test something */)
{
    for ( ; row < myEntries.size(); ++row)
    {
        for ( ; row < myEntries.get(row)[column]; ++column)
        {
            /* do stuff */;
        }
    }
}