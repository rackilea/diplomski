try {
        adapter = new InfoTodayAdapter(this,getData());
    } catch (IOException e) {
        e.printStackTrace();
        data = new ArrayList<>(); // Added this line
        adapter = new InfoTodayAdapter(this,data); // Added this line as well
    }