mGpsEscolas = aMap.get(IdEscola).getIds_alunos();
if (mGpsEscolas == null) {
    mGpsEscolas = new GPSEscolas();
    aMap.put(IdEscola, mGpsEscolas);
    mGpsEscolas.setIds_alunos(IdAluno);
} else {
    String ia = mGpsEscolas.getIds_alunos();
    if (!ia.matches(ia, "(.*;)?" + IdAluno + "(;.*)?")) {
        ia += ";" + IdAluno;
    } else {
        //Remove IdEscola if exists.
        ia = ia.replaceFirst(";" + idAluno + "((;.*)?)$", "$1");
    }
    mGpsEscolas.setIds_alunos(ia);
}