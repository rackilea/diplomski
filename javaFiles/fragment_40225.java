String[] array = {"8C", "D9", "26", "1D", "69", "B7", "96", "DB"};

StringBuilder output = new StringBuilder();
for ( String hex : array ) {
    output.append( (char)Integer.parseInt( hex, 16 ) );
}