public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
    private static int count;
    private long processTime;

    @Override
    public Person process(final Person person) throws Exception {
        count++;
        long start = System.currentTimeMillis();    
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName, lastName);

        // bear in mind that this will pollute the logging when processing millions of records
        log.info("Converting (" + person + ") into (" + transformedPerson + ")");
        log.info("Processing 1 item took " + (System.currentTimeMillis() - start) / 1e3 + " sec");

        processTime += System.currentTimeMillis() - start;    

        // use some interval value, here I used 5.
        // last few items won't be counted e.g. 18 items you will see this message 3 times.
        if (count == 5) {
            log.info(String.format("Processed %d items in %s sec", count, processTime / 1e3));
            count = 0;
        }
        return transformedPerson;       
    }

    public long getProcessTime(){
        return processTime;
    }
}