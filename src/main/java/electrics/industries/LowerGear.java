package electrics.industries;

public class LowerGear extends Gear {

    static final int NO_LOWER_SHIFT_POINT = Integer.MIN_VALUE;

    public LowerGear() {
        this(Gear.DEFAULT_UPPER_SHIFT_POINT);
    }

    public LowerGear(int upperShiftPoint) {
        super(NO_LOWER_SHIFT_POINT, upperShiftPoint);
    }
}
