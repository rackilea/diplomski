import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlow;
import org.tensorflow.SavedModelBundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Test {
    public static byte[][] makeTensor(String s, int padding) throws Exception
    {
        int len = s.length();
        int extra = padding - len;

        byte[][] ret = new byte[len + extra][];
        for (int i = 0; i < len; i++) {
            String cur = "" + s.charAt(i);
            byte[] cur_b = cur.getBytes("UTF-8");
            ret[i] = cur_b;
        }

        for (int i = 0; i < extra; i++) {
            byte[] cur = "/".getBytes("UTF-8");
            ret[len + i] = cur;
        }

        return ret;
    }
    public static byte[][][] makeTensor(List<String> l, int padding) throws Exception
    {
        byte[][][] ret = new byte[l.size()][][];
        for (int i = 0; i < l.size(); i++) {
            ret[i] = makeTensor(l.get(i), padding);
        }

        return ret;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Loading model...");

        SavedModelBundle savedModelBundle = SavedModelBundle.load("model", "serve");


        List<String> str_test_name = Arrays.asList("Max Mustermann",
            "Max Mustermann",
            "Max Mustermann",
            "Max Mustermann",
            "Max Mustermann");
        List<String> names = Arrays.asList("joseph haydn",
            "max mustermann",
            "erika musterfrau",
            "johann sebastian bach",
            "wolfgang amadeus mozart");

        //get the max length for each array
        int pad1 = str_test_name.get(0).length();
        int pad2 = 0;
        for (String var : names) {
            if(var.length() > pad2)
                pad2 = var.length();
        }


        byte[][][] test_name = makeTensor(str_test_name, pad1);
        byte[][][] ref_names = makeTensor(names, pad2);

        //use a with block so the close method is called
        try(Tensor t_test_name = Tensor.<String>create(test_name))
        {
            try (Tensor t_ref_names = Tensor.<String>create(ref_names))
            {
                List<Tensor<?>> output = savedModelBundle.session().runner()
                    .feed("test_name", t_test_name)
                    .feed("ref_names", t_ref_names)
                    .fetch("ArgMin")
                    .run();

                System.out.println("Nearest distance: " + output.get(0).longValue());
            }
        }
    }
}