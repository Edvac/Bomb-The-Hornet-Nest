package javaapplication2;

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
        System.out.println("Genetics2!");

        Map map1 = new Map();
        calculateB(map1);
        
        System.out.println("Distance max: "+map1.distanceMax());

    } // end main method

} // end Main class
