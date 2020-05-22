String Default;
        int i = 0;
        String [] resultArray = new String[10];
        while ((Default = reader.readLine()) != null) {
            resultArray[i] = Default;
            i++;

        }
        for (int j = 0; j < i; ++j) {
            System.out.println("Element at index " + j + ": " + resultArray[j]);
        }