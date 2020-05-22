"package\\s+" => the work "package" followed by at least one space
"("           => start of capture
"[a-zA-Z_]"   => first character of package (doesn't include numeric digits)
"[\\.\\w]*"   => any number of word characters (a-zA-Z0-9_) plus the "." character
")"           => end of capture
";"           => end of line