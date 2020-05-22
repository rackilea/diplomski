try {
    int count = stream.readInt();
    for( int i = 0; i < count; ++i ){
        strbuilder.append(Character.toChars(stream.read()));
    }
    return strbuilder.toString();
}