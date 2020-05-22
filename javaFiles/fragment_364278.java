while (input.hasNext()) {
                String straat = input.nextLine();
                String huisNrMetKomma = input.nextLine();
                int huisNummer = Integer.parseInt(huisNrMetKomma.substring(0, huisNrMetKomma.length() - 1));
                String plaats = input.nextLine();

                adressen.add(new Adres(straat, huisNummer, plaats));
            }