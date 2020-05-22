Set<String> words = new TreeSet<>();

try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

    String line;
    while((line = reader.readLine()) != null && !line.equals("exit")){

        words.addAll( //add elements from List<String> into Set
                Arrays.asList( //change array with words into List<String>
                    line.split("\\s+") //split line by space -> String[] (array with words)
                )
        );

    }

}catch(Exception e){
    e.printStackTrace();
}

for(String word : words){
    System.out.println(word);
}