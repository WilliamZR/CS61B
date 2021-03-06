// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Arrays;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int len) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = -1;
        fillCount = 0;
        capacity=len;
        rb = (T[]) new Object[len];
    }

    private int index(int x) {
        if (x >= capacity) {
            return x - capacity;
        } else if (x < 0) {
            return x + capacity;
        } else {
            return x;
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (!isFull()) {

            last = index(last + 1);
            fillCount += 1;
            rb[last] = x;
        }

    }

    /**
     * Dequeue the oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (!isEmpty()) {
            T temp = rb[first];
            rb[first]=null;
            fillCount -= 1;
            first = index(first + 1);
            return temp;
        }
        return null;
    }


    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
        // TODO: When you get to part 5, implement the needed code to support iteration.
    }

    @Override
    public Iterator<T> iterator() {
        return new  KeyItertor();
    }

    public class KeyItertor implements Iterator<T>{
        public int p=first;
        public boolean hasNext(){
            return p==last+1;
        }

        public T next(){
            T temp=rb[p];
            p=index(p+1);
            return temp;
        }

    }
}