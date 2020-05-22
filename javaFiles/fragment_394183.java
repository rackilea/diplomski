import java.util.Map;
import java.util.WeakHashMap;

public aspect TimerAspect {

    private final Map<Object, Timer> objectTiming = new WeakHashMap<>();
    private final ThreadLocal<Timer> currentThreadTimer = new ThreadLocal<>();

    pointcut timerStart(Object object):
            execution(@TimerStart * *(..)) && this(object);

    pointcut timerStop(Object object):
            execution(@TimerEnd * *(..)) && this(object);

    pointcut timerJoin(Object object):
        (execution(@TimerJoin * *(..)) || execution(@TimerJoin *.new(..)) ) 
        && this(object);

    before(Object object): timerStart(object) {
        Timer timer = new Timer();
        timer.start();
        objectTiming.put(object, timer);
        currentThreadTimer.set(timer);
        System.out.println("##### Flow timer START");
    }

    before(Object object): timerJoin(object) {
        Timer timing = currentThreadTimer.get();
        objectTiming.put(object, timing);
        System.out.println("##### Flow timer JOIN");
    }

    after(Object object): timerStop(object) {
        Timer timing = objectTiming.get(object);
        timing.stop();
        System.out.println("##### Flow timer STOP");
        System.out.println("Elapsed: " + timing.getElapsed());
    }

}