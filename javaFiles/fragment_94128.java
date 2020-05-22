public static void main(String[] args) {
        try{
            String url="http://www.tlu.ee/~jaagup/veeb1/loomad.txt";
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            String line= br.readLine();
            System.out.println("Tulbad: " + line);

            // almost the array :)
            List<Animal> animals = new ArrayList<>();

            // read to the end of file
            while ((line = br.readLine()) != null) {
                final String[] temp = line.split(",");

                Animal animal = new Animal();

                animal.setSpecies(temp[0]);
                animal.setWeight(Integer.valueOf(temp[1]));
                animal.setSize(Integer.valueOf(temp[2]));

                animals.add(animal);
            }

            br.close();

            // display the list
            animals.forEach(System.out::println);

        } catch(Exception ex){
            System.out.println("Probleem: "+ ex);
            ex.printStackTrace();
        }
    }
}