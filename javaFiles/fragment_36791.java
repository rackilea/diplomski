String[] arrays = { "A", "B", "C", "D", "E", "F", "G", "H", "I", 
                    "J", "K", "L", "M", "N" };
int half = arrays.length / 2;
for (int i = 0; i < arrays.length; i++) {
    System.out.printf("%s ", arrays[i]);
    if ((i + 1) % half == 0) {
        System.out.println();
    }
}