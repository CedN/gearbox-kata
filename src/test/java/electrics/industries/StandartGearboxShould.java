package electrics.industries;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandartGearboxShould {

    private static final int ENGINE_POWER_ABOVE_2000 = 2001;
    private static final int ENGINE_POWER_BELOW_500 = 499;

    private Gearbox gearbox;

    @BeforeEach
    public void setUp() {
        gearbox = new Gearbox();
    }

    @Nested
    @DisplayName("Gearbox in standard gear")
    public class GearboxInStandardSpeed {

        @BeforeEach
        public void setGearBoxIn3thGear() {
            setEnginePowerAbove2000(3);
        }
        
        @Test
        public void up_speed_at_4_when_set_engine_power_above_2000() {
            setEnginePowerAbove2000();
            assertEquals(4, gearbox.getSpeed());
        }

        @Test
        public void down_speed_to_2_when_set_engine_power_below_500() {
            setEnginePowerBelow500();
            assertEquals(2, gearbox.getSpeed());
        }

        @Test
        public void keep_speed_to_3_when_set_engine_power_at_1000() {
            gearbox.processEnginePower(1000);
            assertEquals(3, gearbox.getSpeed());
        }
    }
    
    @Nested
    @DisplayName("Gearbox in neutral")
    public class GearboxInNeutral {

        @Test
        public void up_speed_to_1_when_start_with_engine_power_below_500() {
            setEnginePowerBelow500();
            assertEquals(1, gearbox.getSpeed());
        }

        @Test
        public void up_speed_to_1_when_start_with_engine_power_above_2000() {
            setEnginePowerAbove2000();
            assertEquals(1, gearbox.getSpeed());
        }

        @Test
        public void up_speed_to_1_when_start_with_engine_power_above_1000() {
            gearbox.processEnginePower(1000);
            assertEquals(1, gearbox.getSpeed());
        }
    }

    @Nested
    @DisplayName("Gearbox in lower gear ")
    public class GearboxInLowerSpeed {

        @BeforeEach
        public void setGearBoxInLowerGear() {
            setEnginePowerAbove2000();
        }

        @Test
        public void keep_speed_to_1_when_set_engine_power_below_500() {
            setEnginePowerBelow500();
            assertEquals(1, gearbox.getSpeed());
        }

    }

    @Nested
    @DisplayName("Gearbox in higher gear")
    public class GearboxInHigherSpeed {

        @BeforeEach
        public void setGearBoxInHigherGear() {
            setEnginePowerAbove2000(6);
        }

        @Test
        public void keep_speed_to_1_when_set_engine_power_below_500() {
            setEnginePowerAbove2000();
            assertEquals(6, gearbox.getSpeed());
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
