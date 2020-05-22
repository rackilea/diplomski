static void testData(){

    properties=new HashMap<>();
    Random rand=new Random();
    Task t;
    Property p;

    for (int i=0;i<10;i++){
        String propertyName = "Property_"+i;
        //public Property(String name, int size, boolean rental, String postcode, String block, String unit) {
        p=new Property("CONDO",propertyName,20200,true,"280009","14","01-05");
        //public Task(char type, int priority, String description) {
        t=new Task('M',3,"This s a dummy task"+rand.nextInt());
        p.getTasks().add(t);

        properties.put(propertyName, p);
    }
}