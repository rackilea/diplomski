private NodeServiceAsync nodesRpc; //The RPC that grabs more nodes
private Tree data; //The data structure to hold all of the nodes
private ColumnTree list; //The GUI element that is shown on in the browser
public void onModuleLoad() {
    nodesRpc = (NodeServiceAsync) GWT.create(NodeService.class);
    data = new Tree();
    list = new ColumnTree;

    list.setAutoFetchData(true);
    list.setLoadDataOnDemand(true);

    list.addNodeSelectedHandler(new NodeSelectedHandler () {
        public void onNodeSelected(NodeSelectedEvent event) {
            if(/*Node is folder and hasn't been opened before*/) {
                //Get More Nodes        
                AsyncCallback<String[]> callback = new NodeGetter<String[]>();
                nodesRpc.getData(event.getNode(), callback);
            }

            else if(/*Node is not a folder (at the end) */) {
                //Do something else
            }   
        }
    });
    list.setData(data); //Make the GUI Element Represent The Data Structure
    RootPanel.get().add(list); //Add to screen
}