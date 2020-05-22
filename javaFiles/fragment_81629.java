public int getBaseAddress() {
        try {
                Pointer hProcess = gethProcess();
                List<Module> hModules = PsapiHandler.getInstance().EnumProcessModules(hProcess);

                for(Module m: hModules){
                        if(m.getFileName().contains(exeName)){
                                misc.log(m.getFileName() + ": 0x" + Long.toHexString(Pointer.nativeValue(m.getEntryPoint())));
                                return Integer.valueOf("" + Pointer.nativeValue(m.getLpBaseOfDll()));
                        }
                }
        } catch (Exception e) {  e.printStackTrace(); }
        return -1;
}