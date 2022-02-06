import edu.princeton.cs.algs4.BST;

import java.util.ArrayList;
import java.util.List;

public class MyTrieSet implements TrieSet61B{
    private Node root;
    private class Node{
        public boolean key;
        public BST<Character,Node> link;
        public Node(){
            key=false;
            link=new BST<>();
        }

        public boolean isKey(){
            return this.key;
        }
        public BST<Character,Node> get_links(){
            return this.link;
        }

        public Node get_next_node(char c){
            return get_links().get(c);
        }

        public void add_links(char c){
            link.put(c,new Node());
        }
    }
    public MyTrieSet(){
        root=new Node();
    }
    /** Clears all items out of Trie */
    public void clear(){
        root=new Node();
    }

    /** Returns true if the Trie contains KEY, false otherwise */
    public boolean contains(String key){
        Node temp_node=root;
        for (int i = 0;i<key.length();i++){
            char c = key.charAt(i);
            if (!temp_node.link.contains(c))
                return false;
            temp_node=temp_node.get_next_node(c);
        }
        if (temp_node.isKey())
            return true;
        else
            return false;
    }

    /** Inserts string KEY into Trie */
    public void add(String key){
        if (key==null ||key.length()<1)
            return;
        Node temp_node=root;
        for (int i = 0;i<key.length();i++){
            char c = key.charAt(i);
            if (!temp_node.link.contains(c))
                temp_node.add_links(c);
            temp_node=temp_node.get_next_node(c);
        }
        temp_node.key=true;
    }

    private void collect(String s, List<String> key_collection, Node x){
        for (char c : x.link.keys()){
            if (x.get_next_node(c).isKey())
                key_collection.add(s+c);
            collect(s+c,key_collection,x.get_next_node(c));
        }

    }

    /** Returns a list of all words that start with PREFIX */
    public List<String> keysWithPrefix(String prefix){
        Node temp_node=root;
        List<String> key_collection= new ArrayList<>();
        for (int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            temp_node=temp_node.get_next_node(c);
        }
        for (char c :temp_node.link.keys()){
            collect(prefix,key_collection,temp_node);
        }
        return key_collection;
    }

    /** Returns the longest prefix of KEY that exists in the Trie
     * Not required for Lab 9. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public String longestPrefixOf(String key){
        String prefix="";
        Node temp_node=root;
        for (int i=0;i<key.length();i++){
            char c=key.charAt(i);
            if (root.link.contains(c))
                prefix+=c;
            else
                break;
        }
        return prefix;
    }

}
