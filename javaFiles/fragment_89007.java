ArrayList<String> key = new ArrayList<String>();
    ArrayList<String> value = new ArrayList<String>();

    ArrayList<Object> obj = new ArrayList<Object>();
    ArrayList<Object> objected = new ArrayList<Object>();
    opencvmatrix mean = new opencvmatrix();
    opencvmatrix eigenValues = new opencvmatrix();
    opencvmatrix eigenVectors = new opencvmatrix();
    ArrayList<Object> opencvmatrix4 = new ArrayList<Object>();
    opencvmatrix labels = new opencvmatrix();
     opencvmatrix opencvmatrix6 = new opencvmatrix();
    ArrayList<ArrayList<Double>> projections = new ArrayList<ArrayList<Double>>();
    Yaml yaml = new Yaml();

    try {
        InputStream ios = new FileInputStream(new File(fileName));
        // Parse the YAML file and return the output as a series of Maps and Lists
        Map< String, Object> result = (Map< String, Object>) yaml.load(ios);
        for (Object name : result.keySet()) {
            key.add(name.toString());
            obj.add(result.get(name));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    File file = new File("eigenvalues.txt");
    // creates the file
    file.createNewFile();
    // creates a FileWriter Object
    FileWriter writer = new FileWriter(file);
        // Writes the content to the file


    mean = (opencvmatrix) (obj.get(0));
    eigenValues = (opencvmatrix) (obj.get(1));
    eigenVectors = (opencvmatrix) (obj.get(2));

    opencvmatrix4 = (ArrayList<Object>) obj.get(3);

    for(int i=0; i<opencvmatrix4.size(); i++){

        opencvmatrix6 = (opencvmatrix)opencvmatrix4.get(i);
        projections.add(opencvmatrix6.data);
    }

    //System.out.println(projections.get(0).size());

    labels = (opencvmatrix) (obj.get(4));
    //System.out.println(obj3.data.size());

    writer.write(eigenVectors.data.get(0) + "      ");
    temp.add(eigenVectors.data.get(0));
    eigenMatrix.add(temp);

    for (int i = 1; i < eigenVectors.data.size(); i++) {

        if (i % 3600 == 0) {
            writer.write("\n");
            eigenMatrix.add(temp);
            temp.clear();

        }

         writer.write(eigenVectors.data.get(i) + "      ");
        temp.add(eigenVectors.data.get(i));

    }
    writer.flush();
    writer.close();