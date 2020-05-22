class Elezione {
    private candidatoCounter = 0;
    ................

    Candidato createCandidato() {
        return new Candidato(candidatoCounter++);
    }
}

class Candidato {
    private int id;
    Candidato(int id) {
        this.id = id;
    }

}