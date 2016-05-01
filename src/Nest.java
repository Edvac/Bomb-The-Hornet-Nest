/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xronis
 */
public class Nest {
    private int xCoordinance, yCoordinance, hornets;

    public Nest(int xCoordinance, int yCoordinance, int hornets) {
        this.xCoordinance = xCoordinance;
        this.yCoordinance = yCoordinance;
        this.hornets = hornets;
    }

    public int getXCoordinance() {
        return xCoordinance;
    }

    public void setXCoordinance(int xCoordinance) {
        this.xCoordinance = xCoordinance;
    }

    public int getYCoordinance() {
        return yCoordinance;
    }

    public void setYCoordinance(int yCoordinance) {
        this.yCoordinance = yCoordinance;
    }

    public int getHornets() {
        return hornets;
    }

    public void setHornets(int hornets) {
        this.hornets = hornets;
    }
    

    @Override
    public String toString() {
        return "X = \t" + xCoordinance + "\nY =\t" + yCoordinance + "\nHornets =\t" + hornets;
    }
    
    
}
