public Individu(Individu ind) {
    this.setId(ind.id);
    this.chromosome = new double[ind.chromosome.length];
    for (int i = 0; i < ind.chromosome.length; i++)
        this.chromosome[i] = ind.chromosome[i];
    this.parent = null;
}