String[] words = twit.split("\\s+"); 
double totalScore = 0, averageScore;
for(String word : words) {
    word = word.replaceAll("([^a-zA-Z\\s])", "");
    if (_sw.extract(word) == null)
        continue;
    totalScore += _sw.extract(word);
}
verageScore = totalScore;

if(averageScore>=0.75)
    return "very positive";
else if(averageScore > 0.25 && averageScore<0.5)
    return  "positive";
else if(averageScore>=0.5)
    return  "positive";
else if(averageScore < 0 && averageScore>=-0.25)
    return "negative";
else if(averageScore < -0.25 && averageScore>=-0.5)
    return "negative";
else if(averageScore<=-0.75)
    return "very negative";
return "neutral";