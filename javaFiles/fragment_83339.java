public class Portal {

    private List<IAction> list = new ArrayList<IAction>();

    public Portal() {
        list.add(new IActionImpl());
    }

    public class IActionImpl implements IAction {
        public void action() {
            System.out.println("called action here");
        }
    }

    public List<IAction> getActionList() {
        return list;
    }

}