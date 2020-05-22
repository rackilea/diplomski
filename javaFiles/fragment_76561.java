int[] index = {2, 4};
    List<Model> modelList = new ArrayList<>(Arrays.asList(new Model(1, "a"),
            new Model(2, "b"), new Model(3, "c"),
            new Model(4, "d")));
    Map<Integer, Model> modelMap = new HashMap<>();
    for (Model model : modelList) {
        modelMap.put(model.id, model);
    }
    // sort by index
    modelList.clear();
    for (int anIndex : index) {
        modelList.add(modelMap.get(anIndex));
        modelMap.remove(anIndex);
    }
    if (!modelMap.isEmpty()) {
        for (Map.Entry<Integer, Model> entry : modelMap.entrySet()) {
            modelList.add(entry.getValue());
        }
    }
    System.out.println(modelList);