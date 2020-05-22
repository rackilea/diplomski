public class Workout implements Serializable


//To pass:
intent.putExtra("YourClass", obj);

// To retrieve object in second Activity
getIntent().getSerializableExtra("YourClass");