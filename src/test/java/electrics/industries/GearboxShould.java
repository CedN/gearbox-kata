package electrics.industries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GearboxShould {

    public static final int ENGINE_POWER_TO_SHIFT_LOWER_SPEED = 499;
    public static final int ENGINE_POWER_TO_SHIFT_HIGHER_SPEED = 2001;
    private Gearbox gearbox;

    @BeforeEach
    public void setUp() {
        gearbox = new Gearbox();
    }

    // First engine power send to gearbox 
    
    @Test
    public void up_to_speed_1_when_starting_with_engine_power_below_500() {
        whenSetEnginePowerTo(ENGINE_POWER_TO_SHIFT_LOWER_SPEED);
        assertSpeedIsEqualsTo(1);
    }

    private void assertSpeedIsEqualsTo(int i) {
        assertEquals(i, gearbox.getSpeed());
    }

    private void whenSetEnginePowerTo(int enginePowerToShiftLowerSpeed) {
        gearbox.processEnginePower(enginePowerToShiftLowerSpeed);
    }

    @Test
    public void up_to_speed_1_when_starting_with_engine_power_above_2000() {
        whenSetEnginePowerTo(ENGINE_POWER_TO_SHIFT_HIGHER_SPEED);
        assertSpeedIsEqualsTo(1);
    }

    @Test
    public void up_to_speed_1_when_starting_with_engine_power_at_1000() {
        whenSetEnginePowerTo(1000);
        assertSpeedIsEqualsTo(1);
    }

    // Gearbox at speed 3 (standard speed)

    @Test
    public void down_speed_2_when_set_engine_power_below_500_and_gearbox_at_speed_3() {
        givenGearboxAtSpeed(3);
        whenSetEnginePowerTo(ENGINE_POWER_TO_SHIFT_LOWER_SPEED);
        assertSpeedIsEqualsTo(2);
    }

    private void givenGearboxAtSpeed(int speed) {
        for (int i = 0; i < speed; i++) {
            gearbox.processEnginePower(ENGINE_POWER_TO_SHIFT_HIGHER_SPEED);
        }
    }

    @Test
    public void keep_speed_3_when_set_engine_power_at_1000_and_gearbox_at_speed_3() {
        givenGearboxAtSpeed(3);
        whenSetEnginePowerTo(1000);
        assertSpeedIsEqualsTo(3);
    }

    @Test
    public void up_speed_4_when_set_engine_power_above_2000_and_gearbox_at_speed_3() {
        givenGearboxAtSpeed(3);
        whenSetEnginePowerTo(ENGINE_POWER_TO_SHIFT_HIGHER_SPEED);
        assertSpeedIsEqualsTo(4);
    }

    // Gearbox at speed 1 (lower speed)
    
    @Test
    public void keep_speed_1_when_set_engine_power_below_500_and_gearbox_at_speed_1() {
        givenGearboxAtSpeed(1);
        whenSetEnginePowerTo(ENGINE_POWER_TO_SHIFT_LOWER_SPEED);
        assertSpeedIsEqualsTo(1);
    }

    // Gearbox at speed 6 (higher speed)

    @Test
    public void keep_speed_6_when_set_engine_power_above_2000_and_gearbox_at_speed_6() {
        givenGearboxAtSpeed(6);
        whenSetEnginePowerTo(ENGINE_POWER_TO_SHIFT_HIGHER_SPEED);
        assertSpeedIsEqualsTo(6);
    }

}