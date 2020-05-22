@Test
public void testSend() throws Exception
{
    MuleClient client = muleContext.getClient();

    Map<String,Object> noMsg = new HashMap<String, Object>();

    //Start the process by sending a message to the Quartz "Queue"
    MuleMessage response = client.send("vm://VM_PATH_ATTRIBUTE_VALUE",new String(""), noMsg);
}