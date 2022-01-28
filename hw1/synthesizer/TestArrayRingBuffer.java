package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        //ArrayRingBuffer arb = new ArrayRingBuffer(10);
        ArrayRingBuffer<Integer> test=new ArrayRingBuffer<Integer>(3);
        test.enqueue(1);
        test.dequeue();
        test.enqueue(2);
        test.enqueue(3);

        test.enqueue(4);
        assertTrue(2==test.peek());
        assertFalse(test.isEmpty());

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
