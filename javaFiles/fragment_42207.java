public class Test {
 public static void main(String args[]) {
  for (int point : Decode("_p~iF~ps|U_ulLnnqC_mqNvxq`@",10)) {
   System.out.println(point); // Be aware that point is in E5
  }
 }

 private static java.util.List<java.lang.Integer> Decode(String encoded_polylines, int initial_capacity) {
  java.util.List<java.lang.Integer> trucks = new java.util.ArrayList<java.lang.Integer>(initial_capacity);
  int truck = 0;
  int carriage_q = 0;
  for (int x = 0, xx = encoded_polylines.length(); x < xx; ++x) {
   int i = encoded_polylines.charAt(x);
   i -= 63;
   int _5_bits = i << (32 - 5) >>> (32 - 5);
   truck |= _5_bits << carriage_q;
   carriage_q += 5;
   boolean is_last = (i & (1 << 5)) == 0;
   if (is_last) {
    boolean is_negative = (truck & 1) == 1;
    truck >>>= 1;
    if (is_negative) {
     truck = ~truck;
    }
    trucks.add(truck);
    carriage_q = 0;
    truck = 0;
   }
  }
  return trucks;
 }
}