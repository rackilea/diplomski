class Spout implements IRichSpout {
    void nextTuple() {
        Bean b = queue.poll();
        collector.emit(new Values(b));
    }
}