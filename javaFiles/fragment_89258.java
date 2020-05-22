public class GsonProgram {

    public static void main(String... args) throws Exception {
        Entry entry1 = new Entry();
        entry1.setChildren("Salary");
        Entry entry2 = new Entry();
        entry2.setChildren("Salary");
        Entry entry3 = new Entry();
        entry3.setChildren("Work");
        Entry entry4 = new Entry();
        entry4.setChildren("Doller");
        EntryListContainer entryListContainer = new EntryListContainer();
        ArrayList<Entry> entryList1 = new ArrayList<Entry>();


        entryList1.add(entry1);
        entryList1.add(entry2);
        entryList1.add(entry3);
        entryList1.add(entry4);

        entryListContainer.setEntryList1(entryList1);
        entryListContainer.setName("Employee");

        Map<String, String> mapping = new HashMap<String, String>();
        mapping.put("entryList1", "name");



      Gson gson = new GsonBuilder().serializeNulls().setFieldNamingStrategy(new    DynamicFieldNamingStrategy(mapping)).create();
        System.out.println(gson.toJson(entryListContainer));
    }
}