public class Bins {
    private int min;
    private int max;
    private int[] bins;

    public Bins(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range");
        }
        this.min = min;
        this.max = max;
        bins = new int[max - min + 1];
    }

    public void incrementBin(int value) {
        if (value < min || value > max) {
            throw new IllegalArgumentException("Out of range");
        }
        bins[value - min]++;
    }

    public int getBin(int value) {
        if (value < min || value > max) {
            throw new IllegalArgumentException("Out of range");
        }
        return bins[value - min];
    }

    public int getTotal() {
        int total = 0;
        for (int count : bins) {
            total += count;
        }
        return total;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}