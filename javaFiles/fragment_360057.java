int j = 0;
for (int i = 0; i < data.size(); i++) { 
    if (patternString.charAt(j) == data.get(i)) {
        while (j < patternString.length() && i < data.size() && //indices checks
                   patternString.charAt(j) == data.get(i) ) { 
            j++;
            i++;
        }   
        if (j == patternString.length()) {
            i -= patternString.length(); //set i back to the start of the pattern
            System.out.println("Found pattern " + "at index " + (i));
        }
        j = 0;
    } 
}