final ListLoader<BaseListLoadResult<BeanModel>> loader = new BaseListLoader<BaseListLoadResult<BeanModel>>(
        proxy, new MyBeanModelReader());
loader.load();
new ListStore<BeanModel>(loader); //TODO

public class MyBeanModelReader implements DataReader<List<BeanModel>> {

    private BeanModelReader reader = new BeanModelReader();

    public boolean isFactoryForEachBean() {
        return reader.isFactoryForEachBean();
    }

    public List<BeanModel> read(Object loadConfig, Object data) {
        List<BeanModel> newModelsData = new ArrayList<BeanModel>();
        ListLoadResult<ModelData> models = reader.read(loadConfig, data);
        List<ModelData> modelsData = models.getData();
        for (ModelData modelData : modelsData) {
            BeanModel model = (BeanModel) modelData;
            Response response = (Response) model.getBean();
            model.set("id", response.getId());
            model.set("locale", response.getLocale());
            model.set("QuestionResponse15", response.getQuestionResponse().get(...));  //retrieve the QR you want
            newModelsData.add(model);
        }
        return newModelsData;
    }

    public void setFactoryForEachBean(boolean factoryForEachBean) {
        reader.setFactoryForEachBean(factoryForEachBean);
    }

}