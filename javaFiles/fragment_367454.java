static void readLines(ArrayList<Picture> collection) throws Exception {
    Picture<Shape> pictures = null; //Just do null here
    Scanner input = new Scanner(System.in);

    System.out.print("Please enter the file name ---> ");
    fileName = input.next();

    FileReader fr = new FileReader(fileName);
    BufferedReader inFile = new BufferedReader(fr);

    // loop through lines
    while ((line = inFile.readLine()) != null) {
        System.out.println(line);
        if (line.startsWith("start picture")) {
            String picName = line.split(" ")[2];
            pictures = new Picture<Shape>();

            //set the name here
            pictures.setName(picName);    

            //here it works
            System.out.print(pictures.getName());
        }
        else {
            txtAnalysis(line, collection,pictures);
        }
    }

    // close file
    inFile.close();

}

public static void txtAnalysis(String name, ArrayList<Picture> collection, Picture<Shape> pictures ) {


    if (line.startsWith("circle")) {
        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        int z = Integer.parseInt(parts[3]);


        //new object circle
        Circle c1 = new Circle("circ", x, y, z); 

        //add object
        System.out.println("calling add " + c1);
        pictures.addShape(c1);


    }
    else if (line.startsWith("rectangle")) {

        String[] parts = line.split(" ");
        int x = Integer.parseInt(parts[1]);
        int y = Integer.parseInt(parts[2]);
        int z = Integer.parseInt(parts[3]);

        //new object rectangle
        Rectangle r1 = new Rectangle("rect", x, y, z); // small and upper

        //add object

        pictures.addShape(r1);  
    }

    else if (line.startsWith("draw")) {
        collection.add(pictures);

        //problem here
        pictures.draw(pictures.getName());


        //returns null!!!!!
        System.out.print(pictures.getName());

        line = null;
    }

    else {
        System.out.println("end of loop");

    }

}