package electrics.industries;

import java.util.ArrayList;

public class GearChain extends ArrayList<Gear> {

    private static final NeutralGear NEUTRAL_GEAR = new NeutralGear();

    public GearChain(int gearCount) {
        super(gearCount + 1);
        add(NEUTRAL_GEAR);
    }

    private static class NeutralGear extends Gear {
        public NeutralGear() {
            super(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public GearMove processGearMove(int enginePower) {
            return GearMove.UP;
        }
    }
}
