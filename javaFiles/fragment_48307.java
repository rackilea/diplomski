void flattenFlows(Flows flows, List<Flows> flowsList)
{
    flowsList.add(flows);
    for (Flows f: flows.listOfFlows) {
        flattenFlows(f, flowsList);
    }
}