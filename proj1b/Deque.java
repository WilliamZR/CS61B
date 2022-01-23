public interface Deque<GivenType> {
    void addFirst(GivenType item);

    void addLast(GivenType item);

    boolean isEmpty();

    int size();

    GivenType removeFirst();

    GivenType removeLast();

    GivenType get(int index);
}
