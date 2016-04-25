
import java.util.Random;
import java.util.Set;

/**
 * Created by George on 23-Apr-16.
 */
public abstract class Utilities
{


    private static int [] arrayHornetsPopulation  = {100,200,327,440,450,639,650,678,750,801,945,967};
    public static int [] CalculateFitness(int [][] coordinates,int population,int map[][],double maxD)
    {

        double d;
        int deadHornets[] = new int[population];
        int k ;
        for (int i=0; i< population ;i++ )
        {
           // System.out.println("Population "+i);
            for (int j=0; j < 6 ;j+=2 ) {

                for (int i1 = 0; i1 < map.length; i1++)
                {
                    d = Math.sqrt(Math.pow((coordinates[i][j] - map[i1][0]), 2) +
                            Math.pow((coordinates[i][j+1] - map[i1][1]), 2));

                    // Theoretical Hornets killed by single bomb (Doesn't calculating overlapping kills by other bombs)
                   k= (int)(map[i1][2]*(maxD/((20*d)+0.00001)));
                   map[i1][2] -=k;
                    if(map[i1][2]<0)
                    {

                       // System.out.println("Problem with the: "+i);
                       // System.out.println("DeadHornets First: "+ deadHornets[i]);
                        deadHornets[i] = deadHornets[i] -((deadHornets[i]*20)/100);
                     //   System.out.println("DeadHornets During: "+ deadHornets[i]+",k:"+ k);
                        deadHornets[i] += k;
                       //System.out.println("DeadHornets total: "+ deadHornets[i]);
                       continue;
                    }

                    deadHornets[i] += k;


                }
            }

            //System.out.println("DeadHornets : "+deadHornets[i]);

            //1st Sollution
          //  map = refill(map);

            //2nd Sollution
             for(int k1=0;k1<arrayHornetsPopulation.length;k1++)
             {
                map[k1][2]= arrayHornetsPopulation[k1];

             }
            //3rd Static refill mesa sthn map klasi alla prepei na kanoyme static kai ton arrayMap kai arrayHornetsPopulation
            //giati alliws bgazei error.Den xerw ti einai kalytero.....
            //Map.refill();


        }
        return deadHornets;
    }
    public static int roulleteSelectionMethod(int fitness[])
    {

        int totalSum = 0;
        Random rand = new Random();
        for(int i=0;i<fitness.length;i++)
        {
            totalSum += fitness[i];
        }
        int randNumber =  rand.nextInt((totalSum)+1);

        int partialSum = 0;


        for(int i=0;i<fitness.length;i++)
        {

           // randNumber -= fitness[i];
            //if(randNumber<=0) return i;

            partialSum +=fitness[i];
            if(partialSum>=randNumber)
            {
                return i;
            }

        }

        return fitness.length-1;

    }
    public static int tournamentSelection(int fitness[])
    {

        Random rand = new Random();
        int randSize = rand.nextInt(fitness.length)+1;
        int bestChromosome = -999;
        int bestIndex=0;
        int tournament [] = new int[randSize];
        int randIndex;
        for(int i =0;i<randSize;i++)
        {
            randIndex=rand.nextInt(fitness.length-1)+1;
            tournament[i]=fitness[randIndex];
            if(tournament[i]>bestChromosome)
            {
               bestChromosome = tournament[i];
                bestIndex = randIndex;

            }
        }
          return bestIndex;
    }

    public static int [][] crossOver(int [][]roulleteChromosome,int population)
    {
      Random rand = new Random();
        int randFather,randMother,randCut;
        int childrenChromosome [][] = new int[population][6];
        randCut = 3;//3  ((rand.nextInt(2)+1)*2)-1;//emfanizei to 1 h to 3.
       // System.out.println(randCut);

        for(int i=0;i<population/2;i++)
        {
            randFather = rand.nextInt((population-1)+1);
            randMother = rand.nextInt((population-1)+1);


            for(int i2=0;i2<population-1;i2+=2)
            {
                for(int i1=0;i1<=randCut;i1++)
                {
                    childrenChromosome[i2][i1] = roulleteChromosome[randFather][i1];
                     childrenChromosome[i2+1][i1] = roulleteChromosome[randMother][i1];


                }
                for (int j=randCut+1; j<6; j++)
                {
                    childrenChromosome[i2][j] = roulleteChromosome[randMother][j];
                    childrenChromosome[i2+1][j] = roulleteChromosome[randFather][j];

                }


                System.out.println("\nFather");
                          for(int k=0; k< 6; k++)
                          {
                            System.out.print(roulleteChromosome[randFather][k]+",");
                          }
                System.out.println("\nMother");
                for(int k=0; k< 6; k++)
                {
                    System.out.print(roulleteChromosome[randMother][k]+",");
                }
                  /*
                System.out.println("\nChild1");
                for(int k=0; k< 6; k++)
                {
                    System.out.print( childrenChromosome[i2][k] +",");
                }
                System.out.println("\nChild2");
                for(int k=0; k< 6; k++)
                {
                    System.out.print( childrenChromosome[i2+1][k] +",");
                }
               */
            }

        }
        return childrenChromosome;
    }
    public static int[][] refill(int arrayMap [][])
    {
        for(int i=0;i<arrayHornetsPopulation.length;i++)
        {
            arrayMap[i][2]=arrayHornetsPopulation[i];

        }
        return arrayMap;

    }
}// end Utilities
