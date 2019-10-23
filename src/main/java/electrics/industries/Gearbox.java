package electrics.industries;

import java.util.Arrays;

public class Gearbox {

    private static final int NEUTRAL_GEARBOX_POSITION = 0;

    private final GearChain gearsChain;
    private int gearboxPosition = NEUTRAL_GEARBOX_POSITION;

    public Gearbox() {
        this(
                new LowerGear(),
                new Gear(),
                new Gear(),
                new Gear(),
                new Gear(),
                new HigherGear()
        );
    }

    public Gearbox(Gear... gears) {
        gearsChain = new GearChain(gears.length);
        gearsChain.addAll(Arrays.asList(gears));
    }

    public void processEnginePower(int enginePower) {
        Gear currentSpeed = gearsChain.get(gearboxPosition);
        GearMove gearMove = currentSpeed.processGearMove(enginePower);
        gearboxPosition = gearMove.apply(gearboxPosition);
    }

    public int getSpeed() {
        return gearboxPosition;
    }
}