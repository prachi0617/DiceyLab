import java.util.Random;

public class Dice {
    private int numberOfDice;
    private Random random;

    public Dice(int numberOfDice) {
        if (numberOfDice <= 0) {
            throw new IllegalArgumentException("Number of dice must be > 0");
        }
        this.numberOfDice = numberOfDice;
        this.random = new Random();
    }

    // Toss all dice and return sum
    public int tossAndSum() {
        int sum = 0;
        for (int i = 0; i < numberOfDice; i++) {
            sum += random.nextInt(6) + 1; // 1–6
        }
        return sum;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }
}