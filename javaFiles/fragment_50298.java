@UiField CheckBox chk;
@UiField LabelElement lbll;

@Override
protected void onLoad() {
    super.onLoad();
    //This part has to happen onLoad, which is where a unique ID gets generated

    //Get the g:Checkbox's ID
    String uniqueID = chk.getElement().getFirstChildElement().getId();

    //set it to the html label
    lbll.setAttribute("for", uniqueID);
    //now the g:CheckBox has 2 labels, one of them being yours
    //and the other one being the one it comes with
}