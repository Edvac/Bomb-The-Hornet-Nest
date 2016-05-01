
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int maxGenerations = 1000;
        int population = 200;
        //int chromosome[][] = new int[population][6]; // array with  chromosome
        ArrayList<Chromosome> roulleteChromosome = new ArrayList();
        Random rand = new Random();
        Map map1 = new Map();

        ArrayList<Integer> fitness = new ArrayList();
        ArrayList<Integer> newfitness = new ArrayList();



        int max = -99999;
        int gener = 0;
        int minus = 0;
        int pos = 0;

        TreeMap<Integer, Integer> chromosomeWithFitness = new TreeMap();
        ArrayList<Chromosome> chromosome = new ArrayList();
        int tournamentSelected;

        for (int i = 0; i < population; i++) {

            Chromosome chromo = new Chromosome(rand.nextInt((100 - 1) + 1) + 1,
                    rand.nextInt((100 - 1) + 1) + 1,
                    rand.nextInt((100 - 1) + 1) + 1,
                    rand.nextInt((100 - 1) + 1) + 1,
                    rand.nextInt((100 - 1) + 1) + 1,
                    rand.nextInt((100 - 1) + 1) + 1);

            chromosome.add(chromo);
            System.out.println(chromo);
        }

        // 6947 total hornets to kill
        for (int k = 0; k < maxGenerations; k++) {

            System.out.println("Generation: " + (k + 1) + "--------------");

            fitness = Utilities.CalculateFitness(chromosome, map1);

            for (int i = 0; i < population; i++) {
                //System.out.println(fitness.get(i));
                chromosomeWithFitness.put(fitness.get(i), i);
            }

            for (int i = 0; i < population; i++) {

                tournamentSelected = Utilities.tournamentSelection(chromosomeWithFitness);

                roulleteChromosome.add(chromosome.get(tournamentSelected));

                newfitness.add(fitness.get(i));
                System.out.print(chromosome.get(i));
                System.out.println("\t" + newfitness.get(i));

                if (newfitness.get(i) > max) {
                    max = newfitness.get(i);
                    gener = k + 1;
                }

                if (newfitness.get(i) < minus) {
                    minus = newfitness.get(i);
                    pos = k + 1;
                }
            }

            chromosome = Utilities.crossOver(roulleteChromosome, population);
//            chromosome.stream().forEach(i -> System.out.println(i));

//----------------------Mutation Try-------------------------------------------------------------
            int index;
            for (Chromosome chromo : chromosome) {

                index = chromosome.indexOf(chromo);

                if (Math.random() < 0.01) {
                    chromosome.set(index, Utilities.mutation(chromo));
                }
            }
            fitness = newfitness;
        }

        System.out.println("Max : " + max);
        System.out.println("Generation : " + gener);
        System.out.println("Negative : " + minus);
        System.out.println("Position : " + pos);
    } // end main method
} // end Main class
