public IEnumerable<int> GetSomeCollection()
{
    // This could return any type of int collection.  Here it returns an array
    return new int[] { 5, 12, 7, 14, 2, 3, 7, 99 };
}

IEnumerable<int> someCollectionOfInts = GetSomeCollection();

IEnumerable<string> itemsLessThanFive = from i in someCollectionOfInts
                                        where i < 5
                                        select i.ToString();

foreach(string item in itemsLessThanFive)
{
    Console.WriteLine(item);
}