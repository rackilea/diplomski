char[] cs = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    boolean tag = false;
    for (int i=0; i<cs.length; i++) {
        switch(cs[i]) {
            case '<': if ( ! tag) { tag = true; break; }
            case '>': if (tag) { tag = false; break; }
            case '&': i += interpretEscape(cs, i, sb); break;
            default: if ( ! tag) sb.append(cs[i]);
        }
    }
    System.err.println(sb);