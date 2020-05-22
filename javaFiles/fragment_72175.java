public class mapper extends Mapper<Object, Text, Text, IntWritable> { 
   private Text data = new Text();
   private static final IntWritable ONE = new IntWritable(1);
   private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
   String time;

   // Define the boundaries
   private LocalDateTime start = LocalDateTime.parse("2015.06.05", FMT);
   private LocalDateTime end = LocalDateTime.parse("2015.06.15", FMT);

   @Override
   public void map(Object key, Text value, Context context) throws IOException,      InterruptedException {

       String[] userinput = value.toString().split(";");
       try {
           Long ms = Long.parseLong(userinput[0])/1000;    
           LocalDateTime inputEpoch = LocalDateTime.ofEpochSecond(ms, 0, ZoneOffset.UTC);

           // Filter your data
           if (inputEpoch.isAfter(start) && inputEpoch.isBefore(end)) {
               data.set(inputEpoch.format(FMT));
               context.write(data,ONE);
           }
       } catch (...) { }
   }
}