import java.util.ArrayList;

public class Pant {
    private double pantA = 1.00;
    private double pantB = 1.50;
    private double pantC = 3.00;
    private double noPant = 0.00;

    ArrayList<Pant> listOfPantA = new ArrayList<>();
    ArrayList<Pant> listOfPantB = new ArrayList<>();
    ArrayList<Pant> listOfPantC = new ArrayList<>();
    ArrayList<Pant> listOfNoPant =  new ArrayList<>();

    public double getPantA() {
        return pantA;
    }

    public double getPantB() {
        return pantB;
    }

    public double getPantC() {
        return pantC;
    }

    public double getNoPant() {
        return noPant;
    }
}
