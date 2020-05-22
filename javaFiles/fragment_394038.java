StringBuilder builder = new StringBuilder();
builder.append(list.remove(0));

for( String s : ColumnNameList) {
    builder.append(", ");
    builder.append(s);
}