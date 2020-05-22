String[] price = new String[hashMapArrayList2.size()];
String[] categoryName = new String[hashMapArrayList2.size()];
String[] productName = new String[hashMapArrayList2.size()];
String[] catalogName = new String[hashMapArrayList2.size()];

int i=0;
for (Map<String, String> item : hashMapArrayList2) {
    price[i] = item.get("Price");
    categoryName[i] = item.get("CategoryName");
    productName[i] = item.get("ProductName");
    catalogName[i] = item.get("CatalogName");
    i++;
}