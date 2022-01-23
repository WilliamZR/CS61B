public class ArrayDeque<GivenType> {
    public int size=0;
    public GivenType[] items;
    public int pointer=0;
    public int capacity=8;

    private void resize(int resized){
        GivenType[] Alist=(GivenType[]) new Object[resized];
        System.arraycopy(items,pointer,Alist,0, items.length-pointer);
        System.arraycopy(items,0,Alist,items.length-pointer,pointer);
        items=Alist;
        capacity=resized;
        pointer=0;
    }


    private void auto_resize(){
        if (items.length==capacity){
            resize (capacity*2);
        }else if (items.length*4<capacity) {
            resize((int) (capacity * 0.25));
        }
    }

    public ArrayDeque(){
        items=(GivenType[]) new Object[capacity];
    }

    private int rearrange (int temp){
        if (temp>items.length){
            return temp-size;
        }else if (temp<0){
            return temp+size;
        }else{
            return temp;
        }
    }
    private int index(int i){
        int temp= i-pointer;
        return rearrange(temp);
    }


    public void addLast(GivenType item){
        size+=1;
        items[index(size)]=item;
    }

    public GivenType removeLast (){
        GivenType temp=items[index(size)];
        items[index(size)]=null;
        size-=1;
        return temp;
    }

    public void addFirst (GivenType item){
        size+=1;
        items[index(pointer-1)]=item;
        pointer=rearrange(pointer-1);
    }

    public GivenType removeFirst(){
        GivenType temp=items[index(pointer-1)];
        items[index(pointer-1)]=null;
        pointer=rearrange(pointer+1);
        size-=1;
        return temp;
    }

    public GivenType get(int index){
        return items[index];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
