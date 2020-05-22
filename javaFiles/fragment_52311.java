{-1, "Invalid Value"}, //seconds < 0 returns "Invalid value"minutes, "
{0, "00h 00m 00s"}, //boundary case, everything zero
{1, "00h 00m 01s"}, //last digit (seconds)
{10, "00h 00m 10s"}, //but last digit (seconds)
{59, "00h 00m 59s"}, //boundary case
{60, "00h 01m 00s"}, //boundary case, last digit (minutes)
...