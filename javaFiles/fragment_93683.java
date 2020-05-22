@UiThreadTest
public void testListItemClickStartsActivity() {
    final Instrumentation inst = getInstrumentation();
    final IntentFilter intentFilter = new IntentFilter();
    // here add conditions to your filter, i.e. intentFilter.addAction()
    ActivityMonitor monitor = inst.addMonitor(intentFilter, null, false);
    assertEquals(0, monitor.getHits());
    // here perform desired click on list
    monitor.waitForActivityWithTimeout(5000);
    assertEquals(1, monitor.getHits());
    inst.removeMonitor(monitor);
}