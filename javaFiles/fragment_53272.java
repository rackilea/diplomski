public class DropAjaxBehavior extends AbstractAjaxBehavior {
    private static final Logger LOG = LoggerFactory.getLogger(DropAjaxBehavior.class);

    @Override
    public final void onRequest() {
        LOG.debug("Received request");

        final RequestCycle requestCycle = RequestCycle.get();

        processRequest(requestCycle);
        sendResponse(requestCycle);
    }

    private void processRequest(RequestCycle requestCycle) {

        final WebRequest wr = (WebRequest)requestCycle.getRequest();
        final HttpServletRequest hsr = (HttpServletRequest)wr.getContainerRequest();

        try {
            final byte[] data = new byte[hsr.getContentLength()];
            ByteStreams.readFully(hsr.getInputStream(), data);

            // filename:<NAME>;data:<TYPE>;base64,<FILEDATA>
            final String[] base64Data = new String(data).split(";");
            final String fileName = base64Data[0].substring(base64Data[0].indexOf(':') + 1, base64Data[0].length());
            final String dataType = base64Data[1].substring(base64Data[1].indexOf(':') + 1, base64Data[1].length());
            final String binaryData = base64Data[2].substring(base64Data[2].indexOf(',') + 1, base64Data[2].length());

            // [in my case] do something if the fileType is an image
            if (dataType.contains("image")) {
                final byte[] image = DatatypeConverter.parseBase64Binary(binaryData);
                DatabaseQuery.addImage(image, fileName);
            }
            // But you can make a local file
            // final File file = new File(fileName);
            // final ByteArrayInputStream binaryInputstream = new ByteArrayInputStream(image);
            // final FileOutputStream outputStream = new FileOutputStream(file);
            // ByteStreams.copy(binaryInputstream, outputStream);
            // outputStream.close();
        } catch (IOException ioe) {
            LOG.error("IO error while reading HttpServletRequest: ", ioe);
        }
    }

    private void sendResponse(RequestCycle requestCycle) {
        // Just some response
        requestCycle.scheduleRequestHandlerAfterCurrent(new TextRequestHandler("text/html", "UTF-8", "done"));
    }

    @Override
    protected final void onComponentTag(ComponentTag tag) {
        tag.put("my:dropcontainer.callback", getCallbackUrl().toString());
    }
}