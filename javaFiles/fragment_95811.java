this.replyOne = false;
this.replyTwo = false;

while(!endCondition) {

    while (!this.replyOne && !this.replyTwo) {
        // wait until the observer has set both the reply flags
    }
    if (this.replyOne) {
        System.out.println("Reply one True ");
        setChanged();
        notifyObservers(new String("app Calling after update from serverOne "));
        this.replyOne = false;
    }

    if (this.replyTwo) {
        System.out.println("Reply two True ");
        setChanged();
        notifyObservers(new String("app Calling after update from serverTwo "));
        this.replyTwo = false;
    }
}