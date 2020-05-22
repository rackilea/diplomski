public class ThreadDeadlock { 
    ...     
    public static void main(String [] args ) throws Exception { 
        ThreadDeadlock td = new ThreadDeadlock(); 
        ThreadDeadlock.RenderPageTask rpt = td.new RenderPageTask(); 

        Future<String> f = td.exec.submit(rpt);

        System.out.println(f.get());
        td.exec.shutdown();
    } 
}