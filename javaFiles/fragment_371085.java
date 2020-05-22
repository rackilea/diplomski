long start = System.nanoTime();
while((line = br.readLine()) != null) {
    if(System.nanoTime() - start > 600E9) { //More than 10 minutes past the start.
        throw new Exception("Timeout!");
    }
    ... //Process the line.
}