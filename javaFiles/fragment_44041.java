public class MyProcessBuilder {
    List<String> args;

    MyProcessBuilder( String text, String location ) {
        args = new ArrayList<String>();
        args.add( text );
        args.add( location );
    }

    MyProcessBuilder arg( String arg ) {
        args.add( arg );
        return this;
    }

    MyProcessBuilder args( String... args ) {
        this.args.addAll( Arrays.asList( args ) );
        return this;
    }

    public ProcessBuilder go() {
        return new ProcessBuilder( args );
    }

    public static MyProcessBuilder callScript( String location ) {
        return new MyProcessBuilder( "something", location );
    }

    public static void main( String[] args ) {
        callScript( "/tmp/bla" ).arg( "something else" ).arg( "more" ).go();
    }
}