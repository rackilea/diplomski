public class Interval {

   private final double lowerBoundary;
   private final double upperBoundary;

   public Interval(double lowerBoundary, upperBoundary) {
     this.lowerBoundary = ...
   } 

   public boolean contains(double value) {
     return (value >= lowerBoundary) && (value <=upperBoundary);
   }