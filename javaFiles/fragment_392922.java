DateFormat df = DateFormat.getDateInstance(desiredFormat);
myString = DateFormat.getDateInstance().format(myDate);

item.add(new AjaxEditableLabel("stockEntry_date", myString)
{
@Override
public void onSubmit(AjaxRequestTarget target) {
    super.onEdit(target);
    df.parse(this.getLabel().getDefaultModelObject());//not sur if this is the correct to get the label value
    //Save to database
    }
});