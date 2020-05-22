public static void importData(Context context) {
    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(context.getAssets().open("high.txt")));

        String line;

        while ((line = br.readLine()) != null) {
            String[] columns = line.split(",");

            Model model = new Model();

            model.date = DateUtil.getCalendar(columns[0], "MM/dd/yyyy");
            model.name = columns[1];

            dbHelper.insertModel(model);
        }

    } catch (IOException e) {
        e.printStackTrace();
    }
}