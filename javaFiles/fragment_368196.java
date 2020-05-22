import java.math.BigInteger;
import java.util.EnumSet;
import java.util.Scanner;

public class DataTypeTest {

    enum DataType {
        BYTE("byte", BigInteger.valueOf(Byte.MIN_VALUE), BigInteger.valueOf(Byte.MAX_VALUE)),
        SHORT("short", BigInteger.valueOf(Short.MIN_VALUE), BigInteger.valueOf(Short.MAX_VALUE)),
        INTEGER("int", BigInteger.valueOf(Integer.MIN_VALUE), BigInteger.valueOf(Integer.MAX_VALUE)),
        LONG("long", BigInteger.valueOf(Long.MIN_VALUE), BigInteger.valueOf(Long.MAX_VALUE));

        private final String name;
        private final BigInteger lowerBound;
        private final BigInteger upperBound;

        DataType(String name, BigInteger lowerBound, BigInteger upperBound) {
            this.name = name;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        public String getName() {
            return name;
        }

        public boolean eligible(BigInteger number) {
            return lowerBound.compareTo(number) <= 0 && number.compareTo(upperBound) <= 0;
        }

        public static EnumSet<DataType> findAllEligible(BigInteger number) {
            EnumSet<DataType> results = EnumSet.noneOf(DataType.class);
            for (DataType dataType : values()) {
                if (dataType.eligible(number)) {
                    results.add(dataType);
                }
            }
            return results;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of inputs you want to take");
        int num = input.nextInt();
        BigInteger [] tests  = new BigInteger [num];
        for (int i = 0; i < tests.length; i++) {
            tests[i] = input.nextBigInteger();
        }

        for (BigInteger number : tests) {
            System.out.println(number + " can be fit in:");
            EnumSet<DataType> dataTypes = DataType.findAllEligible(number);
            if (dataTypes.isEmpty()) {
                System.out.println("None");
            } else {
                for (DataType type : dataTypes) {
                    System.out.println("* "  + type.getName());
                }
            }
        }
    }
}