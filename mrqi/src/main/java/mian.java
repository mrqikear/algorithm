import algorithm.LinkList;
import algorithm.Sort;
import algorithm.tree.Node;
import algorithm.tree.Tree;

public class mian {

    public static void main(String args[]) {

        //Sort.ContSort();

        //链表
        /*
        LinkList g = new LinkList();
        g.addlast(13);
        g.addlast(16);
        g.addlast(-3);
        g.addlast(8);
        g.addlast(5);
        g.addlast(22);
        g.displayAllLink();

        */
        //二叉树
        Tree t=new Tree();
        t.insert(80);
        t.insert(70);
        t.insert(100);
        t.insert(90);
        t.insert(1);
       // t.insert(1);
        t.insert(3);
        t.insert(2);



        Node node = t.find(2);
         Node root = t.root;
        System.out.println(root.data);
        System.out.println(t.count());
        //t.PreOrder(root);
        t.preOrder1(root);

    }



}
