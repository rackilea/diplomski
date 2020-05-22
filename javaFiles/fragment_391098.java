// provide physical location of your file, I have assumed it is present
    // in current directory
    FileReader fis = new FileReader("test.txt");
    BufferedReader br = new BufferedReader(fis);
    String line = null;
    // to keep count of shops in the file
    int shopCount = 1;
    // read line by line till you reach end of file
    while ((line = br.readLine()) != null) {
        // assuming each string starts with Shop
        if (line.startsWith("Shop")) {
            System.out.println("Shop " + shopCount);
            // assuming first line after string heading is number of
            // employees
            int numberOfEmployees = Integer.parseInt(br.readLine());
            System.out.println("Number of employees " + numberOfEmployees);
            // for each employee read their wage and salary
            for (int i = 0; i < numberOfEmployees; i++) {
                // assuming wage and number of hours are separated by a
                // space
                // wage is of type int and number of hours is of type double
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    // convert wage to int
                    int wages = Integer.parseInt(st.nextToken());
                    // convert number of hours to double
                    double hours = Double.parseDouble(st.nextToken());
                    System.out
                            .println("Wages " + wages + " Hours " + hours);

                }
            }// end reading details of each employee
                // increment shop count to read details for next shop
            shopCount++;
        }
    }