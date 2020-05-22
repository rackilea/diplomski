public class AnyPage extends WebPage{

public AnyPage(PageParameters pageParameters){
    super(pageParameters);
}
@Override
public void onConfigure(){
    // Clear the List of choices here
    this.listDropdown.clear();
    // set dropdown model to null
    this.setDropdown(null);
}