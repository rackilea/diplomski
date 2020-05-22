long seconds = diff / 1000; // seconds is milliseconds / 1000
long milliseconds = diff % 1000; // remainder is milliseconds that are not composing seconds.
long minutes = seconds / 60;
seconds = seconds % 60;
long hours = minutes / 60;
minutes = minutes % 60;