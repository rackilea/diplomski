public Caller (CallMe target, String msg) {
    this.target = target;
    this.msg = msg;
    t = new Thread(this);
    t.start();
}