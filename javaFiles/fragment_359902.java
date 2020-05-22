@ParentPackage("json-default")
@Result(type = "json", params = {
        "excludeProperties",
        "^inventoryHistory\\[\\d+\\]\\.intrnmst, selectedTransactionNames, transactionNames"
    })
public class InventoryHistoryAction extends ActionSupport {
...