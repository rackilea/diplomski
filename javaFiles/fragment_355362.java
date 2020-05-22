while ((k < s.length()) && (j < s.length())) { // While no String goes out of Bounds
    if (s.charAt(j) != s.charAt(k)) { // If we get a different character
        break; // Get out of the loop
    } else {
        j++;  // Advance one position
        k++;
    }
}