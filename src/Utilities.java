/**
 * Created by George on 23-Apr-16.
 */
public abstract class Utilities
{
    public static int [] CalculateFitness(int [][] coordinates,int population,int map[][],double maxD)
    {

        double d=0;
        int deadHornets[] = new int[50];

        for (int i=0; i< population ;i++ )
        {
            System.out.println("Population "+i);
            for (int j=0; j < 6 ;j+=2 ) {

                for (int i1 = 0; i1 < map.length; i1++)
                {
                    d = Math.sqrt(Math.pow((coordinates[i][j] - map[i1][0]), 2) +
                            Math.pow((coordinates[i][j+1] - map[i1][1]), 2));

                    // Theoretical Hornets killed by single bomb (Doesn't calculating overlapping kills by other bombs)
                    deadHornets[i] += map[i1][2]*(maxD/((20*d)+0.00001));

                }
            }

           // System.out.println("DeadHornets : "+deadHornets[i]);
        }
        return deadHornets;
    }
}// end Utilities
