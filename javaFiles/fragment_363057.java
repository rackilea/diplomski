try {
        String firstName = "Joe";
        String lastName = "Doe";
        String regNum = "123";

        File file = new File("/home/parvin/Desktop/filename.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("FirstName\t LastName\t RegNum\t \n");
        bw.write(firstName + "\t" + lastName + "\t" + regNum + "\t" + "\n");
        bw.newLine();
        bw.close();

        System.out.println("Done");

    } catch (IOException e) {
        e.printStackTrace();
    }