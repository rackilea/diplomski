public class MyTriggerListener implements TriggerListener {
         [...]

         @Override
         public void vetoJobExecution(Trigger trigger, JobExecutionContext context) {

              // You check if it is your Cron Trigger
              if ("MyTrigger".equals(trigger.getKey.getName()) {
                   Calendar cal = Calendar.getInstance();

                   // If current date is sunday, then another one-time trigger 
                   //   is created to delay the job firing
                   if (Calendar.SUNDAY.equals(cal.get(Calendar.DAY_OF_WEEK))) {

                        cal.add(Calendar.DATE, 1); // One day later

                        TriggerBuilder<Trigger> tb = newTrigger()
                            .startAt(cal.getTime());
                            .withIdentity("MyTrigger_delayed");
                            .forJob(context.getJobDetail());

                        // TODO schedule it in Quartz the way you want
                        // like : scheduler.scheduleJob(tb.build());

                        return true; // The current fire is vetoed
                   }

                   // If current date is saturday, then another one-time trigger 
                   //   is created to delay the job firing
                   else if (Calendar.SATURDAY.equals(cal.get(Calendar.DAY_OF_WEEK))) {

                        cal.add(Calendar.DATE, 2); // Two day later

                        TriggerBuilder<Trigger> tb = newTrigger()
                            .startAt(cal.getTime());
                            .withIdentity("MyTrigger_delayed");
                            .forJob(context.getJobDetail());

                        // TODO schedule it in Quartz the way you want
                        // like : scheduler.scheduleJob(tb.build());

                        return true;// The current fire is vetoed
                   } 
                   // If it is a weekday, the job fires normally
                   else {
                        return false;
                   }
              }

              // It is not your Cron Trigger
              return false;
         }
    }