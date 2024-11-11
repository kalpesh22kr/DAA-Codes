//Write a program to implement Huffman Encoding using a greedy strategy

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class huffman {
    public static HashMap<Character,Integer> count_freq(String str) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (Character s:str.toCharArray())
        {
            map.put(s, map.getOrDefault(s,0)+1);
        }
        return map;
    }
    private static void print_tree(Huffman_Node root,String s,HashMap<Character,String> binarymap) {
        if (root.left == null && root.right == null) {
            System.out.println(root.c + ":" + s);
            binarymap.put(root.c, s);
            return;
        }
        print_tree(root.left, s + "0",binarymap);
        print_tree(root.right, s + "1",binarymap);
    }

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str= sc.nextLine();

        HashMap<Character,Integer> map=count_freq(str);
        System.out.println("map "+map);

        PriorityQueue<Huffman_Node> q = new PriorityQueue<>
                (map.size(), new MyComparator());
        for (HashMap.Entry<Character,Integer> entry : map.entrySet()) {
            Huffman_Node hn = new Huffman_Node();
            hn.c = entry.getKey();
            hn.val = entry.getValue();
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        Huffman_Node root=null;
        while (q.size() >1){
            Huffman_Node x = q.peek();
            q.poll();
            Huffman_Node y = q.peek();
            q.poll();

            Huffman_Node f = new Huffman_Node();
            f.val = x.val + y.val;
            f.c = '-';
            f.left = x;
            f.right = y;

            root = f;
            q.add(f);
        }

        HashMap<Character,String> binarymap=new HashMap<>();
        System.out.println("Character code: ");
        print_tree(root,"",binarymap);

        StringBuilder ans= new StringBuilder();
        for (char s:str.toCharArray())
        {
            if(s==' ')
            {
                ans.append(binarymap.get(' '));
            }
            else {
                ans.append(binarymap.get(s));
            }
        }
        System.out.println("Huffman coded String: ");
        System.out.println(ans);
        sc.close();
    }
}
class Huffman_Node{
        int val;
        char c;

        Huffman_Node left;
        Huffman_Node right;
}

class MyComparator implements Comparator<Huffman_Node> {
    public int compare(Huffman_Node x, Huffman_Node y)
    {

        return x.val - y.val;
    }
}