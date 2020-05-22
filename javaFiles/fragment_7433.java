public static int compareByTime(Second s0, Second s1)
{
    First f0 = s0.object;
    First f1 = s1.object;
    if (f0.month > f1.month) return 1;
    if (f0.month < f1.month) return -1;
    if (f0.day > f1.day) return 1;
    if (f0.day < f1.day) return -1;
    if (f0.hour > f1.hour) return 1;
    if (f0.hour < f1.hour) return -1;
    if (f0.minute > f1.minute) return 1;
    if (f0.minute < f1.minute) return -1;
    return 0;
}