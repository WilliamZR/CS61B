public class OffByN implements CharacterComparator{
    public int key;
    public OffByN(int x){
        key = x;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int diff=x-y;
        if (diff==-key|diff==key){
            return true;
        }else{
            return false;
        }
    }

}
