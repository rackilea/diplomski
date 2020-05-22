VirtualMachineConfigInfo vmConfig = vm.getConfig();
    VirtualDevice[] vds = vmConfig.getHardware().getDevice();
    for(VirtualDevice vd : vds){
        if(vd instanceof VirtualDisk){
            System.out.println(vd.getDiskObjectId());
        }
    }