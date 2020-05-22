public class RandomNumberListModel extends LoadableDetachableModel {
    private int upperBound;

    public RandomNumberListModel(int upperBound) {...}

    public void setUpperBound(int upperBound) {...}

    protected Object load() {
        // generate random number list using upper bound
        // return list
    }        
}

...

final MyTableComponent table = new MyTableComponent(new RandomNumberListModel(30));
add(table);    
AjaxLink link = new AjaxLink("myButton") {
    public void onClick(final AjaxRequestTarget target) {
        table.getModel().setUpperBound(100);
        target.addComponent(table);
    }
};
add(link);