String [] Fitness = "Average fitness#Worst fitness #Best Fitness".split("#");
writer.writeNext(Fitness);

int aFit = myPop.individuals[25].getFitness();
String aFit1 = Integer.toString(aFit);

int wFit = myPop.individuals[49].getFitness();
String wFit1 = Integer.toString(wFit);

int bFit = myPop.individuals[1].getFitness();
String bFit1 = Integer.toString(bFit);

writer.writeNext(new String[]{aFit1, wFit1, bFit1});