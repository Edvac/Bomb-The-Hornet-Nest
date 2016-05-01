
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xronis
 */
public class Chromosome {

    private int firstXCoordinance, firstYCoordinance, secondXCoordinance, secondYCoordinance,
            thirdXCoordinance, thirdYCoordinance;

    public Chromosome(int firstXCoordinance, int firstYCoordinance, int secondXCoordinance, int secondYCoordinance, int thirdXCoordinance, int thirdYCoordinance) {
        this.firstXCoordinance = firstXCoordinance;
        this.firstYCoordinance = firstYCoordinance;
        this.secondXCoordinance = secondXCoordinance;
        this.secondYCoordinance = secondYCoordinance;
        this.thirdXCoordinance = thirdXCoordinance;
        this.thirdYCoordinance = thirdYCoordinance;
    }

    public Chromosome() {
    }

    public void setCoordinance(int value, int coordinance) {
        switch (coordinance) {
            case 0:
                setFirstXCoordinance(value);
                break;

            case 1:
                setFirstYCoordinance(value);
                break;

            case 2:
                setSecondXCoordinance(value);
                break;

            case 3:
                setSecondYCoordinance(value);
                break;

            case 4:
                setThirdXCoordinance(value);
                break;

            case 5:
                setThirdYCoordinance(value);
                break;

        }
    }

    public int getCoordinance(int coordinance) {
        switch (coordinance) {
            case 0:
                return getFirstXCoordinance();

            case 1:
                return getFirstYCoordinance();

            case 2:
                return getSecondXCoordinance();

            case 3:
                return getSecondYCoordinance();

            case 4:
                return getThirdXCoordinance();

            case 5:
                return getThirdYCoordinance();

        }

        return 0;
    }

    public void copy(Chromosome chromo) {
        this.firstXCoordinance = chromo.firstXCoordinance;
        this.firstYCoordinance = chromo.firstYCoordinance;
        this.secondXCoordinance = chromo.secondXCoordinance;
        this.secondYCoordinance = chromo.secondYCoordinance;
        this.thirdXCoordinance = chromo.thirdXCoordinance;
        this.thirdYCoordinance = chromo.thirdYCoordinance;

    }

    public int getFirstXCoordinance() {
        return firstXCoordinance;
    }

    public void setFirstXCoordinance(int firstXCoordinance) {
        this.firstXCoordinance = firstXCoordinance;
    }

    public int getFirstYCoordinance() {
        return firstYCoordinance;
    }

    public void setFirstYCoordinance(int firstYCoordinance) {
        this.firstYCoordinance = firstYCoordinance;
    }

    public int getSecondXCoordinance() {
        return secondXCoordinance;
    }

    public void setSecondXCoordinance(int secondXCoordinance) {
        this.secondXCoordinance = secondXCoordinance;
    }

    public int getSecondYCoordinance() {
        return secondYCoordinance;
    }

    public void setSecondYCoordinance(int secondYCoordinance) {
        this.secondYCoordinance = secondYCoordinance;
    }

    public int getThirdXCoordinance() {
        return thirdXCoordinance;
    }

    public void setThirdXCoordinance(int thirdXCoordinance) {
        this.thirdXCoordinance = thirdXCoordinance;
    }

    public int getThirdYCoordinance() {
        return thirdYCoordinance;
    }

    public void setThirdYCoordinance(int thirdYCoordinance) {
        this.thirdYCoordinance = thirdYCoordinance;
    }

    public double[] getD(Map nests, Chromosome chromo) {
        double d[] = new double[3];
        ArrayList<Nest> nest = nests.getArrayMap();
        for (Nest n : nest) {
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        d[i] = (Math.sqrt(Math.pow(this.firstXCoordinance - n.getXCoordinance(), 2)
                                + Math.pow(this.firstYCoordinance - n.getYCoordinance(), 2)));
                        break;

                    case 1:
                        d[i] = (Math.sqrt(Math.pow(this.secondXCoordinance - n.getXCoordinance(), 2)
                                + Math.pow(this.secondYCoordinance - n.getYCoordinance(), 2)));
                        break;

                    case 2:
                        d[i] = (Math.sqrt(Math.pow(this.thirdXCoordinance - n.getXCoordinance(), 2)
                                + Math.pow(this.thirdYCoordinance - n.getYCoordinance(), 2)));
                        break;

                }
            }
        }

        return d;
    }

    @Override
    public String toString() {
        return firstXCoordinance + ",\t" + firstYCoordinance + ",\t" + secondXCoordinance
                + ",\t" + secondYCoordinance + ",\t" + thirdXCoordinance + ",\t" + thirdYCoordinance;
    }

}
