long remaining = XXXX;

int weeks   = (int)( remaining / WEEK);
int days    = (int)((remaining % WEEK) / DAY);
int hours   = (int)((remaining % DAY) / HOUR);
int minutes = (int)((remaining % HOUR) / MINUTE);
int seconds = (int)((remaining % MINUTE) / SECOND);