import java.util.Random;

/**
 * Created by George on 23-Apr-16.
 */
public abstract class Utilities
{


    private static int [] arrayHornetsPopulation  = {100,200,327,440,450,639,650,678,750,801,945,967};
    public static int [] CalculateFitness(int [][] coordinates,int population,int map[][],double maxD)
    {

        double d=0;
        int deadHornets[] = new int[50];
        int k =0;
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

                        deadHornets[i] -= deadHornets[i]*(20/100);
                        deadHornets[i] += k;
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
        for(int i=0;i<fitness.length-1;i++)
        {
            totalSum += fitness[i];
        }
        int randNumber =  rand.nextInt((totalSum-0)+1);
        int partialSum = 0;

        for(int i=0;i<fitness.length-1;i++)
        {
            partialSum +=fitness[i];
            if(partialSum>=randNumber)
            {
                return i;
            }
        }

        return -1;

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
