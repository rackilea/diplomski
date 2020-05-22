import java.io.IOException;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

public static void main(String[] args) throws IOException, InterruptedException, IM4JavaException {
    ConvertCmd convertCmd = new ConvertCmd();

    IMOperation imOperation = new IMOperation();

    imOperation.addImage("/home/user/images/image.eps");
    imOperation.addImage("/home/user/images/image.png");

    convertCmd.run(imOperation);
}