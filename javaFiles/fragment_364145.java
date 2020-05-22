for(int i = 0; i < s.length(); i++) {
    switch(s.charAt(i)) { 
     case '.':
        periodCount++;
        break;
     case ',':
        commaCount++;
        break;
     ... // similar conditions for others
    }
    total += 1;
}