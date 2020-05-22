private List<InputNode> input = new ArrayList<InputNode>(); // Input Nodes

for (int n = 0; n < noOfNodes; n++){
    input.add(new InputNode(0.0));
}
//Create 8 HiddenNode objects **HAVING PROBLEMS HERE**
int noOfHiddenNodes = (int)math.floor(2.*noOfNodes/3.);
for (int o = 0; o < noOfHiddenNodes; o++){
    hiddenNodeLayer.add(new HiddenNode(input));
}