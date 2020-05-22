public void write() {
    try {
        RandomAccessFile file = new RandomAccessFile("temp.txt", "rw");
        System.out.println("Writing these ints to file");
        file.seek(0);
        for (int i = 0; i < 10; i++) {              
            file.writeInt(i);
            System.out.printf(i + " ");
        }           
    } catch (IOException ex) {
        ex.printStackTrace();
        System.exit(0);
    }
}

public int[] readRandom() {
    System.out.println("Unsorted ints found in random file:");
    int[] randomInts = new int[10];
    try {
        RandomAccessFile file = new RandomAccessFile("temp.txt", "rw");
        long filePointer = file.getFilePointer();

        file.seek(0);
        for (int i=0; i<10; i++){
            randomInts[i] = file.readInt();
            System.out.printf(randomInts[i] + " ");
        }               
    } catch (IOException ex) {
        ex.printStackTrace();
        System.exit(0);
    }
    return randomInts;
}