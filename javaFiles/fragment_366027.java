private Queue<Animation> queue = new LinkedList<Animation>();

private Animation getUnfinishedAnimation() {
    synchronized(this) {
        while (!queue.isEmpty()) {
            Animation an = queue.peek();
            if (!an.isFinished()) {
                return an;
            }
            queue.poll();
            if (queue.isEmpty()) {
                notifyAll();
            }
        }
    }
    return null;
}

private void nextAnimation() {
    synchronized(this) {
        queue.poll();
        if (queue.isEmpty()) {
            notifyAll();
        }
    }
}

private void timerTic() {
    Animation an = getUnfinishedAnimation();
    if (an != null) {
        an.nextStep();
        if (an.isFinished()) {
            nextAnimation();
        }
    }
}