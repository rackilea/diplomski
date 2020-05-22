finally {
        csvReader.close();
        csvWriter.close();
        System.out.println("success");
        System.exit(0); <--- here
    }