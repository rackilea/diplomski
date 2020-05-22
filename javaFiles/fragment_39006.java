String[][] strArr = new String[map.size()][2];
int i = 0;
for(Entry<Integer, String> entry : map.entrySet()){
    // current key
    Integer key = entry.getKey();
    // next key, or null if there isn't one
    Integer nextKey = map.higherKey(key);

    // you might want to define some behavior for when nextKey is null

    // build the "0-11" part (column 0)
    strArr[i][0] = key + "-" + nextKey;

    // add the "Teens" part (this is just the value from the Map Entry)
    strArr[i][1] = entry.getValue();

    // increment i for the next row in strArr
    i++;
}