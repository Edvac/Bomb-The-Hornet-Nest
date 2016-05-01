
import java.util.Random;
import java.util.Set;

/**
 * Created by George on 23-Apr-16.
 */
public abstract class Utilities
{


    private static int [] arrayHornetsPopulation  = {100,200,327,440,450,639,650,678,750,801,945,967};
    public static ArrayList<Integer> CalculateFitness(ArrayList<Chromosome> chromosomes, Map map) {

        double arrayDistance[][] = new double[12][3];
        double dmax = map.getDistaneMax();
        ArrayList<Integer> deadHornets = new ArrayList();

        chromosomes.stream().forEach((_item) -> {
            deadHornets.add(0);
        });

        int k = 0;

        ArrayList<Nest> nests = map.getArrayMap();

        for (int i = 0; i < chromosomes.size(); i++) {
            arrayDistance = calculateDistance(chromosomes.get(i),nests);
            //System.out.println("Population:"+i);
            deadHornets.add(i, 0);
            for(int i1=0;i1<3;i1++)
            {
                //  System.out.println("Bomb :"+i1);
                for (Nest nest : nests) {

                    k = (int) (nest.getHornets() * (dmax / ((20 * arrayDistance[nests.indexOf(nest)][i1])) + 0.00001));

                    // System.out.println("K : " + k);
                    if (nest.getHornets() - k < 0) {
                        if (deadHornets.get(i) - ((deadHornets.get(i) * 20) / 100) > 0) {
                            deadHornets.add(i, deadHornets.get(i) - ((deadHornets.get(i) * 20) / 100));
                        }
                    } else {
                        nest.setHornets(nest.getHornets() - k);
                        // System.out.println("deadhornets "+i+": "+deadHornets.get(i));
                        deadHornets.add(i, deadHornets.get(i) + k);
                    }

                }
            }




            for (int j = 0; j < nests.size(); j++) {
                nests.get(j).setHornets(arrayHornetsPopulation[j]);
            }
        }

        return deadHornets;
    }

    public static double[][] calculateDistance(Chromosome chromosome,ArrayList<Nest> nest)
    {
        double arrayDistance [][] = new double[12][3];
        int i = 0;
        for (Nest n : nest) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        arrayDistance[i][j] = (Math.sqrt(Math.pow(chromosome.getFirstXCoordinance() - n.getXCoordinance(), 2)
                                + Math.pow(chromosome.getFirstYCoordinance() - n.getYCoordinance(), 2)));
                        break;

                    case 1:
                        arrayDistance[i][j] = (Math.sqrt(Math.pow(chromosome.getSecondXCoordinance()- n.getXCoordinance(), 2)
                                + Math.pow(chromosome.getSecondYCoordinance()- n.getYCoordinance(), 2)));
                        break;

                    case 2:
                        arrayDistance[i][j] = (Math.sqrt(Math.pow(chromosome.getThirdXCoordinance() - n.getXCoordinance(), 2)
                                + Math.pow(chromosome.getThirdYCoordinance() - n.getYCoordinance(), 2)));
                        break;

                }
            }
            i++;
        }
        return arrayDistance;

    }

    public static int tournamentSelection(TreeMap<Integer, Integer> chromosomeWithFitness) {
        Random rand = new Random();
        TreeMap<Integer, Integer> tournament = new TreeMap();

        ArrayList<Integer> fitness = new ArrayList(chromosomeWithFitness.keySet());
        ArrayList<Integer> indexes = new ArrayList(chromosomeWithFitness.values());

        int pick;
//        System.out.println("Chromosome Size : " +chromosomeWithFitness);
        int tournamentSize = rand.nextInt(chromosomeWithFitness.size() - 3) + 3;

        for (int i = 0; i < tournamentSize; i++) {
            pick = rand.nextInt(chromosomeWithFitness.size() - 3) + 3;

            tournament.put(fitness.get(i), indexes.get(i));
        }

        return tournament.lastEntry().getValue();
    }

    public static ArrayList<Chromosome> crossOver(ArrayList<Chromosome> roulleteChromosome, int population) {

        Random rand = new Random();
        int randFather, randMother, randCut;

        ArrayList<Chromosome> childrenChromosomes = new ArrayList();
        randCut = ((rand.nextInt(2) + 1) * 2) - 1;
        // System.out.println(randCut);

        Chromosome child;

        int mask[] = new int[6];

        for (int i = 0; i < population; i++) {
            child = new Chromosome();
            for (int j = 0; j < 6; j++) {

                if (j <= randCut) {
                    mask[j] = 0;
                } else {
                    mask[j] = 1;
                }
            }

            randFather = rand.nextInt((population - 1) + 1);
            randMother = rand.nextInt((population - 1) + 1);

            for (int j = 0; j < 6; j++) {
                if (mask[j] == 0) {
                    child.setCoordinance(roulleteChromosome.get(randFather).getCoordinance(j), j);
                } else {
                    child.setCoordinance(roulleteChromosome.get(randMother).getCoordinance(j), j);
                }
            }

            childrenChromosomes.add(child);
        }

        return childrenChromosomes;
    }

    public static Chromosome mutation(Chromosome chromosome) {

        Random rand = new Random();

        chromosome.setCoordinance(rand.nextInt(100), rand.nextInt(6));
        return chromosome;
    }

}// end Utilities
