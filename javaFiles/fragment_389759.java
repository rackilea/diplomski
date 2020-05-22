List<String> acids = new LinkedList<String>();

for (int i = 0; i < fastaString.length(); i+=3){
    currentFastaAcid = fastaString.substring(i, i + 3);
    acids.add(currentFastaAcid);
}

System.out.println(acids.toString());