String word = "aardvark";
        char[] symbols = word.toCharArray();

        for (int i = 0; i < symbols.length - 1; ++i) {
            if (symbols[i] == 'a') { // have to swap with the next symbol
               symbols[i] = symbols[i + 1];
               symbols[i + 1] = 'a';
               ++i;
            }
        }

        String scrambled = new String(symbols);
        System.out.println("scrambled  = " + scrambled); // aardvrak