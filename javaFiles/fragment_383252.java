class RunAmounts implements Runnable {
    final int i
    public void run() {
        println i
    }
    RunAmounts(int i) {this.i = i}
}

def foo() {
    (0 .. 90).step(10).each { j ->
        (0 .. 9).each { i ->
            t = new Thread(new RunAmounts(i + j) as Runnable)
            t.start()
            t.join()
        }
    }
}