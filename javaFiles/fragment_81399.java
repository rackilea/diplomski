// psuedo code
while( true ) {
    line = "enter score or s to skip".prompt()

    if (!"s".equals(line)) { // it wasn't s, read it
       score = Double.parseDouble(line)
    } else {
       ... skip or assign a default
       score = 0.0d;
    }

    line = "enter grade or s to skip".prompt()
    if ( !"s".equals(line) ) { it wasn't s, then read
      grade = line;
    } else { 
       .. skip or put default
      grade = "A"
    }