class Chromosome {
    // values
    public static Chromosome chromosomeFactory(String type) {
        switch(type) {
        case EYE_COLOUR:
            return new EyeColourChromosome(...);
            break;
        case HEIGHT:
            return new HeightChromosome(...);
            break;
        }
    }
}