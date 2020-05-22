int fitness(boolean[] chromosome)
{
    int[] intChromosome = toInt(chromosome);

    // the ingredients are:  0     1     2     3   4    5     6
    //          salt sugar lemon egg water onion apple
    return ( -intChromosome [0] + intChromosome [1] + intChromosome [2] 
         -intChromosome [3] + intChromosome [4] - intChromosome [5] 
         -intChromosome [6] );  
}

int[] toInt(boolean[] values) {
    int[] integers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
        integers[i] = values[i] ? 1 : 0;
    }
    return integers;
}