LOAD A    ; called
    NEG       ; negate
    BRF 1$    ; branch if false
    LOAD 1    ; true
    STOR A    ; store into called
1$:           ; do once