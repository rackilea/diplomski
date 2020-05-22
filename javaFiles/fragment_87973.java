public static void remove(String wd) {
    boolean done = false;
    String word = wd.toLowerCase();
    String[] line = word.split("[,\\s]+");
    for (int j = 0; j < line.length; j++) {
        map.remove(line[j]);
    }
    try {
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(map.toString());
        bw.close();
        done = true;
    } catch (Exception e) {
        e.printStackTrace();
    }
    if (done == true) {
        System.out.println("Success");
    }
}