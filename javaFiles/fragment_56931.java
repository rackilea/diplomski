int maxSize = Math.max(interviewTimingToFrom1.size(),interviewTimingToFrom2.size());
StringBuilder result = new StringBuilder();
for (int i=0; i<maxSize; i++)
{
    if (i < interviewTimingToFrom1.size())
        result.append(interviewTimingToFrom1.get(i));

    if (i < interviewTimingToFrom2.size())
        result.append(interviewTimingToFrom2.get(i));
}
System.out.println(result.toString());