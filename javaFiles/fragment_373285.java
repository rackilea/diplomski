public static final Object monitor = new Object();

public static void writeMasterCompetitorsFile(Context context, List<Competitor> competitors) {

    File file = new File(context.getFilesDir(), MASTER_COMP_FILE);

    synchronized (monitor) {
        String jsonString = new Gson().toJson(competitors);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

public static List getMasterCompetitorsList(Context context) {
    List<Competitor> list = new ArrayList<>();
    File file = new File(context.getFilesDir(), MASTER_COMP_FILE);

    synchronized (monitor) {
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String compList = reader.readLine();
                Type competitorListType = new TypeToken<List<Competitor>>() {
                }.getType();
                list = new Gson().fromJson(compList, competitorListType);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            writeMasterCompetitorsFile(context, list);
        }
    }
}