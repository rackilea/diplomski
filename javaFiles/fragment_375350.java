case PATTERN_HOUR1: // 'h' 1-based.  eg, 11PM + 1 hour =>> 12 AM
     if (!isLenient()) {
         // Validate the hour value in non-lenient
         if (value < 1 || value > 12) {
             break parsing;
         }
     }
     // [We computed 'value' above.]
     if (value == calendar.getLeastMaximum(Calendar.HOUR) + 1) {
         value = 0;
     }
     calb.set(Calendar.HOUR, value);
     return pos.index;