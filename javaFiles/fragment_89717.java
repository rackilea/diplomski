public class StackOverflowExample {

    private String json;

    public String save(View v) {
        // beginning of implementation ommitted for brevity
        Gson gson = new Gson();
        json = gson.toJson(c); // save the JSON in your class attribute
        System.out.print(json);
    }

    public void read(View v) {
        Toast.makeText(this, json, Toast.LENGTH_LONG).show();
    }

}