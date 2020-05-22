public ProductLookup(int maxSize, DictionaryADT<String,StockItem> dictionary) {
    this.dictionary = dictionary;
    this(maxSize);
}

// Constructor.  There is no argument-less constructor, or default size
public ProductLookup(int maxSize) {
    this.maxSize = maxSize;
}