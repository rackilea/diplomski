@SuppressWarnings("resource")
            Scanner sc = new Scanner(System.in);        
            String tekst = sc.nextLine();
            String code = ""; //Variable om de code te laten werken.

            for (int i = 0, j = 0; i < tekst.length(); i++) {
                 char ch = tekst.charAt(i);
                 if (ch < 'a' || ch > 'z') continue; //Negeert nummers.
                 code += (char)((ch + sleutel.charAt(j) - 2 * 'a') % 26 + 'a');
                 j = ++j % sleutel.length();
            }
        System.out.println("Omgezet geeft dit: ");
        System.out.println(code);

    }