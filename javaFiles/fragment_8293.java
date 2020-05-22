foreach (List<ItemNY> level in highU.getLevels())
{
    var filteredItems = new List<ItemNY>();

    foreach (var c in level)
    {
        foreach (TransactionTP transaction in database.getTransactions())
        {
            int transactionUtility = 0;
            int matchesCount = 0;
            for (int i = 0; i < transaction.size(); i++)
            {
                if (c.getItems().Contains(transaction.get(i).item))
                {
                    transactionUtility += transaction.getItemsUtilities()[i].utility;
                    matchesCount++;
                }
            }

            if (matchesCount == c.size())
            {
                c.incrementUtility(transactionUtility);
            }
        }

        if (c.getU() < min)
        {
            filteredItems.Add(c);
            highU.decreaseCount();
        }
    }

    foreach (var item in filteredItems)
    {
        level.Remove(item);
    } 
}