if (s.charAt(j) == s.charAt(k)) { // If the characters are equal
    while ((s.charAt(j) == s.charAt(k)) // While the characters are equal
              && (k < s.length()) && (j < s.length())) {  // And the position is smaller than the length
       j++;
       k++;
    }
    count += j;
}