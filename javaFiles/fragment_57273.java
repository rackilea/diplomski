//Created a class level hashmap
public static Map<String,PolicyNodeInfo> executedElementMap=new HashMap<String,PolicyNodeInfo>();  

// Whichever node is being traversed is stored in the map.
// Before Traversing any node , just checking whether the node has already been traversed , if traversed just add the node and skip the traversing.

private static PolicyNodeInfo[] mapPolicySteps(PolicyTreatmentNodeInfo fromObj)

{
    List<PolicyNodeInfo> tmpList = new ArrayList<PolicyNodeInfo>();
    PolicyTreatmentNodeInfo[] childrens = fromObj.getChildrenPolicyInfo(); // Get object policy node children
    if(childrens != null) //if there are no children return empty list
    {
        for(PolicyTreatmentNodeInfo child : childrens) //for each children map the object and recursively go over his children
        {
            if(null!=child)
                {
                Boolean isNodeTraversed= executedElementMap.containsKey(child.getStepName());
                  if(!isNodeTraversed)
                  {
                    executedElementMap.put(child.getStepName(), child);
                    if(X3ServerUtil.isStringNotEmptyNotNull(child.getStepName())&& !child.getStepName().startsWith(PREFIX_FOR_NON_OPERATION_STEP)) //case child is not null (edge) or it's not non operation step (need to ignore)
                    {   
                        int index = tmpList.size();
                        tmpList.add(insertStep(child)); //insert current node
                        tmpList.get(index).setPolicyTreatmentNodeInfoList(mapPolicySteps(child)); //insert recursively all child nodes
                    }
                    else
                    {
                        handleDummyChildNodeInsertion(tmpList, child);
                    }
                 }  
                 else{
                      tmpList.add(insertStep(child));  
                     }
              }
        }
    }
    return tmpList.toArray(new PolicyNodeInfo[tmpList.size()]);
}