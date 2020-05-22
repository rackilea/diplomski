String vowels = new StringBuilder(s.replaceAll("[^AEIOUaeiou]", ""))
            .reverse().toString();
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0, p = 0; i < s.length(); i++) {
        switch (Character.toLowerCase(s.charAt(i))) {
        // Note that these fall-through...
        case 'a': case 'e': case 'i': case 'o': case 'u':
            sb.setCharAt(i, vowels.charAt(p++));
            break;
        default:
            break;
        }
    }
    return sb.toString();