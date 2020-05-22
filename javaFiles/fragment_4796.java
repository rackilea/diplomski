public static void main(String[] args) {
    char[] pngheader = new char[] { 137, 80, 78, 71 }; // PNG
    char[] fileheader = new char[] { 137, 80, 78, 71 , 1, 2}; 
    char[] fileheader2 = new char[] { 131, 80, 78, 71 , 1, 2}; 

    boolean equals = Arrays.equals(Arrays.copyOf(pngheader, 4),
                                        Arrays.copyOf(fileheader, 4));
    System.out.println(equals); //prints true

    boolean equals2 = Arrays.equals(Arrays.copyOf(pngheader, 4),
                                       Arrays.copyOf(fileheader2, 4));
    System.out.println(equals2); //prints false
}