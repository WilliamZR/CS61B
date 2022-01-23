import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {


    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome(){
        OffByOne obo= new OffByOne();
        Boolean actual=palindrome.isPalindrome("yz",obo);
        assertTrue(actual);

        OffByN obn= new OffByN(5);
        Boolean actual2=palindrome.isPalindrome("af",obn);
        assertTrue(actual);

    }
}
