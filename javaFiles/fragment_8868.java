public class PageBean {

    private List<Model> listModel;
    private List<Map> listMap;

    public String save() {
        // Move the values from listMap to listModel
        listModel = new ArrayList<Model>();
        for (Map map : listMap) {
            Model model = new Model();
            model.setStartDate(new Timestamp(((Date) map.get("startDate")).getTime());
            model.setEndDate(new Timestamp(((Date) map.get("endDate")).getTime());
            listModel.add(model);
        }
        // Process listModel to database ...
        return "next-page"
    }

    public List<Map> getListMap() {
        return listMap;
    }

    public void setListMap(List<Map> listMap) {
        this.listMap = listMap;
    }
}