public class ListPostProcessor implements PostProcessor<List<?>> {
    @SuppressWarnings("unchecked")
    public void process(List<?> t) {
        final PostProcessor p = ...;

        for( Object o : t )
            if(p!=null) 
                p.process(o);
    }

}