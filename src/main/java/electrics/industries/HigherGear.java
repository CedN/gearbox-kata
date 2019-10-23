package electrics.industries;

public class HigherGear extends Gear {

    static final int NO_UPPER_SHIFT_POINT = Integer.MAX_VALUE;

    public HigherGear() {
        this(Gear.DEFAULT_LOWER_SHIFT_POINT);
    }

    public HigherGear(int lowerShiftPoint) {
        super(lowerShiftPoint, NO_UPPER_SHIFT_POINT);
    }
}
