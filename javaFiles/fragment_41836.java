for(int i = 0; i < 256; ++i) hash[i] = 0;  // Before entering while reset hash
                                           // counters for sliding window
while (right < s.length()) {
    if (hash[s.charAt(right)] == 0) {  // Use hash here for counting frequency
        count++;
}
hash[s.charAt(right)]--;  // Consistently increment for right and decrement for left