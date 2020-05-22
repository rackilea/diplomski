Request       = Request-Line              ; Section 5.1
                    *(( general-header        ; Section 4.5
                     | request-header         ; Section 5.3
                     | entity-header ) CRLF)  ; Section 7.1
                    CRLF
                    [ message-body ]          ; Section 4.3