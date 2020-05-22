String[] Info_TimeD1;
String[] ohh;
// int i; <-- Duplicate variable with your for loop.

int L1 = Info_TimeD1.length;
Long[] Timestamp1 = new Long[L1]; // <-- Declare your array.
for (int i = 0; i < L1; i++) {
    Timestamp1[i] = Long.parseLong(Info_TimeD1[i]); // <-- Fixed.
    ohh[i] = getDateCurrentTimeZone1(Timestamp1[i]);
}