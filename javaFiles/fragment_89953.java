public class Container {
   private double[][] values;
   private Map<Double,AdditionalProperties> properties;

   public double getValue(int x, int y) {
     return values[x][y];
   }

   public AdditionalProperties getProperties(int x, int y) {
     return properties.get( getValue(x, y ) );
   }
 }