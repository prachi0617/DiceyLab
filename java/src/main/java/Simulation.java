public class Simulation {

    private int numberOfDice;
    private int numberOfTosses;
    private Dice dice;
    private Bins results;

    public Simulation(int numberOfDice, int numberOfTosses) {
        this.numberOfDice = numberOfDice;
        this.numberOfTosses = numberOfTosses;

        int min = numberOfDice;
        int max = numberOfDice * 6;

        dice = new Dice(numberOfDice);
        results = new Bins(min, max);
    }

    public void runSimulation() {
        for (int i = 0; i < numberOfTosses; i++) {
            int sum = dice.tossAndSum();
            results.incrementBin(sum);
        }
    }

    public void printResults() {

        System.out.println("Simulation of " + numberOfDice + " dice tossed for " + numberOfTosses + " times.");

        int total = results.getTotal();

        for (int i = results.getMin(); i <= results.getMax(); i++) {
            int count = results.getBin(i);
            double percent = (double) count / total;

            int stars = (int) (percent * 100);
            String bar = "*".repeat(stars);

            System.out.printf("%2d : %8d: %.2f %s%n", i, count, percent, bar);
        }
    }

    public static void main(String[] args) {
        Simulation sim = new Simulation(2, 1_000_000);
        sim.runSimulation();
        sim.printResults();
    }
}