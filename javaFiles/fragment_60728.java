package org.opensaml;
/**
 * Minimal implementation of OWASP ESAPI {@link SecurityConfiguration}, providing the support used within OpenSAML.
 */
public class ESAPISecurityConfig implements SecurityConfiguration {
    /** Constructor. */
    public ESAPISecurityConfig() {
    }
    // snip...
    /** {@inheritDoc} */
    public String getHTTPUtilitiesImplementation() {
        return null;
    }
    // snip....
}