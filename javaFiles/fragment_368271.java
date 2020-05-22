import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

/**
 * EffectTimer
 */
public class EffectTimer {

    /**
     * All of effect timers in instance of this class.
     */
    static class GlobalTimer implements ActionListener {

        List<EffectTimer> registeredEffects = new ArrayList<>();

        Timer timer = new Timer(16, this);

        public void start(final EffectTimer t) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    internalStart(t);
                }

            });
        }

        void internalStart(EffectTimer t) {
            int initialDelay = Math.max(0, (int) (t.getEffectStartTime() - System.currentTimeMillis()));
            if(timer.getInitialDelay() >= initialDelay) {
                timer.setInitialDelay(initialDelay);
            }
            if(!registeredEffects.contains(t)) {
                registeredEffects.add(t);
                if(registeredEffects.size() == 1) {
                    timer.start();
                }
            }
        }

        void stop(final EffectTimer t) {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    registeredEffects.remove(t);
                    checkStop();
                }

            });
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            long now = e.getWhen();

            Iterator<EffectTimer> iter = registeredEffects.iterator();
            while(iter.hasNext()) {
                EffectTimer t = iter.next();
                long elapsedMs = now - t.getEffectStartTime();

                if(elapsedMs > 0) {
                    float p = elapsedMs / (float)t.getEffectLengthMs();
                    if(p >= 1.0f) {
                        iter.remove();
                        t.stop();
                    } else {
                        if(t.isReversed()) {
                            p = 1.0f - p;
                        }
                        t.progressChanged(p);
                    }
                }
            }

            checkStop();
        }

        void checkStop() {
            if(registeredEffects.isEmpty()) {
                timer.stop();
            }
        }

        public int getRunningTimerCount() {
            return registeredEffects.size();
        }

        public void stopAll() {
            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    registeredEffects.clear();
                    checkStop();
                }

            });
        }

    }

    static final GlobalTimer GTIMER = new GlobalTimer();

    int effectLengthMs = -1;

    long effectStartMs = -1;

    float progress = 0.0f;

    boolean reversed = true;

    public long getEffectStartTime() {
        return effectStartMs;
    }

    public int getEffectLengthMs() {
        return effectLengthMs;
    }

    public void start(int lengthMs) {
        start(lengthMs, System.currentTimeMillis());
    }

    public void start(int lengthMs, long startMs) {
        effectLengthMs = lengthMs;
        effectStartMs = startMs;

        reversed = false;
        progress = 0.0f;
        GTIMER.start(this);
    }

    public boolean isReversed() {
        return reversed;
    }

    public void reverse(final int lengthMs) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                internalReverse(lengthMs);
            }

        });
    }

    void internalReverse(int lengthMs) {
        reversed = !reversed;

        effectLengthMs = lengthMs;
        int adjust = reversed ? (int)(lengthMs * (1.0f - progress)) : (int)(lengthMs * progress);
        effectStartMs = System.currentTimeMillis() - adjust;

        GTIMER.start(this);
    }

    final public void progressChanged(float p) {
        progress = p;
        run(p);
    }

    /**
     * 0.0f to 1.0f effect progress.
     * <code>Float.compare(progress, 1.0f) >= 0</code> to end progress.
     */
    protected void run(float p) {}

    public void stop() {
        progress = reversed ? 0.0f : 1.0f;
        GTIMER.stop(this);
    }

    public boolean isRunning() {
        return 0.0f < progress && progress < 1.0f;
    }

    public float getProgress() {
        return progress;
    }

    public static int getRunningTimerCount() {
        return GTIMER.getRunningTimerCount();
    }

    public static void stopAll() {
        GTIMER.stopAll();
    }

}