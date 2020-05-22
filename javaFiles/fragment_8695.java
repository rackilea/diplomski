public static void main(String args[]) {
    startReport();
    Timer timer = metricRegistry.timer("computePi");    
    Timer.Context context = timer.time();
    try {
        computePi();
    } finally {
        context.stop();
    }
}