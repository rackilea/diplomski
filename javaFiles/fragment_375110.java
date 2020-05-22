BruteForceMatcher<Hamming> matcher;
vector< vector<DMatch> > matches;
vector <DMatch> goodMatches;
matcher.knnMatch(imgDescriptors1, imgDescriptors2, matches, 2);
// Ratio Test
for (unsigned int matchIdx = 0; matchIdx < matches.size(); ++matchIdx) 
{
    const float ratio = 0.8; // As in Lowe's paper (can be tuned)
    if (matches[matchIdx][0].distance < ratio * matches[matchIdx][1].distance)
    {
        goodMatches.push_back(matches[matchIdx][0]);
    }
}