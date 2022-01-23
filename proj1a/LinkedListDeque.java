public class LinkedListDeque<GivenType> {
    public int size=0;
    public StuffNode first;
    /**creates a stuff node to store the item and pointers */
    public class StuffNode{
        public GivenType item;
        public StuffNode next;
        public StuffNode last;

        public StuffNode(GivenType i,StuffNode n,StuffNode l){
            item=i;
            next=n;
            last=l;
        }
    }

    public LinkedListDeque(){
        StuffNode station=new StuffNode(null,null,null);
        station.next=station;
        station.last=station;
        first=station;
    }

    public LinkedListDeque(GivenType x){
        StuffNode station=new StuffNode(null,null,null);
        station.next=new StuffNode(x,station,station);
        station.last=station.next;
        size+=1;
    }

    public boolean isEmpty(){
        return first.next == first;
    }

    public void addFirst(GivenType item){
        StuffNode temp=new StuffNode(item,first.next,first);
        first.next.last=temp;
        first.next=temp;
        size+=1;
    }

    public void addLast(GivenType item){
        StuffNode temp=new StuffNode(item,first,first.last);
        first.last.next=temp;
        first.last=temp;
        size+=1;
    }

    public int size(){
        return size;
    }

    public GivenType removeFirst(){
        GivenType removed =first.next.item;
        first.next.next.last=first;
        first.next=first.next.next;
        return removed;
    }

    public GivenType removeLast(){
        GivenType removed =first.last.item;
        first.last.last.next=first;
        first.last=first.last.last;
        return removed;
    }

    private GivenType get(StuffNode node,int index){
        if (index==0){
            return node.next.item;
        }else{
            return get(node.next,index-1);
        }
    }

    public GivenType get(int index){
        if (index>=size){
            return null;
        }else{
            return get(first,index);
        }

    }
    private void print_node_item(StuffNode node,int index){
        if (index>0){
            System.out.print(node.item);
            print_node_item(node.next,index-1);
        }
    }

    public void printDeque(){
        print_node_item(first,size);
    }

}