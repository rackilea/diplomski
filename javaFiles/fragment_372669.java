prpstmt.setInt(1, randomNumberGenerator());
// snip
prpstmt.setInt(12, 8);
// calls to `setDate(13-16, getCurrentDate());` removed
prpstmt.setInt(13, 43);  // changed 17 to 13
// snip
prpstmt.setInt(28, 2);   // changed 32 to 28