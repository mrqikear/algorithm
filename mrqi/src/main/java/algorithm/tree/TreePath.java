package algorithm.tree;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TreePath {

    @Test
    public void Test(){

        Tree t=new Tree();
        t.insert(80);
        t.insert(70);
        t.insert(100);
        t.insert(90);
        t.insert(1);
        // t.insert(1);
        t.insert(3);
        t.insert(2);
        List<String> paths = binaryTreePaths(t.root);
        System.out.println(paths);

    }



    public List<String> binaryTreePaths(Node root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        iterator(root,list,"");
        return list;
    }

    private void iterator(Node root, List<String> list, String s) {
        s = s+"->" + root.data+"";
        if(root.leftNode == null && root.rightNode ==null){
            s = s.substring(2);
            list.add(s);
        }
        if(root.leftNode != null){
            iterator(root.leftNode,list,s);
        }
        if(root.rightNode != null){
            iterator(root.rightNode,list,s);
        }
    }


}




