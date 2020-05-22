int index = 1;
while ((line = br.readLine()) != null) {
    football = line.split(csvSplit);
    if(football[1].equals("Chelsea") {
        System.out.println("I found Chelsea on line " + index);
    }
    index++;
}