String replacement;

if (output.charAt(i) == '#')
{
    if (nouns.size() > 0)
    {
        int random = rand.nextInt(nouns.size());
        replacement = nouns.get(random);
        nouns.remove(random);
    } else {
        return "Error: ran out of nouns";
    }
} else if  ...

output = output.substring(0, i) + replacement+ (output.substring(i + 1));