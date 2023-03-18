public class Runners {
    private String name;
    private Integer bestRunningTime;

    public Runners(String name, Integer bestRunningTime) {
        this.name = name;
        this.bestRunningTime = bestRunningTime;
    }

    public String getName() {
        return name;
    }

    public Integer getBestRunningTime() {
        return bestRunningTime;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", bestRunningTime: " + bestRunningTime;
    }
}
