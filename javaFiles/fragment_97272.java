long distance = 60; // kilometers
double speed = 40.0d; // kmph

double speed_in_meters_per_minute = ( speed * 1000 ) / 60; // mpm

// now calculate time in minutes
double time = (double)distance / speed_in_meters_per_minute ;