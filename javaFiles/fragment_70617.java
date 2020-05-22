public int compareTo(Patient rhs) {
    if(prio==rhs.prio) {
        return number - rhs.number; // First line
    } else {
        return prio - rhs.prio; // Second line
    }
 }