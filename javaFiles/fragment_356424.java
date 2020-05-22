import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.io.CachedOutputStream;

public class InvalidCharInterceptor extends AbstractPhaseInterceptor<Message> {

  public InvalidCharInterceptor() {
    super(Phase.PRE_STREAM);
  }

  /**
   * From xml spec valid chars:<br>
   * #x9 | #xA | #xD | [#x20-#xD7FF] | [#xE000-#xFFFD] | [#x10000-#x10FFFF]<br>
   * any Unicode character, excluding the surrogate blocks, FFFE, and FFFF.<br>
   * 
   * @param text
   *          The String to clean
   * @param replacement
   *          The string to be substituted for each match
   * @return The resulting String
   */
  public static String cleanInvalidXmlChars(String text, String replacement) {
    String re = "[^\\x09\\x0A\\x0D\\x20-\\xD7FF\\xE000-\\xFFFD\\x10000-x10FFFF]";
    return text.replaceAll(re, replacement);
  }

  @Override
  public void handleMessage(Message message) throws Fault {
    boolean isOutbound = false;
    isOutbound = message == message.getExchange().getOutMessage()
        || message == message.getExchange().getOutFaultMessage();

    if (isOutbound) {
      OutputStream os = message.getContent(OutputStream.class);

      CachedOutputStream cs = new CachedOutputStream();
      message.setContent(OutputStream.class, cs);

      message.getInterceptorChain().doIntercept(message);

      try {
        cs.flush();
        IOUtils.closeQuietly(cs);
        CachedOutputStream csnew = (CachedOutputStream) message.getContent(OutputStream.class);

        String currentEnvelopeMessage = IOUtils.toString(csnew.getInputStream(), "UTF-8");
        csnew.flush();
        IOUtils.closeQuietly(csnew);

        String res = cleanInvalidXmlChars(currentEnvelopeMessage, "");
        res = res != null ? res : currentEnvelopeMessage;

        InputStream replaceInStream = IOUtils.toInputStream(res, "UTF-8");

        IOUtils.copy(replaceInStream, os);
        replaceInStream.close();
        IOUtils.closeQuietly(replaceInStream);

        os.flush();
        message.setContent(OutputStream.class, os);
        IOUtils.closeQuietly(os);

      } catch (IOException ioe) {
        throw new RuntimeException(ioe);
      }
    }
  }

}