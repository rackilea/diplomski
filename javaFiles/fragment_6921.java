public class CountingHttpInvokerRequestExecutor extends SimpleHttpInvokerRequestExecutor {
   @Override
   protected InputStream decorateInputStream(InputStream is) throws IOException {
      return new CountingInputStream(super.decorateInputStream(is));
   }
}