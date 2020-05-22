int nbCandidates = 4;
int[] result = new int[nbCandidates];

// assuming you want to increment candidate 1, 3 and 4
// contained in an array
int[] candidatesToUpvote = {1,3,4};
for (int c : candidatesToUpvote) {
   result[c-1] += 1;
}