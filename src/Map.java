import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;

import javax.security.auth.login.Configuration;

/**
 * Created by George, Haris and Hronis on 11-Apr-16.
 */
public class Map
{
//    int [][] arrayMap;
//
//    public Map()
//    {
//        // [nest rank], [coordinates], [number of hornets
//        arrayMap = new int[12][3];
//    }
//
//    public Map(int x,int y)
//    {
//     arrayMap = new int[x][y];
//    }
//
//    public void distanceMax()
//    {
//
//
//    }
    private static final int MAX_EVOLUTIONS_PERMITTED = 2500;
    public static long timeTotal = 0;

    // Chromosome
    public static IChromosome calculateMapMinimum(int people) throws Exception
    {
        // sindesi me times prokathorismenes
        Configuration conf = new DefaultConfiguration();

        // kaliteri epilogi gia tin epomeni geneia
        conf.setPresservFittestIndividual(true);

        // dimiourgia sinartisis me anathesi timis
        FitnessFunction myFunc = new MinimumFunction(people);
        conf.setFitnessFunction(myFunc);

        // 6 goniadia, 6 chromosomata
        Gene [] sampleGenes = new Gene[6];
        sampleGenes[0]
    } // end calculateMapMinimum





}
