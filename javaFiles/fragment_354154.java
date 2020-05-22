LockObject lock;

ProcessA ---->(msg)----> ProcessB(PortY)

// Processing the request and sending its response 
// makes a single transaction.
synchronized (lock) {
    ProcessB does processing   
    ProcessB(portY)--->(response)----->ProcessA (TCP1)
}

// While the processing code holds the lock, B is not
// allowed to send a request to A.
synchronized (lock) {
    ProcessB--->(msg)----->ProcessA(portX)  (TCP2)
}