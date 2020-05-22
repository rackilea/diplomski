final String string = readString("myFile") // return type is String
final List<Object> list = readList("myFile") // return type is List<Object> or List<T>

@NonNull
public String readString(@NonNull String fileName) {
    // Implementation
    return string;
}

@NonNull
public List<Object> readList(@NonNull String fileName) {
    final String string = readString(fileName);
    // Parsing logic to convert to a List
    return list;
}