//pseudocode
while (true) {
   // it polls data from the incomingQueue that shares with the producers
    KpiMessage message = this.incomingQueue.take()

   //Then process the message and produces an output... you can put that output in a different queue as well for other part of the code to pick it up
}