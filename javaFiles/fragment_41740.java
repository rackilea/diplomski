public int[] getThreeValues() { // example
    Random r = new Random();
    return new int[] { r.nextInt(100), r.nextInt(100), r.nextInt(100) };
}

public void execute() {

    JSONArray master = new JSONArray();

    for (int j=0; j<4; j++) {
        master.put(getThreeValues());
    }

    System.out.println(master);
}