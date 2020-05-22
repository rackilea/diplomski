public class PageBean {

    private List<Model> listModel;
    private List<ModelMapper> listModelMapper;

    public String save() {
        // Move the values from listModelMapper to listModel
        listModel = new ArrayList<Model>();
        for (ModelMapper modelMapper : listModelBinder) {
            Model model = new Model();
            model.setStartDate(new Timestamp(modelMapper.getStartdate().getTime());
            model.setEndDate(new Timestamp(modelMapper.getEndDate().getTime());
            listModel.add(model);
        }
        // Process listModel to database ...
        return "next-page"
    }

    public List<ModelMapper> getListModelMapper() {
        return listModelMapper;
    }

    public void setListModelMapper(List<ModelMapper> listModelMapper) {
        this.listModelMapper = listModelMapper;
    }
}