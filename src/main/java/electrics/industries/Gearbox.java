package electrics.industries;

public class Gearbox {

    private static final int HIGHER_SHIFT_POINT = 2000;
    private static final int LOWER_SHIFT_POINT = 500;
    private static final int NEUTRAL_SPEED = 0;
    private static final int HIGHEST_SPEED = 6;
    private static final int LOWEST_SPEED = 1;

    private int speed = 0;
    private int enginePower = 0;

    public void processEnginePower(int enginePower) {
        this.enginePower = enginePower;
        calculateSpeed();
        fixCalculatedSpeed();
    }

    private void calculateSpeed() {
        if (speed > NEUTRAL_SPEED) {
            if (enginePower > HIGHER_SHIFT_POINT) {
                speed++;
            } else if (enginePower < LOWER_SHIFT_POINT) {
                speed--;
            }
        }
    }

    private void fixCalculatedSpeed() {
        if (speed > HIGHEST_SPEED) {
            speed--;
        } else if (speed < LOWEST_SPEED) {
            speed++;
        }
    }

    public int getSpeed() {
        return speed;
    }
}