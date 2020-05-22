import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class Main {

    public static void main(String[] args) {
        System.out.println(
                Hashing.murmur3_32()
                .newHasher()
                .putString("Some Sting", Charsets.UTF_8)
                        .hash().asInt());
    }
}