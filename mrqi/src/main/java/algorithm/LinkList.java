package algorithm;

/**
 * 单向链表
 */
public class LinkList {

    public Link frist;// 定义一个头节点
    public Link last;//尾指针永远指向头节点
    public int size = 0;// 节点的位置


    public LinkList(){
        this.frist = null;//
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isis() {
        return size == 0;
    }

    /**
     * 头插法
     */
    public void addfrist( int data){
        Link link = new Link(data);
        link.next =frist;
        frist = link;
        size++;
    }

    /**
     * 尾插法
     */
    public void addlast(int data){

        if(frist == null){
            frist =  new Link(data);
            last = frist;
        }else{
            Link newL =   new Link(data);
            last.next = newL;
            last  = newL;
        }

        size++;
    }


    /**
     * 从头删除 返回当前链表位置
     */
    public Link removefrist(){
       Link d = frist;
       frist =d.next;
       size --;
       return d;
    }


    /**
     * 删除最后一个
     */

    public void dellast(){
        size --;
    }



    /**
     * 获取链表长度
     */

    public void displayAllLink(){
        Link cure = frist;

        while (cure !=null){
            cure.display();
            cure =cure.next;
        }
        System.out.println("长度"+size);
    }


    /**
     * 获取指定位置的节点元素
     *
     * @param index
     * @return
     */

    public Link getData(int index){

        if (index < 0 && index > size - 1) {
            throw new IndexOutOfBoundsException("越界");
        }

        Link count = frist;
        for (int i = 0; i < size && count != null; i++, count = count.next) {
            if (i == index) {
                return count;
            }
        }
        return null;

    }




    /**
     * 按值查找指定位置
     *
     * @param element
     * @return
     */
    public int selectIndex(int element) {
        Link current = frist;
        for (int i = 0; i < size && current != null; i++, current = current.next) {
            if (current.data == element) {
                return i;
            }
        }
        return -1;
    }





}
