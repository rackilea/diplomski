package stackoverflow;

import org.apache.commons.codec.binary.Base64;

public class CodecTest {
    public static void main(String[] args) {
        byte[] arr = "hi".getBytes();
        String s = Base64.encodeBase64String(arr);
        System.out.println("'" + s + "'");
        Package package_ = Package.getPackage("org.apache.commons.codec.binary");
        System.out.println(package_);
        System.out.println("specificationVersion: " + package_.getSpecificationVersion());
        System.out.println("implementationVersion: " + package_.getImplementationVersion());
    }
}