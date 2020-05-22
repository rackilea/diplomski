/*
 * the collect_sample() method is the method invoked by the
 * WatcherThread via the PeriodicTask::task() method. This method
 * is responsible for collecting data samples from sampled
 * PerfData instances every PerfDataSamplingInterval milliseconds.
 * It is also responsible for logging the requested set of
 * PerfData instances every _sample_count milliseconds. While
 * logging data, it will output a column header after every _print_header
 * rows of data have been logged.
 */
void StatSampler::collect_sample() {