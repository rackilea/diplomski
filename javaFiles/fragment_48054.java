for(int i = 0; i < 6; i++) {  // Since 6 characters in an array.

    for(int j = 0; j < y; j++) {

        // Print first characters from each required array, then second characters on a new line, then third and so on.
        switch(sc[j] + 1) {  // Since counting starts from 0.

            case 1: System.out.print("\t"+a[i]); break;
            case 2: System.out.print("\t"+b[i]); break;
            case 3: System.out.print("\t"+c[i]); break
            case 4: System.out.print("\t"+d[i]); break
            case 5: System.out.print("\t"+e[i]); break; // Prone to ArrayIndexOutOfBoundsException
        }
    }
    System.out.println(); // Print a newline character after printing every line
}