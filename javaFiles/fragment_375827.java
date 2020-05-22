for (c = 1; c < cols; c++)
    {
   //when c == cols-1, it is also `seq2.length()`
   //the access to seq2.charAt(c) will cause this exception then.
                    sub = matrix[r-1][c-1] + scoreSubstitution(seq1.charAt(r),seq2.charAt(c));
        ins = matrix[r][c-1] + scoreInsertion(seq2.charAt(c));

        del = matrix[r-1][c] + scoreDeletion(seq1.charAt(r));