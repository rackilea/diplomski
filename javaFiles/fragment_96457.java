public void calcFitness(String target){
    double score = 0.0;
    for(int i = 0; i < this.genes.length; i++){
        score += Math.abs((int)this.genes[i] - (int)target.charAt(i));
    }
    this.fitness = score / this.genes.length;
}