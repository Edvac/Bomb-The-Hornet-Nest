import java.util.Random;
import org.w3c.dom.Document;

public class Main
{

    public static void calculateK(Map map1)
    {
      double K[] = new double [3];
      Random rand = new Random();
      int arrayMap [][]= map1.getArrayMap();
      int bombMap [][]= {{rand.nextInt((100-1)+1)+1,rand.nextInt((100-1)+1)+1},{rand.nextInt((100-1)+1)+1,rand.nextInt((100-1)+1)+1},{rand.nextInt((100-1)+1)+1,rand.nextInt((100-1)+1)+1}};
      double d ;


          for(int k = 0; k < 3;k++)
          {
              for(int i = 0;i<12;i++)
              {
                  d = Math.sqrt(Math.pow((bombMap[k][0]-arrayMap[i][0]),2)+
                          Math.pow((bombMap[k][1]-arrayMap[i][1]),2));

                  K[k] += arrayMap[i][2]*(map1.getDistaneMax()/((20*d)+0.00001));

              }
              System.out.println(K[k]);
          }

    }
    public static void main(String[] args)
    {
        System.out.println("Genetics2!");

        Map map1 = new Map();

        calculateK(map1);
        //System.out.println(map1);


       // System.out.println(map1.distanceMax());



    }

}
