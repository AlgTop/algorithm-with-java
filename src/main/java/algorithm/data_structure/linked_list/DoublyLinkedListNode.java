package algorithm.data_structure.linked_list;

/**
 * 双链表节点
 * */
public class DoublyLinkedListNode {
    /**
     * 节点值
     * */
    int val;
    /**
     * 下一个节点
     * */
    DoublyLinkedListNode next;
    /**
     * 上一个节点
     * */
    DoublyLinkedListNode prev;

    /**
     * 指定节点值的构造方法
     * */
    public DoublyLinkedListNode(int val) {
        this.val = val;
    }
}
