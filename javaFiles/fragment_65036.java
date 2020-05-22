int counter = 0;
while( (line = br.readLine())!= null ){
    String[] newData = line.split("\\s+");
    words[counter] = newData;
    counter++;
    System.out.println(Arrays.toString(newData)); //prints out array
}