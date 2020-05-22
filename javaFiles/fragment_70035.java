public Server(Worker worker) {
    this.clients = new ArrayList<ClientHandle>();
    this.worker = new Worker();  // This is the problem.


// Don't do this in the Server constructor.
this.worker = new Worker();

// Instead do this:
this.worker = worker;