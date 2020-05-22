import org.apache.commons.lang3.*;

class WrapTest {
    public static void main (String[] args)  {
        String str = "I am a love cats and dogs but not the flees they carry. Also i think that cats are sometimes rude because they do not hug me when i want them too. Overall though cats and dogs are both great.";
        str = WordUtils.wrap(str, 68);
        System.out.println(str);
    }
}