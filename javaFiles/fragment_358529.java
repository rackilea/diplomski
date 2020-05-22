private final List<DimSpecific> specificList;
private DimSpecific specificPtr = new DimSpecific(); // or init to some default value
private IModel<DimSpecific> dropdownModel = new PropertyModel<DimSpecific>(this, "specficicPtr");
...
specificList = roles.getSpecificList();
DropDownChoice specific = new DropDownChoice("specific", dropdownModel , specificList, new ChoiceRenderer<DimSpecific>("code", "id"));
Form form = new Form("frm_0_07"){
    @Override
    protected void onSubmit() {
        String specificSelected = dropdownModel.getObject();
    }
}