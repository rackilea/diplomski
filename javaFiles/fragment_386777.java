// provide the process manager an absolute path of your executable; you 
// can also pass arguments as an ArrayList as second parameter.
// ...new ProcessManager("\absolute\path\of\your\exe", argList);
ProcessManager pManager = new ProcessManager("\absolute\path\of\your\exe");
NextActionInitiator nextActionInitiator = new NextActionInitiator();
pManager.addProcessEventListener(nextActionInitiator);
pManager.start();