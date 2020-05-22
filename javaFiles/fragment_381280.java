OMS_O05 omsMsg = (OMS_O05) next;
Terser t = new Terser(omsMsg);
for (int i = 0; i < omsMsg.getORDERReps(); i++)
{
    System.out.println(t.get("/ORDER("+i+")/ORC-2-1"));
}