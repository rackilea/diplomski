//actionDataList - Action list for printing the diffs at the end of process
DiffNode diff = ObjectDifferBuilder.buildDefault().compare(newObject, oldObject);

diff.visit(new DiffNode.Visitor() {
@Override
public void node(DiffNode node, Visit visit) {
    String fieldName = "emp."; //it should be a variable for each type of field
    if (!(node.getPath() == null || node.getPath().getLastElementSelector().toHumanReadableString().isEmpty())) {
        fieldName += node.getPath().getLastElementSelector().toHumanReadableString();

        Object baseValue = node.canonicalGet(oldObject);
        Object workingValue = node.canonicalGet(newObject);

        if (baseValue == null && workingValue instanceof String) {
            //for new values inserted
            actionDataList.add(new ActionData(fieldName, "", String.valueOf(workingValue)));
        } else if (workingValue == null && baseValue instanceof String) {                   
            // for old values deleted
            actionDataList.add(new ActionData(fieldName, String.valueOf(baseValue), ""));
        } else { // print updates
            actionDataList.add(new ActionData(fieldName, String.valueOf(baseValue), String.valueOf(workingValue))); 
        }
    }
}
});