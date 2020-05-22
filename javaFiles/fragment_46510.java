int PID[];
int x[];
int y[];
int n; // no. of processes
//code that populates x[], y[] and PID[]
Process[] processes = new Process[n];
for (int i = 0; i < n; i++) {
    processes[i] = new Process(x[i], y[i], PID[i]);
}