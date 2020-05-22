private void destroyProcesses(List<Process> processes){

    if (processes == null)
        return;
    else{
        for (Process thisProcess : processes)
            thisProcess.destroy();

        processes.clear();
    }
}