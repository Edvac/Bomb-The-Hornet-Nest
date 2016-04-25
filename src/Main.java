
import java.util.Arrays;
import java.util.Random;
import org.w3c.dom.Document;

public class Main
{

    public static void calculateB(Map map1)
    {
        // Bombs
        double B[] = new double [3];
        Random rand = new Random();
        int bombMap [][]= {{rand.nextInt((100-1)+1)+1,rand.nextInt((100-1)+1)+1},{rand.nextInt((100-1)+1)+1,rand.nextInt((100-1)+1)+1}
                ,{rand.nextInt((100-1)+1)+1,rand.nextInt((100-1)+1)+1}};
        // get hornets' nests map to calculate d
        int arrayMap [][]= map1.getArrayMap();
        double d ;
        int sumDeadHornets =0;
        // calculate d for each bomb with each nest
        for(int k = 0; k < 3;k++)
        {
            for(int i = 0;i<12;i++)
            {
                d = Math.sqrt(Math.pow((bombMap[k][0]-arrayMap[i][0]),2)+
                        Math.pow((bombMap[k][1]-arrayMap[i][1]),2));
                // Theoretical Hornets killed by single bomb (Doesn't calculating overlapping kills by other bombs)
                B[k] += arrayMap[i][2]*(map1.getDistaneMax()/((20*d)+0.00001));
            }
            System.out.println("Bomb " + (k+1)+": " +B[k] + " Coordinates: x:" + bombMap[k][0]+", y:"+bombMap[k][1]);

            sumDeadHornets +=B[k];
        }
        System.out.println("Dead Hornets: "+sumDeadHornets);



    } // end calculateB


    public static void main(String[] args)
    {
        int maxGenerations = 10;
        int population = 50;
        int chromosome[][] = new int[population][6]; // array with  chromosome
        int roulleteChromosome[][] = new int[population][6];
        Random rand = new Random();
        Map map1 = new Map();
        int map [][] = map1.getArrayMap();
       int fitness[]= new int[population];

        int roulleteSelected ;
        int tournamentSelected;

        for(int i=0;i<population;i++)
        {
            for(int j=0;j<6;j++)
            {
                chromosome[i][j]= rand.nextInt((100-1)+1)+1;
                System.out.print(chromosome[i][j]+"\t");
            }
            System.out.println();
        }// end for

        for (int k=0; k< maxGenerations;k++ ) {

            System.out.println("Generation: " + (k+1)+"--------------");



            //System.out.println("Fitness is happening now Dude!!!");

            fitness = Utilities.CalculateFitness(chromosome,population,map,map1.getDistaneMax());


            for(int i=0;i<population;i++)
            {
                tournamentSelected= Utilities.tournamentSelection(fitness);

                //  System.out.println("The roullete wheel select: "+roulleteSelected);
                // System.out.print("The new array Chromosome: ");
                for(int j=0;j<6;j++)
                {
                    roulleteChromosome[i][j] =chromosome[tournamentSelected][j];
                     System.out.print(roulleteChromosome[i][j]+" , ");

                }
                System.out.println();


            }// end for
           /* for(int i=0;i<population;i++)
            {
                roulleteSelected= Utilities.roulleteSelectionMethod(fitness);

              //  System.out.println("The roullete wheel select: "+roulleteSelected);
                // System.out.print("The new array Chromosome: ");
                for(int j=0;j<6;j++)
                {
                    roulleteChromosome[i][j] =chromosome[roulleteSelected][j];
                   // aisto dialo System.out.print(roulleteChromosome[i][j]+" , ");

                }
                //System.out.println(fitness[roulleteSelected]);


            }// end for
            */
            chromosome=Utilities.crossOver(roulleteChromosome,population);
            // chromosome=roulleteChromosome;


        }


    } // end main method
} // end Main class
