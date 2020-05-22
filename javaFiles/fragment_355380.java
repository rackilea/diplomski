String s = "$Huey, $Dewey, and $Louie all live in Duckcity. $Goofy and $Mickey live there too.";
    String[] a = 
            // Split it into words.
            Arrays.stream(s.split("[, .]"))
            // Pick only the words starting with '$'
            .filter(w -> w.startsWith("$"))
            // Remove the '$'
            .map(w -> w.substring(1))
            // Make a list.
            .collect(Collectors.toList())
            // And turn it into an array.
            .toArray(new String[0]);
    System.out.println(Arrays.toString(a));