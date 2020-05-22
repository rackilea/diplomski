/**
 * Build a URI String. This is a shortcut method which combines calls
 * to {@link #build()}, then {@link UriComponents#encode()} and finally
 * {@link UriComponents#toUriString()}.
 * @since 4.1
 * @see UriComponents#toUriString()
 */
public String toUriString() {
    return build(false).encode().toUriString();
}