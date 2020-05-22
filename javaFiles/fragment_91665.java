/**
 * Configure a {@code boolean} flag to close the folder automatically after a fetch (default) or
 * populate an additional {@link IntegrationMessageHeaderAccessor#CLOSEABLE_RESOURCE} message header instead.
 * It is the downstream flow's responsibility to obtain this header and call its {@code close()} whenever
 * it is necessary.
 * <p> Keeping the folder open is useful in cases where communication with the server is needed
 * when parsing multipart content of the email with attachments.
 * <p> The {@link #setSimpleContent(boolean)} and {@link #setHeaderMapper(HeaderMapper)} options are not
 * affected by this flag.
 * @param autoCloseFolder {@code false} do not close the folder automatically after a fetch.
 * @since 5.2
 */
public void setAutoCloseFolder(boolean autoCloseFolder) {