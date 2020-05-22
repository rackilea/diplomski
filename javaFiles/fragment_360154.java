private Set<String> ids_alunos = new TreeSet<>();

mGpsEscolas = aMap.get(IdEscola);
if (mGpsEscolas == null) {
    mGpsEscolas = new GPSEscolas();
    aMap.put(IdEscola, mGpsEscolas);
    mGpsEscolas.getIds_alunos().add(IdAluno);
} else {
    Set<String> ia = mGpsEscolas.getIds_alunos();
    if (!ia.contains(IdAluno)) {
        ia.add(IdAluno);
    } else {
        //Remove IdEscola if exists.
        ia.remove(idAluno);
    }
}