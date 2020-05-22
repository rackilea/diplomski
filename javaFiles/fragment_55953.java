Method         = "OPTIONS"                ; Section 9.2
                  | "GET"                    ; Section 9.3
                  | "HEAD"                   ; Section 9.4
                  | "POST"                   ; Section 9.5
                  | "PUT"                    ; Section 9.6
                  | "DELETE"                 ; Section 9.7
                  | "TRACE"                  ; Section 9.8
                  | "CONNECT"                ; Section 9.9
                  | extension-method
   extension-method = token