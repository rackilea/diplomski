public static void main(String[] args) {
    Scanner scan = null;
    try {
        scan = new Scanner(new File("produccion.csv"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }

    if (scan == null)
        return;

    if (scan.hasNextLine()) {
        String date = scan.nextLine();
        System.out.println(date);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] tokens = line.split(",");

            String name = tokens[0];
            System.out.println(name);

            int quantity = Integer.parseInt(tokens[1].replace(" ", ""));
            System.out.println(quantity);

            double quality = Double.parseDouble(tokens[2]);
            System.out.println(quality);
            double realmQ = Double.parseDouble(tokens[3]);
            System.out.println(realmQ);
            double cost = Double.parseDouble(tokens[4].replace("$", ""));
            System.out.println(cost);

            System.out.println(date + "," + name + "," + quantity + "," + quality + "," + realmQ + "," + cost);
        }
        scan.close();
    }
}