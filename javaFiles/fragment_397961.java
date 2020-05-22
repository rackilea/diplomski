SystemGetInfoRequest sq = new SystemGetInfoRequest();
SystemGetInfoResponse sr = apirunner.run(sq);
try {
System.out.println("Systemname"+ sr.getSystemInfo().getSystemName());                     

    System.out.println("SerialNumber"+sr.getSystemInfo().getSystemSerialNumber());
System.out.println("MemorySize"+ sr.getSystemInfo().getMemorySize());
System.out.println("VendorID"+ sr.getSystemInfo().getVendorId());
    System.out.println("TotalProcessors"+ sr.getSystemInfo().getNumberOfProcessors());
} catch (JSONException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}