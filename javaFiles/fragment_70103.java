String url = "https://" + host + "/sdk/vimService";
    System.out.println("In main function");
ServiceInstance si = null;
ManagedEntity[] managedEntities = null;
ManagedEntity[] hostmanagedEntities = null;
try {
si = new ServiceInstance(new URL(url), user, pass,true);

hostmanagedEntities = new InventoryNavigator(
si.getRootFolder()).searchManagedEntities("HostSystem");

//process each host and call getVMDetails function to get details of all host       
for (ManagedEntity managedEntity : hostmanagedEntities) {
HostSystem hostsystemobj = (HostSystem) managedEntity;
System.out.println("Host: '" + hostsystemobj.getName() + "'");
hostname = hostsystemobj.getName();
String ESXhostname = hostsystemobj.getName();
HostHardwareInfo hw = hostsystemobj.getHardware();
String ESXhostmodel = hw.getSystemInfo().getModel();
String Vendor = hw.getSystemInfo().getVendor();
//print all above variables. 
long ESXhostmem = hw.getMemorySize();

short ESXhostcores = hw.getCpuInfo().getNumCpuCores();
long ESXMHZ = hw.getCpuInfo().getHz();

  //call function that collects vms data for specific host
getVMDetailsInv(si,hostsystemobj.getName());

}
}
catch (InvalidProperty e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (RuntimeFault e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (RemoteException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (MalformedURLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

private void getVMDetailsInv(ServiceInstance si,String name) {

HostSystem myhost;
System.out.println("host name from details function  is .. " + name);
try {
myhost = (HostSystem) new        InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem",name);
System.out.println("myhost is .. " + myhost);
ManagedEntity[] hostSpecificEntities = new InventoryNavigator(myhost).searchManagedEntities("VirtualMachine");

for (int i = 0; i < hostSpecificEntities.length; i++) {
    VirtualMachine vm = (VirtualMachine) hostSpecificEntities[i];
    String macAddress="";
    for(VirtualDevice vd:vm.getConfig().getHardware().getDevice()){
    try {
    VirtualEthernetCard vEth=(VirtualEthernetCard)vd;
     macAddress=vEth.macAddress;
    }
    catch(Exception e){}
    }
System.out.println("Name : "+vm.getName());
String vmVersion = vm.getConfig().version;
System.out.println("vm wayer version is ..from inventory.. "+ vm.getConfig().version);
System.out.println("geust os uuid "+vm.getSummary().getConfig().uuid);
System.out.println("geust mac Address of guest  "+macAddress);
System.out.println("geust id is "+vm.getSummary().getGuest().guestId);
System.out.println("host id is "+vm.getSummary().getGuest().getIpAddress());    
    }
    } catch (RuntimeFault e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (RemoteException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

}