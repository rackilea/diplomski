**
 * An interceptor to copy information from the HTTP session to the "handshake
 * attributes" map to made available via{@link WebSocketSession#getAttributes()}.
 *
 * <p>Copies a subset or all HTTP session attributes and/or the HTTP session id
 * under the key {@link #HTTP_SESSION_ID_ATTR_NAME}.
 *
 * @author Rossen Stoyanchev
 * @since 4.0
 */
public class HttpSessionHandshakeInterceptor implements HandshakeInterceptor {