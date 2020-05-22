return a == null 
       ? "" 
       : (a + a != null && b != null) 
            ? "\n" 
            : ("" + b == null) 
                ? "" 
                : b;