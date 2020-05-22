public class TryingTableModel extends DefaultTableModel {

public TryingTableModel(PowerpointTable pptRef, Object[][] os, Object[] os1) {
    super(os, os1);
    this.pptRef = pptRef;
}

private final PowerpointTable pptRef;

public PowerpointTable getPPTTable() {
    return this.pptRef;
}

public String testAccess() {
    return "it worked";
}