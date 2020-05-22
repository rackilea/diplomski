BufferedReader b = new BufferedReader(
            new InputStreamReader(
                    new FileInputStream(
                            "D:/git-repo/general/misc_test/src/java/com/greytip/cougar/module/test/v2/controller/so/dump/data.txt")));

    List<String> lines = new ArrayList<String>();

    String line = null;
    while ((line = b.readLine()) != null) {
        lines.add(line);
    }

    String[] stringArray = lines.toArray(new String[lines.size()]);
    double[] doubleArray = new double[stringArray.length];
    for (int i = 0; i < stringArray.length; i++) {
        doubleArray[i] = Double.parseDouble(stringArray[i]);
    }

    for (int i = 0; i < doubleArray.length; i++) {
        System.out.println(doubleArray[i]);
    }