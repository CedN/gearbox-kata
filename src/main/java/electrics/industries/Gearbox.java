package electrics.industries;

public class Gearbox {

    private int speed = 0;
    private int enginePower = 0;

    public void processEnginePower(int enginePower) {
        if (speed > 0) {
            if (enginePower > 2000) {
                speed++;
            } else if (enginePower < 500) {
                speed--;
            }
        }
        if (speed > 6) {
            speed--;
        } else if (speed < 1) {
            speed++;
        }
        this.enginePower = enginePower;
    }

    public int getSpeed() {
        return speed;
    }
}