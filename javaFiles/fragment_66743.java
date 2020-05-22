/**
 * Creates a StringEntity with the specified content and content type.
 *
 * @param string content to be used. Not {@code null}.
 * @param contentType content type to be used. May be {@code null}, in which case the default
 *   MIME type {@link ContentType#TEXT_PLAIN} is assumed.
 *
 * @throws IllegalArgumentException if the string parameter is null
 * @throws UnsupportedCharsetException Thrown when the named charset is not available in
 * this instance of the Java virtual machine
 * @since 4.2
 */
public StringEntity(final String string, final ContentType contentType) throws UnsupportedCharsetException {
    super();
    Args.notNull(string, "Source string");
    Charset charset = contentType != null ? contentType.getCharset() : null;
    if (charset == null) {
        charset = HTTP.DEF_CONTENT_CHARSET;
    }
    this.content = string.getBytes(charset);
    if (contentType != null) {
        setContentType(contentType.toString());
    }
}