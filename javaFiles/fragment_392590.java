public static void main(String[] args) throws IOException
{
    try {
        List<Double> list = new ArrayList<>();

        // New BufferedReader.
        BufferedReader reader = new BufferedReader(new FileReader(
                "filename.txt"));

        // Add all lines from file to ArrayList.
        String line = null;
        while ((line = reader.readLine()) != null) {
                list.addAll(Arrays.asList(line.split("\\s+")).stream().map(p -> Double.parseDouble(p.trim())).collect(Collectors.toList()));
        }

        // Close it.
        reader.close();

        Random rand = new Random();
        Double randomElement = list.get(rand.nextInt(list.size()));
        System.out.println(randomElement);

    }catch (IOException e){
        System.out.println(e);
    }


}