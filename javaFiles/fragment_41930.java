@Override
public void process(Model model) {
     ...
    Model mergedModel = session.merge(model);

    mergedModel.addEntity(createEntity());
    ...
}