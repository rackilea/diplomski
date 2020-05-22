if (nounCount == 0)
{
    error = error + "Error: Not enough nouns.";
}
else if (adjectiveCount == 0)
{
    error = error + "Error: Not enough adjectives.";
}
else if (verbCount == 0)
{
    error = error + "Error: Not enough verbs.";
}
else if (nounCount == 0 && adjectiveCount == 0)
{
    error = error + "Error: Not enough nouns and adjectives.";
}
else if (nounCount == 0 && verbCount == 0)
{
    error = error + "Error: Not enough nouns and verbs.";
}
else if (adjectiveCount == 0 && verbCount == 0)
{
    error = error + "Error: Not enough adjectives and verbs.";
}
else if (nounCount == 0 && adjectiveCount == 0 && verbCount == 0)
{
    error = error + "Error: Not enough nouns, adjectives, and verbs.";
}
output = "Error: Not enough " + error;
break;