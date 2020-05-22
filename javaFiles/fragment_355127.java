public static void main(String[] args) throws IOException {
    int sampleSize = 3000;
    int fileSize = 50000;
    int[] linesNumber = new int[sampleSize];
    Random r = new Random();
    for (int i = 0; i < linesNumber.length; i++) {
        linesNumber[i] = r.nextInt(fileSize);

    }
    List<Integer> list = Arrays.stream(linesNumber).boxed().collect(Collectors.toList());
    Collections.sort(list);

    BufferedWriter outputWriter = Files.newBufferedWriter(Paths.get("localOutput/output.txt"));
    long t1 = System.currentTimeMillis();
    try(BufferedReader reader = new BufferedReader(new FileReader("extremely large file.txt")))
    {
        int index = 0;//keep track of what item we're on in the list
        int currentIndex = 0;//keep track of what line we're on in the input file
        while(index < sampleSize)//while we still haven't finished the list
        {
            if(currentIndex == list.get(index))//if we reach a line
            {
                outputWriter.write(reader.readLine());
                outputWriter.write("\n");//readLine doesn't include the newline characters
                while(index < sampleSize && list.get(index) <= currentIndex)//have to put this here in case of duplicates in the list
                    index++;
            }
            else
                reader.readLine();//readLine is dang fast. There may be faster ways to skip a line, but this is still plenty fast.
            currentIndex++;
        }
    } catch (Exception e) {
        System.err.println(e);
    }
    outputWriter.close();
    System.out.println(String.format("Took %d milliseconds", System.currentTimeMillis() - t1));
}