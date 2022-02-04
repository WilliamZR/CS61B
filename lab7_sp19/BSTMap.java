import java.util.*;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{
    private Node root;
    private List<K> key_list;
    private class Node{
        private Node left;
        private Node right;
        private K key;
        private V value;
        private int size;

        public Node(K key,V value,int size){
            this.key=key;
            this.value=value;
            this.size=size;
        }
    }

    public class KeyIterator implements Iterator<K> {
        public boolean hasNext(){
            return false;
        }
        public K next(){
            return null;
        }
    }

    public BSTMap(){
        key_list=new ArrayList<K>();
    }

    @Override
    public Iterator<K> iterator() {
        return key_list.iterator();
    }
    public void clear(){
        root=null;
    }

    private boolean containsKey(K key,Node x){
        if(x==null)
            return false;
        int cmp=key.compareTo(x.key);
        if (cmp<0)
            return containsKey(key,x.left);
        else if (cmp>0)
            return containsKey(key,x.right);
        else
            return true;
    }
    public boolean containsKey(K key){
        return containsKey(key,root);
    }

    private V get(K key,Node x){
        if (x==null) return null;
        int cmp=key.compareTo(x.key);
        if (cmp<0)
            return get(key,x.left);
        else if (cmp>0)
            return get(key,x.right);
        else
            return x.value;
    }
    public V get(K key){
        if (key==null)
            throw new IllegalArgumentException("get() is called with a null key");
        return get(key,root);
    }


    public Set<K> keySet(){
        Set<K> key_set=new HashSet<>(key_list);
        return key_set;
    }

    private int size(Node x){
        if (x==null){
            return 0;
        }
        return x.size;
    }

    public int size(){
        return size(root);
    }

    private Node put(K key,V value,Node x){
        if (x==null){
            return new Node(key,value,1);
        }
        int cmp=key.compareTo(x.key);
        if (cmp<0){
            x.left=put(key,value,x.left);
        }else if (cmp>0){
            x.right=put(key,value,x.right);
        }else{
            x.value=value;
        }
        x.size=1+size(x.left)+size(x.right);
        return x;
    }

    public void put(K key,V value){
        root=put(key,value,root);
        key_list.add(key);
    }

    private Node min_node(Node x){
        if (x.left!=null)
            return min_node(x.left);
        else
            return x;
    }

    private Node delete_min(Node x){
        if (x.left!=null){
            x.left=delete_min(x.left);
        }else{
            return x.right;
        }
        x.size=1+size(x.left)+size(x.right);
        return x;
    }

    private Node delete(K key,Node x){
        if (x==null)
            return null;
        int cmp=key.compareTo(x.key);
        if (cmp<0){
            x.left= delete(key,x.left);
        }else if (cmp>0){
            x.right= delete(key,x.right);
        }else{
            if (x.right==null)
                return x.left;
            if (x.left==null)
                return x.right;
            Node t=x;
            x=min_node(t.right);
            x.right=delete_min(t.right);
            x.left=t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public V remove(K key){
        V temp= get(key);
        root=delete(key,root);
        key_list.remove(key);
        return temp;
    }

    public V remove(K key,V value){
        V temp=get(key);
        if (temp==value)
            root=delete(key,root);
            key_list.remove(key);
        return value;
    }
}
