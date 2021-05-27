package Classes;

public class Cash {
    private double cash = 0;

    public void setCash(double amount){
        cash += amount;
    }

    public double getCash(){
        return cash;
    }
}
