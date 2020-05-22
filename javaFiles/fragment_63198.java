for (int i = 0; i<length; i++){
    if (used[i]) continue;
    out.append(in[i]); // try adding the ith letter
    used[i] = true;    // and mark it as used
    doPermute(in, out, used, length, level + 1); // do all the permutations for the remaining letters
    used[i] = false;                 // undo what we did
    out.setLength(out.length() - 1); // at the start of the loop
}