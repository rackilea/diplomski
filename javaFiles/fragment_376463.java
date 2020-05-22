import java.util.*;

public final class Scratch3
{
    private Scratch3()
    {
    }

    interface ProbabilityFunction<T>
    {
        double getProbability( double x );
    }

    private static double exponential2( double x )
    {
        assert x >= 0.0 && x <= 1.0;
        return StrictMath.pow( x, 2 );
    }

    private static double exponential3( double x )
    {
        assert x >= 0.0 && x <= 1.0;
        return StrictMath.pow( x, 3 );
    }

    private static double inverse( double x )
    {
        assert x >= 0.0 && x <= 1.0;
        return 1/x;
    }

    private static double identity( double x )
    {
        assert x >= 0.0 && x <= 1.0;
        return x;
    }

    @SuppressWarnings( { "UnsecureRandomNumberGeneration", "ConstantNamingConvention" } )
    private static final Random randomNumberGenerator = new Random( 10 );

    private static <T> T select( List<T> values, ProbabilityFunction<T> probabilityFunction )
    {
        double x = randomNumberGenerator.nextDouble();
        double p = probabilityFunction.getProbability( x );
        int i = (int)( p * values.size() );
        return values.get( i );
    }

    public static void main( String[] args )
    {
        List<Integer> values = Arrays.asList( 10, 11, 12, 13, 14, 15 );
        Map<Integer,Integer> counts = new HashMap<>();
        for( int i = 0;  i < 10000;  i++ )
        {
            int value = select( values, Scratch3::exponential3 );
            counts.merge( value, 1, ( a, b ) -> a + b );
        }
        for( int value : values )
            System.out.println( value + ": " + counts.get( value ) );
    }
}