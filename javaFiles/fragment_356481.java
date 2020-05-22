while ((line = reader.readLine()) != null) {
    itemClass item = new itemClass();
    item.index = line;
    item.location = reader.readLine();
    item.item = reader.readLine();
    item.description = reader.readLine();
    m[i] = item;
    i++;
}