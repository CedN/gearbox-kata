package electrics.industries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomGearboxShould {

    private static final int UPPER_SHIFT_POINT_FROM_LOW_TO_MEDIUM = 400;
    private static final int LOWER_SHIFT_POINT_FROM_MEDIUM_TO_LOW = 500;
    private static final int UPPER_SHIFT_POINT_FROM_MEDIUM_TO_HIGH = 5000;
    private static final int LOWER_SHIFT_POINT_FROM_HIGH_TO_MEDIUM = 600;
    private static final int LOW_SPEED = 1;
    private static final int MEDIUM_SPEED = 2;
    private static final int HIGH_SPEED = 3;

    private Gearbox gearbox;

    @BeforeEach
    void setUp() {
        gearbox = new Gearbox(
                new LowerGear(UPPER_SHIFT_POINT_FROM_LOW_TO_MEDIUM),
                new Gear(LOWER_SHIFT_POINT_FROM_MEDIUM_TO_LOW, UPPER_SHIFT_POINT_FROM_MEDIUM_TO_HIGH),
                new HigherGear(LOWER_SHIFT_POINT_FROM_HIGH_TO_MEDIUM)
        );
    }

    @Test
    void up_to_low_speed_when_start_engine_power() {
        startEnginePower();
        assertSpeedIs(LOW_SPEED);
    }

    private void startEnginePower() {
        gearbox.processEnginePower(1);
    }

    private void assertSpeedIs(int speed) {
        assertEquals(speed, gearbox.getSpeed());
    }

    @Nested
    @DisplayName("Gearbox at lower gear")
    class GearboxAtLowerGear {

        @BeforeEach
        void setAtLowerGear() {
            startEnginePower();
        }

        @Test
        void keep_at_low_speed_when_set_engine_power_to_400() {
            gearbox.processEnginePower(UPPER_SHIFT_POINT_FROM_LOW_TO_MEDIUM);
            assertSpeedIs(LOW_SPEED);
        }

        @Test
        void up_from_low_speed_to_medium_speed_when_set_engine_power_above_400() {
            moveUpToMediumGear();
            assertSpeedIs(MEDIUM_SPEED);
        }
    }

    private void moveUpToMediumGear() {
        gearbox.processEnginePower(UPPER_SHIFT_POINT_FROM_LOW_TO_MEDIUM + 1);
    }


    @Nested
    @DisplayName("Gearbox at medium gear")
    class GearboxAtMediumGear {

        @BeforeEach
        void setAtMediumGear() {
            startEnginePower();
            moveUpToMediumGear();
        }

        @Test
        void keep_at_medium_speed_when_set_engine_power_to_500() {
            gearbox.processEnginePower(LOWER_SHIFT_POINT_FROM_MEDIUM_TO_LOW );
            assertSpeedIs(MEDIUM_SPEED);
        }

        @Test
        void down_to_low_speed_when_set_engine_power_below_500() {
            gearbox.processEnginePower(LOWER_SHIFT_POINT_FROM_MEDIUM_TO_LOW - 1);
            assertSpeedIs(LOW_SPEED);
        }

        @Test
        void keep_at_medium_speed_when_set_engine_power_to_5000() {
            gearbox.processEnginePower(UPPER_SHIFT_POINT_FROM_MEDIUM_TO_HIGH);
            assertSpeedIs(MEDIUM_SPEED);
        }

        @Test
        void up_to_high_speed_when_set_engine_power_above_5000() {
            moveUpToHigherGear();
            assertSpeedIs(HIGH_SPEED);
        }
    }

    void moveUpToHigherGear() {
        gearbox.processEnginePower(UPPER_SHIFT_POINT_FROM_MEDIUM_TO_HIGH + 1);
    }

    @Nested
    @DisplayName("Gearbox at higher gear")
    class GearboxAtHigherGear {

        @BeforeEach
        void setAtHigherGear() {
            startEnginePower();
            moveUpToMediumGear();
            moveUpToHigherGear();
        }

        @Test
        void keep_at_high_speed_when_set_engine_power_to_600() {
            gearbox.processEnginePower(LOWER_SHIFT_POINT_FROM_HIGH_TO_MEDIUM);
            assertSpeedIs(HIGH_SPEED);
        }

        @Test
        void down_to_medium_speed_when_set_engine_below_600() {
            gearbox.processEnginePower(LOWER_SHIFT_POINT_FROM_HIGH_TO_MEDIUM - 1);
            assertSpeedIs(MEDIUM_SPEED);
        }
    }


}
