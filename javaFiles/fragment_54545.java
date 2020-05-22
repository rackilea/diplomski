class Spout implements IRichSpout {
    void nextTuple() {
        Bean b = queue.poll();
        // of course, you can also un-nest Bean2
        collector.emit(new Values(b.getA(), b.getB(), b.getBean2()));
    }
}