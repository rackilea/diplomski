public class AxisMeasuring implements SensorEventListener, Callable<List<Float>>{

    private CountDownLatch latch;

    AxisMeasuring(int _axis, final int _timeDelay, Context _context, CountDownLatch latch) {
        latch = latch;
        ...
    }

    @Override
    public List<Float> call() throws Exception {
        latch.await();  // this will get blocked until you call latch.countDown after,  for example, a Boolean is set
        return values;
    }
}