epsilonStanja = sljedecaStanja;

            for (String epsilonStanje : epsilonStanja) {
                ...
                sljedecaStanja.addAll(trenutniPrijelaz.getSkupIzlaznihStanja());
                ...
            }