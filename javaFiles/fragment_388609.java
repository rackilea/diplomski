while(instructorInput.hasNextLine()) {
     Scanner lineSeperator = new Scanner(instructorInput.next());
     lineSeperator.useDelimiter(",");
     while(lineSeperator.hasNext())//use another while to iterate
        lines.add(lineSeperator.next());
}