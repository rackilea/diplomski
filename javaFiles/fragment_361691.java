// Create runtime and array
Runtime rt = Runtime.getRuntime();
List<Process> processes = new ArrayList<Process>();

swtich(bleh){
....
// Add every process    
case 1:
processes.add(rt.exec("my command 1"));

case 2:
processes.add(rt.exec("my command 2"));
....
case n:
processes.add(rt.exec("my command n"));
}

// Destroy all items in the list, iterating the array
destroyProcesses(processes)