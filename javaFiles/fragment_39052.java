import com.aparapi.*;
import org.junit.Test;

public class DotProductTest {
  @Test
  public void dotProduct() {

        final double[] in1Copy = new double[4096];
        final double[] in2Copy = new double[4096];
        for(int i = 0; i < 4096; i++) {
            in1Copy[i] = i;
            in2Copy[i] = i*10.0;
        }

        final double[] result = new double[1];

        Kernel kernel = new Kernel() {
            @Override
            public void run() {
                int i = getGlobalId();
                result[0] += in1Copy[i] + in2Copy[i];
            }
        };

        Range range = Range.create(in1Copy.length);
        kernel.execute(range);
        System.out.println(result[0]);

    }
}