private final AtomicReference<List<String>> cpuDataReference =
     new AtomicReference<List<String>>();
 ...

 ProcParser pp_Cpu =
     new ProcParser(UsageType.CPU, 1000, Pid.getPid(), cpuDataReference);
 ...

 // in your `ProcParser`
 List<String> cpuDataList = new ArrayList<String>();
 // read in the /proc files into the list
 ...
 // save it in the AtomicReference passed into the constructor
 dataReference.set(cpuDataList);

 // other threads could then get the latest list
 List<String> cpuDataList = cpuDataReference.get();