Wave w1= new Wave("first_wav"); // Base Audio file
Wave w2= new Wave("second_wav"); // Audio file to compare
// Finding Audio Fingerprint Similarity
FingerprintSimilarity fps = w1.getFingerprintSimilarity(w2);
float score = fps.getScore();
float sim = fps.getSimilarity();