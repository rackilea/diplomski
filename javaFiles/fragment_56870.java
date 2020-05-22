class Paths {
    private static ResourceBundle rs = ResourceBundle.getBundle("file.paths");
    public static String get( String key ) {
        rs.getString( key );
    }
}