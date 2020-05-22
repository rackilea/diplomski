public String myHandler(final KinesisEvent kinesisEvent, final Context context)
{
    Thread thread = new Thread(new Runnable(){

        @Override
        public void run() {
            int singleRecord=0;
            long starttime=System.currentTimeMillis();
            //LambdaLogger lambdaLogger=context.getLogger();
            for(KinesisEventRecord rec : kinesisEvent.getRecords())
            {
                singleRecord=0;
                System.out.println("Kinesis Record inside is:"+new String(rec.getKinesis().getData().array()));
                //count++;
                singleRecord++;
                //  System.out.println(new String(rec.getKinesis().getData().array()));
            }
            count=count+singleRecord;
            long endtime=System.currentTimeMillis();
            long totaltime = endtime-starttime;
            time=time+totaltime;
            System.out.println("Time required to execute single Lambda function for "+singleRecord+" records is"+" :: "+totaltime+" milliseconds");
            System.out.println("Total time required to execute Lambda function for "+count+" records is"+" :: "+time+" milliseconds");
        }
    });
    thread.start();
}