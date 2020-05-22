private ArrayList<MyModel> models = new ArrayList<>;
private MyModel model;

// Then fill your models

// by using this way
model = new MyModel("My Signature", "My Timestamp");
models.add(model);

// or this way
model = new MyModel();
model.setSignature("My Signature");
model.setTimestamp("My Timestamp");
models.add(model);