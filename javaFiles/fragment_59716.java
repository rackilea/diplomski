String processName = "com.myapp.MyApp";

boolean running = false;
HostIdentifier hostIdentifier = new HostIdentifier("local://localhost");

MonitoredHost monitoredHost;
monitoredHost = MonitoredHost.getMonitoredHost(hostIdentifier);

Set activeVms = monitoredHost.activeVms();
for (Object activeVmId : activeVms) {
    VmIdentifier vmIdentifier = new VmIdentifier("//" + String.valueOf(activeVmId) + "?mode=r");
        MonitoredVm monitoredVm = monitoredHost.getMonitoredVm(vmIdentifier);
    if (monitoredVm != null) {
        String mainClass = MonitoredVmUtil.mainClass(monitoredVm, true);
        if (mainClass.toLowerCase().equals(processName.toLowerCase())) {
            running = true;
            break;
        }
    }
}

System.out.print(running);