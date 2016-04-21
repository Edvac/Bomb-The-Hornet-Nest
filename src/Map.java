package javaapplication2;



import javax.security.auth.login.Configuration;
import java.util.Arrays;

/**
 * Created by George, Haris and Hronis on 11-Apr-16.
 */
public class Map
{
    // static problem solution
    private int [][] arrayMap = {{25,65,100},{23,8,200},{7,13,327},{95,53,440},{3,3,450},
            {54,56,639},{67,78,650},{32,4,678},{24,76,750},{66,89,801},
            {84,4,945},{34,23,967}};

    private double distanceMax;

    private int x;
    private int y;

    public Map()
    {
        x = 12;
        y = 3;
        distanceMax = 141.42;
    }

    public Map(int x, int y)
    {
        this.x = x;
        this.y = y;
        arrayMap = new int[x][y];
    }

    public double distanceMax()
    {
       return Math.sqrt(2) * 100; //Anti toy 100 einai i diastasi tou pinaka px. n
    } // end distanceMax

    public int[][] getArrayMap()
    {
        return arrayMap;
    }

    public void setArrayMap(int[][] arrayMap)
    {
        this.arrayMap = arrayMap;
    }

    public double getDistaneMax()
    {
        return distanceMax;
    }

    public void setDistaneMax(float distaneMax)
    {
        this.distanceMax = distaneMax;
    }

    @Override
    public String toString()
    {
        String arrayMapString ="";
        for (int i=0; i<x; i++){
            arrayMapString += "Number Nest "+(i+1)+" :";
            for (int j=0; j<y; j++){
                arrayMapString +=  arrayMap[i][j] + "," ;
            }
            arrayMapString += "\n";
        }
        return arrayMapString;
    } // end toString
}// end map
