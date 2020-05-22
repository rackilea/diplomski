String fileName = "model/testModel.model";

try {
    ClassLoader classLoader = YourClass.class.getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    SerializedClassifier model = new SerializedClassifier();
    model.setModelFile(file);
    return model;
}
catch (Exception e) {
    e.printStackTrace();
}