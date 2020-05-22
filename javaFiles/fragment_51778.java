−l  Flush the standard output after the information for each packet is
       printed.  (This is not, strictly speaking, line‐buffered if −V was
       specified; however, it is the same as line‐buffered if −V wasn’t
       specified, as only one line is printed for each packet, and, as −l
       is normally used when piping a live capture to a program or script,
       so that output for a packet shows up as soon as the packet is seen
       and dissected, it should work just as well as true line‐buffering.
       We do this as a workaround for a deficiency in the Microsoft Visual
       C++ C library.)

       This may be useful when piping the output of TShark to another
       program, as it means that the program to which the output is piped
       will see the dissected data for a packet as soon as TShark sees the
       packet and generates that output, rather than seeing it only when
       the standard output buffer containing that data fills up.