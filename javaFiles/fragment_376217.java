while(file.hasNextLine()){
    final String line = file.nextLine();
    if(line.isEmpty()){
        continue;
    }
    String[] words = line.split(" ");
    for(int i = 0; i < words.length; i++){
        System.out.print(words[i]);
    }
}