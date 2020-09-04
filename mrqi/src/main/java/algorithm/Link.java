package algorithm;


/**
 * 链表节点
 */
public class Link {
    public int data;// 存放数据
    public Link next;// 存放下一个节点

    public Link(int data) {
        this.data = data;
    }

    public Link(int data, Link next) {
        this.data = data;
        this.next = next;
    }

    public Link() {
    }

    public void display() {
        System.out.println(data + " ");
    }
}