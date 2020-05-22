job.waitForCompletion(true);

Counter someCount = job.getCounters().findCounter(CountersClass.N_COUNTERS.SOMECOUNT);

//put counter value into conf object of the job where you need to access it
//you can choose any name for the conf key really (i just used counter enum name here)
job2.getConfiguration().setLong(CountersClass.N_COUNTERS.SOMECOUNT.name(), someCount.getValue());