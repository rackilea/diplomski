// Code segment A
Horse h = new Equestrian();
Goat g = (Goat)h;

// Code segment B
Horse h = new Equestrian();
Racer r = (Racer)h;

// Code segment C
Horse h = new Racer();
Racer r = (Racer)h;