public static void aMethod(){
    RandomAccessFile f = new RandomAccessFile(new File("whereDidIPutTHatFile"), "rw");
    long aPositionWhereIWantToGo = 99;
    f.seek(aPositionWhereIWantToGo); // this basically reads n bytes in the file
    f.write("Im in teh fil, writn bites".getBytes());
    f.close();
}