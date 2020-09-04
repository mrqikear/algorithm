package algorithm.tree;

import java.util.Stack;

public class Tree extends  AbstractTree {

    public Node root;

    public Node find(int data) {
        Node current =root;
        while (current != null) {
            if (current.data > data) {
                current = current.leftNode;
            } else if (current.data < data) {
                current = current.rightNode;
            } else {
                return current;
            }
        }
        return null;

    }

    /**
     * 二叉树插入数据
     * @param data
     * @return
     */
    public boolean insert(int data) {
        count++;
        //如果第一个节点为空 设置第一个节点
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return true;
        }

        Node current = root;
        Node parentNode = null;
        //深度优先
        while(current != null){
            parentNode =current;//向下寻找
            if(current.data > data){
                current =current.leftNode; //当前节点为左节点
                //左节点为空
                if(current ==null){
                    parentNode.leftNode = newNode;
                    return  true;
                }
            }else{
                current = current.rightNode;
                if(current ==null){
                    parentNode.rightNode = newNode;
                    return  true;
                }

            }
        }
        return false;
    }


    /**
     * 删除共三种情况
     * 1 该节点是叶子节点
     * 2 该节点有一个叶子节点
     * 3 该节点有两个叶子节点
     *
     * @param data
     */
    public boolean delete(int data) {

        Node current  = root;
        Node parentNode =root;
        //当前节点是否为左节点
        boolean isLeftNode = false;
        //深度遍历
        //定位data的位置
        while(current.data != data){
            parentNode = current; //向下寻找

            if(current.data > data){
                isLeftNode = true;
                current = current.leftNode;
            }else{
                isLeftNode = false;
                current = current.rightNode;
            }

            if(current ==null)  return  false;

        }
        //1.该节点为叶子节点
        if(current.leftNode == null && current.rightNode ==null){
            if(current ==root){
                root =null;
            }else if (isLeftNode){
                parentNode.leftNode =null;
            }else{
                parentNode.rightNode =null;
            }

            return  true;
        }

        //2.当前节点有一个节点
        if(current.leftNode == null && current.rightNode !=null){
            if(current == root){
                root = current.rightNode;
            }else if(isLeftNode){
                parentNode.leftNode = current.rightNode; //移动树对
            }else{
                parentNode.rightNode = current.rightNode;
            }
        }else if(current.leftNode != null && current.rightNode ==null){
            if(current == root){
                root = current.leftNode;
            }else if(isLeftNode){
                parentNode.leftNode = current.leftNode; //移动树对
            }else{
                parentNode.rightNode = current.leftNode;
            }
        }

        //3.当前树有二个节点
        if(current.leftNode != null && current.rightNode != null){
            //查询比删除节点大的最小节点（右边的左边最深处）
            Node successor = getSuccessor(current);
            if(root ==current){
                root = successor;
            }else if(isLeftNode){
                parentNode.leftNode =successor;
            }else{
                parentNode.rightNode = successor;
            }

        }
        return false;
    }


    /**
     * 获取要删除节点的后继节点
     *
     * @param delNode
     * @return
     */

    public Node getSuccessor(Node delNode){

         //先找右边-》右边最小的  左树枝最深的
        Node successorParent = delNode;
        Node sucessor =delNode;
        Node current =delNode.rightNode;
        while (current != null){  //深度遍历
            successorParent =sucessor;
            sucessor  =current;
            //向下寻访一级
            current =current.leftNode;
        }

        //不是删除节点的第一层
        if(sucessor !=delNode.rightNode){
            successorParent.leftNode =sucessor.rightNode;
            sucessor.rightNode = delNode.rightNode;
        }

        return sucessor;
    }


    /**
     * 遍历二叉树
     */


    //前序遍历(递归)
    public void PreOrder(Node node){

        if(node !=null){
            System.out.println(node.data);//根结点
            PreOrder(node.leftNode);//先根遍历左子树
            PreOrder(node.rightNode);//先根遍历右子树
        }

    }



    //前序遍历(非递归)
    public void preOrder1(Node node){
        Stack<Node> stack = new Stack<Node>();

        while (node !=null || !stack.isEmpty()){
            //前序
            while (node !=null){
                //压栈
                System.out.println(node.data);
                stack.push(node);
                node = node.leftNode;
            }

            if(!stack.empty()){
                node = stack.pop();
                node =node.rightNode;
            }

        }

    }






}
