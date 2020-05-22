int shape = 0;
    boolean inp = false;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    while (!inp) {
        try {
            System.out.println("Type in a number");
            shape = Integer.parseInt(bufferedReader.readLine());  // parse the string explicitly
            System.out.println("thanks");
        }//try
        catch (IOException e) {
            System.out.println("error");
            System.out.println("Please enter the value again:");
        }//catch
        catch (NumberFormatException e) // here you catch the exception if anything but a number was entered
        {
            System.out.println("error");
            System.out.println("Please enter the value again:");
        }//catch
        System.out.println("Shape = " + shape);
        if ((shape == 1) || (shape == 2)) {
            System.out.println("should be true");
            inp = true;
        }//if