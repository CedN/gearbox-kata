package electrics.industries;

public class Gearbox {

    private static final int HIGHER_SHIFT_POINT = 2000;
    private static final int LOWER_SHIFT_POINT = 500;
    private static final int NO_SPEED = 0;
    private static final int HIGHEST_SPEED = 6;
    private static final int LOWEST_SPEED = 1;

    private int speed = NO_SPEED;

    public void processEnginePower(int enginePower) {
        if (speed > NO_SPEED) {
            calculateSpeed(enginePower);
        }
        else {
            speed = LOWEST_SPEED;
        }
    }

    private void calculateSpeed(int enginePower) {
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