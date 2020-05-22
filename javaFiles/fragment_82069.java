public List<CallFlowResource> getCallFlow(CallFlowObject obj)
{
   List<CallFlowResource> callFlowRes = new ArrayList<>();
   for(int i = 0; i<size; i++)
   {
       callFlowRes.add(obj.GetterMethodForCFR(i));
   }
   return callFlowRes;
}