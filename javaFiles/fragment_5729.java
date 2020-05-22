public int compareTo(SendBundleQuery other) {
    int result = category1.compareTo(other.category1);
    if( result == 0 ) {
         result = category2.compareTo(other.category2);
    }
    return result;
}