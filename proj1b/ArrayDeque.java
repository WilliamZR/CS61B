public class ArrayDeque<GivenType> implements Deque<GivenType> {
    public int size=0;
    public GivenType[] items;
    public int pointer=0;
    public int capacity=8;

    private void resize_more(int resized){
        GivenType[] Alist=(GivenType[]) new Object[resized];
        System.arraycopy(items,pointer,Alist,0, items.length-pointer);
        System.arraycopy(items,0,Alist,items.length-pointer,pointer);
        items=Alist;
        capacity=resized;
        pointer=0;
    }

    private void resize_less(int resized){
        GivenType[] Alist=(GivenType[]) new Object[resized];
        System.arraycopy(items,pointer,Alist,0,size+1);
        items=Alist;
        capacity=resized;
        pointer=0;
    }


    private void auto_resize(int code){
        if (size==capacity&code==1){
            resize_more (capacity*2);
        }else if (size*4<capacity&code==0&size>0) {
            resize_less ((int) (capacity * 0.25));
        }
    }

    public ArrayDeque(){
        items=(GivenType[]) new Object[capacity];
    }

    private int rearrange (int temp){
        if (temp>items.length){
            return temp-size-1;
        }else if (temp<0){
            return temp+size+1;
        }else{
            return temp;
        }
    }
    private int index(int i){
        int temp= i+pointer;
        return rearrange(temp);
    }

    @Override
    public void addLast(GivenType item){
        size+=1;
        auto_resize(1);
        items[index(size)]=item;
    }

    @Override
    public GivenType removeLast (){
        GivenType temp=items[index(size)];
        items[index(size)]=null;
        size-=1;
        auto_resize(0);
        return temp;
    }
    @Override
    public void addFirst (GivenType item){
        size+=1;
        auto_resize(1);
        items[index(1)]=item;
        pointer+=rearrange(1);
    }

    @Override
    public GivenType removeFirst(){
        GivenType temp=items[index(1)];
        items[index(1)]=null;
        pointer+=rearrange(1);
        size-=1;
        auto_resize(0);
        return temp;
    }

    @Override
    public GivenType get(int index){
        return items[index(index)];
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }
}
