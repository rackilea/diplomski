void flattenFlows(Flows flows, List<Flows> flowsList)
{
    flowsList.add(flows);
    if(flow.listOfFlows!=null) {
        for (Flows f: flows.listOfFlows) {
            flattenFlows(f, flowsList);
        }
    }
}