package electrics.industries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassicGearboxShould {

    private static final int ENGINE_POWER_ABOVE_2000 = 2001;
    private static final int ENGINE_POWER_BELOW_500 = 499;

    private Gearbox gearbox;

    @BeforeEach
    void setUp() {
        gearbox = new Gearbox();
    }

    @Nested
    @DisplayName("Gearbox in standard gear")
    class GearboxInStandardSpeed {

        @BeforeEach
        void setGearBoxIn3thGear() {
            setEnginePowerAbove2000(3);
        }
        
        @Test
        void up_speed_at_4_when_set_engine_power_above_2000() {
            setEnginePowerAbove2000();
            assertSpeedIs(4);

        }

        @Test
        void down_speed_to_2_when_set_engine_power_below_500() {
            setEnginePowerBelow500();
            assertSpeedIs(2);
        }

        @Test
        void keep_speed_to_3_when_set_engine_power_at_1000() {
            gearbox.processEnginePower(1000);
            assertSpeedIs(3);
        }
    }

    private void assertSpeedIs(int speed) {
        assertEquals(speed, gearbox.getSpeed());
    }
    
    @Nested
    @DisplayName("Gearbox in neutral")
    class GearboxInNeutral {

        @Test
        void up_speed_to_1_when_start_with_engine_power_below_500() {
            setEnginePowerBelow500();
            assertSpeedIs(1);
        }

        @Test
        void up_speed_to_1_when_start_with_engine_power_above_2000() {
            setEnginePowerAbove2000();
            assertSpeedIs(1);
        }

        @Test
        void up_speed_to_1_when_start_with_engine_power_above_1000() {
            gearbox.processEnginePower(1000);
            assertSpeedIs(1);
        }
    }

    @Nested
    @DisplayName("Gearbox in lower gear ")
    class GearboxInLowerSpeed {

        @BeforeEach
        void setGearBoxInLowerGear() {
            setEnginePowerAbove2000();
        }

        @Test
        void keep_speed_to_1_when_set_engine_power_below_500() {
            setEnginePowerBelow500();
            assertSpeedIs(1);
        }

        @Test
        void up_speed_to_2_when_set_engine_power_above_2000() {
            setEnginePowerAbove2000();
            assertSpeedIs(2);
        }
    }

    @Nested
    @DisplayName("Gearbox in higher gear")
    class GearboxInHigherSpeed {

        @BeforeEach
        void setGearBoxInHigherGear() {
            setEnginePowerAbove2000(6);
        }

        @Test
        void down_speed_to_5_when_set_engine_power_below_500() {
            setEnginePowerBelow500();
            assertSpeedIs(5);
        }

        @Test
        void keep_speed_to_6_when_set_engine_power_above_2000() {
            setEnginePowerAbove2000();
            assertSpeedIs(6);
        }
    }

    private void setEnginePowerAbove2000() {
        gearbox.processEnginePower(ENGINE_POWER_ABOVE_2000);
    }

    private void setEnginePowerBelow500() {
        gearbox.processEnginePower(ENGINE_POWER_BELOW_500);
    }

    private void setEnginePowerAbove2000(int times) {
        for (int i = 0; i < times; i++)
            setEnginePowerAbove2000();
    }
}
