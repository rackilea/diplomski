// search for '+' and '-' first
    for (i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            break;
        }
    }
    if (i < 0) {
        // if '+' and '-' were not found, search for '*' and '/'
        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                break;
            }
        }
    }