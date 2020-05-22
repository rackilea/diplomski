static final int
    EXIT_OK = 0,        // Compilation completed with no errors.
    EXIT_ERROR = 1,     // Completed but reported errors.
    EXIT_CMDERR = 2,    // Bad command-line arguments
    EXIT_SYSERR = 3,    // System error or resource exhaustion.
    EXIT_ABNORMAL = 4;  // Compiler terminated abnormally