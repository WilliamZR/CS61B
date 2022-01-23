public class Palindrome {

    public Deque<Character> wordToDeque(String word){
        char[] word_p=word.toCharArray();
        Deque<Character> result= new ArrayDeque<>();
        for (char c : word_p) {
            result.addLast(c);
        }
        return result;
    }

    public Boolean isPalindrome(String word){
        Deque<Character> word_deque=wordToDeque(word);
        while (word_deque.size()>1){
            Character a=word_deque.removeFirst();
            Character b=word_deque.removeLast();
            if (a!=b){
                return false;
            }
        }
        return true;
    }


    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> word_deque=wordToDeque(word);
        while (word_deque.size()>1){
            Character a=word_deque.removeFirst();
            Character b=word_deque.removeLast();
            if (!cc.equalChars(a,b)){
                return false;
            }
        }
        return true;
    }

}
