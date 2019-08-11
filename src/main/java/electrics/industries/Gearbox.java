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
        if (speed > NEUTRAL_SPEED) {
            calculateSpeed();
        }
        else {
            speed = LOWEST_SPEED;
        }
    }

    private void calculateSpeed() {
        if (enginePower > HIGHER_SHIFT_POINT) {
            increaseSpeed();
        } else if (enginePower < LOWER_SHIFT_POINT) {
            decreasedSpeed();
        }
    }

    private void decreasedSpeed() {
        if (speed > LOWEST_SPEED) {
            speed--;
        }
    }

    private void increaseSpeed() {
        if (speed < HIGHEST_SPEED) {
            speed++;
        }
    }

    public int getSpeed() {
        return speed;
    }
}