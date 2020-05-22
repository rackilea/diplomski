try {
    FileWriter splitsWriter= new FileWriter("a.txt");
    for(int i=0;i<theSplits.size();i++){
        splitsWriter.write(theSplits.get(i));
    }
} catch (IOException e) {
    // Do something to handle the exception
}