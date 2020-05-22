header-field   = field-name ":" OWS field-value OWS

 field-name     = token
 field-value    = *( field-content / obs-fold )
 field-content  = field-vchar [ 1*( SP / HTAB ) field-vchar ]
 field-vchar    = VCHAR / obs-text

 obs-fold       = CRLF 1*( SP / HTAB )
                ; obsolete line folding
                ; see Section 3.2.4