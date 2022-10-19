import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FanTest {

    private Fan fan;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        fan = new Fan();
    }

    @Test
    void testInit() {
        assertEquals(Direction.Forward, fan.getDirection());
        assertEquals(0, fan.getSpeed());
    }

    @Test
    void testSpeedUp() {
        assertEquals(Direction.Forward, fan.getDirection());
        fan.pull();
        assertEquals(1, fan.getSpeed());
    }

    @Test
    void testReverse() {
        fan.reverse();
        assertEquals(Direction.Backward, fan.getDirection());
        assertEquals(0, fan.getSpeed());
    }

    @Test
    void testReverseSpeedUp() {
        fan.reverse();
        fan.pull();
        assertEquals(Direction.Backward, fan.getDirection());
        assertEquals(1, fan.getSpeed());
    }

    @Test
    void testReverseTwice() {
        fan.reverse();
        fan.reverse();
        assertEquals(Direction.Forward, fan.getDirection());
        assertEquals(0, fan.getSpeed());
    }

    @Test
    void testSpeedUpReverseThenOFF() {
        fan.pull();
        fan.pull();
        fan.pull();
        fan.reverse();
        fan.pull();
        assertEquals(Direction.Forward, fan.getDirection());
        assertEquals(0, fan.getSpeed());
    }

    @Test
    void testString() {
        assertEquals("Current speed: OFF, Current Direction: Forward", fan.toString());

        fan.pull();
        fan.reverse();
        assertEquals("Current speed: 1, Current Direction: Backward", fan.toString());
    }
}