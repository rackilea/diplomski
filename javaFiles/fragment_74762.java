Scanner k = null;
try {
    k = new Scanner(System.in);
    //do stuff with k here...
} finally {
    if( k != null )
        k.close();
}