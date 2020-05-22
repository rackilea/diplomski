String[] lijnen = readDefinitioncsv(definitioncsv).split("\r?\n");
for (int i =2;i<lijnen.length;i++){
    String[] detaillijn = lijnen[i].split("[,;\t]");
    if (detaillijn.length < 5) {
        throw new IllegalArgumentException("Weiniger als 5 elementen: "
                + lijnen[i]);
    }