try (FileInputStream in = new FileInputStream("testdata.txt");){

    int nextByte;
    while ((nextByte = in.read()) != -1) {
        System.out.println(nextByte + "-");
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}