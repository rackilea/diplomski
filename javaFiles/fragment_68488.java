for (ManagedEntity hostmanagedEntity : hostmanagedEntities) {
HostSystem hostsys = (HostSystem) hostmanagedEntity;

String ESXhostname = hostsys.getName();
//System.out.println("host ip address is "+hostsys.getConfig().);
HostHardwareInfo hw = hostsys.getHardware();
String ESXhostmodel = hw.getSystemInfo().getModel();
String Vendor = hw.getSystemInfo().getVendor();

long ESXhostmem = hw.getMemorySize();
short ESXhostcores = hw.getCpuInfo().getNumCpuCores();
long ESXMHZ = hw.getCpuInfo().getHz();
HostCpuPackage[] cpuPkg = hw.getCpuPkg();
 String serialNumber =  hostsys.getSummary().getHardware().otherIdentifyingInfo[2].identifierValue;
String esxkey = "ESXInfo";
String esxvalue = "ESXhostname-" + ESXhostname
    + ";ESXhostmodel-" + ESXhostmodel 
    + ";ESXhostmem-"+ ESXhostmem 
    + ";ESXhostcores-" + ESXhostcores
    + ";ESXHz -"+ESXMHZ
    + ";Vendor-" + Vendor
    + ";OSType-" + si.getAboutInfo().getOsType()
    + ";FullName-" + si.getAboutInfo().getFullName()
    + ";OSVersion-" + si.getAboutInfo().getVersion()
    +";serialNumber" + serialNumber
    ;

System.out.println("Value are "+ esxvalue); 
}