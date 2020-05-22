package ga;

import java.util.ArrayList;
import java.util.Arrays;

public class GA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //computation time
        long start = System.nanoTime();
        //population size
        int populationSize = 30;
        //Number of Cities
        int numCities = 15;
        //Mutation rate
        double mutationRate = 0.05;
        //Crossover Rate
        double crossoverRate = 0.8;
        //Choose File path or if false randomly created Path
        boolean useFile = false;
        //Name the file to be used
        String fileName = "Data.txt";
        //Current Number of Generations
        int numberOfGenerations = 0;
        //Stop Condition
        int stopAt=2500;
        //Population
        Population pop;
        //use GA or Brute Force
        boolean GAuse=true;



        //Selecting File mode or Random Mode
        if (useFile == false) {

            pop = new Population(populationSize, numCities, crossoverRate, mutationRate);

        } else {
            FileReader file = new FileReader(fileName);
            numCities=file.getNumCities();
            crossoverRate=file.getCrossoverRate();
            mutationRate=file.getMutationRate();
            populationSize=file.getCities().length;
            Path p = new Path(file.getNumCities());
            p.setPath(file.getCities());
            pop = new Population(populationSize, numCities, p,crossoverRate ,mutationRate );

        }
        if(GAuse==true){

      //Sorting the population from Finess / Evaluating
        pop.FitnessOrder();

                //Prints each path ID/Cost/Fitness/City order(with coordinates)
         for (int i = 0; i < pop.getPopulation().length; i++) {
            System.out.println("Path ID: "+i+" | Cost: "+pop.getPopulation()[i].getCost()+" | Fitness: "+pop.getPopulation()[i].getFitness()+"%");
            System.out.print("Path is: ");
            for (int j = 0; j < pop.getPopulation()[i].getPath().length; j++) {
                System.out.print(pop.getPopulation()[i].getPath()[j].getId() +"("+pop.getPopulation()[i].getPath()[j].getX()+","+pop.getPopulation()[i].getPath()[j].getY()+")  ");

         }System.out.println("\n -----------------------------------------------------");
        }

      //Start looking for possible solution
        while (numberOfGenerations !=stopAt) {

            //Select / Crossover
            while (pop.Mate() == false);              
            //Mutate
            for (int i = 0; i < pop.getNextGen().length; i++) {
            pop.getNextGen()[i].setPath(pop.Mutation(pop.getNextGen()[i].getPath()));

            }

            //Setting the new Generation to current Generation
            pop.setPopulation(pop.getNextGen());
            pop.setDone(0);
            //Sorting the new population from Finess / Evaluating
            pop.FitnessOrder();
            //Incremente number of Generations
            numberOfGenerations++;
        }


      //Prints out the fitness of each path
        double valor=0;
        for (int i = 0; i < pop.getPopulation().length; i++) {
            valor += pop.getPopulation()[i].getFitness();
            System.out.println("Value of Fitness: "+pop.getPopulation()[i].getFitness()+"%");
        }
        System.out.println("");
        System.out.println("Total Fitness: "+valor+"%");

        System.out.println("\n-----------------------------------------------");


        //Prints each path ID/Cost/Fitness/City order(with coordinates)
         for (int i = 0; i < pop.getPopulation().length; i++) {
            System.out.println("Path ID: "+i+" | Cost: "+pop.getPopulation()[i].getCost()+" | Fitness: "+pop.getPopulation()[i].getFitness()+"%");
            System.out.print("Path is: ");
            for (int j = 0; j < pop.getPopulation()[i].getPath().length; j++) {
                System.out.print(pop.getPopulation()[i].getPath()[j].getId() +"("+pop.getPopulation()[i].getPath()[j].getX()+","+pop.getPopulation()[i].getPath()[j].getY()+")  ");

         }System.out.println("\n -----------------------------------------------------");
        }

        }



        else{//USING BRUTE FORTE METHOD

         FileReader file = new FileReader(fileName);
         ArrayList<City> cities = new ArrayList<City>();

            for (int i = 0; i <file.getNumCities(); i++) {
            cities.add(file.getCities()[i]);
            }           

        ArrayList<City> best = new ArrayList<City>();
        Permutations permu = new Permutations();
        permu.permutations(cities);
            System.out.print("The shortest path is: ");
            for (int i = 0; i < permu.getBest().size(); i++) {
                System.out.print(permu.getBest().get(i).getId()+"("+permu.getBest().get(i).getX()+","+permu.getBest().get(i).getY()+")");
            }
            System.out.println("");
            System.out.println("It would Cost: "+permu.getCost());
        }

        long elapsedTime = System.nanoTime() - start; 
        System.out.println("Algorithm took: "+elapsedTime+" nano seconds to find a solution");
    }



    }