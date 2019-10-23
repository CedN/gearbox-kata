package electrics.industries;

public class Gear {

    static final int DEFAULT_LOWER_SHIFT_POINT = 500;
    static final int DEFAULT_UPPER_SHIFT_POINT = 2000;

    private final int upperShiftPoint;
    private final int lowerShiftPoint;

    public Gear() {
        this(DEFAULT_LOWER_SHIFT_POINT, DEFAULT_UPPER_SHIFT_POINT);
    }

    public Gear(int lowerShiftPoint, int upperShiftPoint) {
        this.lowerShiftPoint = lowerShiftPoint;
        this.upperShiftPoint = upperShiftPoint;
    }

    public GearMove processGearMove(int enginePower) {
        if (enginePower > upperShiftPoint) {
            return GearMove.UP;
        }
        if (enginePower < lowerShiftPoint) {
            return GearMove.DOWN;
        }
        return GearMove.NO;
    }
}
