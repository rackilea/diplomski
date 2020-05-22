private void PairDevice(BluetoothDevice pDevice, String pin)
{
    try
    {   
        Log.d("pairDevice()", "Start Pairing...");

        Method pairMethod = pDevice.getClass().getMethod("setPin", byte[].class);
        Boolean lReturn = (Boolean) pairMethod.invoke(pDevice, pin.getBytes("UTF8"));

        if(lReturn.booleanValue())
        {
            Log.d("pairDevice()", "Pairing Finished...");

            Method bondMethod = pDevice.getClass().getMethod("createBond");
            bondMethod.invoke(pDevice);
        }               
    }
    catch(Exception ex)
    {
        Log.e("pairDevice()", ex.getMessage());
    }
}