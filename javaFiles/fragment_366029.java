public synchronized void moveTo(final Point p) {
    scheduleAnimation(new Animation() {
        @Override
        public boolean isFinished() {
            synchronized(Guest.this) {
                return bounds.x == p.x && bounds.y == p.y;
            }
        }

        @Override
        public void nextStep() {
            synchronized(Guest.this) {
                int delta = Math.abs(bounds.x - p.x);
                delta = (delta >= 10) ? 10 : delta;
                delta *= ((bounds.x - p.x) < 0) ? 1 : -1;
                bounds.x += delta;

                delta = Math.abs(bounds.y - p.y);
                delta = (delta >= 10) ? 10 : delta;
                delta *= ((bounds.y - p.y) < 0) ? 1 : -1;
                bounds.y += delta;
            }
            repaint();
        }
    });
}