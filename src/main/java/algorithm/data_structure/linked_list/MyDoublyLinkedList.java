package algorithm.data_structure.linked_list;

/**
 * 双链表
 * */
public class MyDoublyLinkedList {
    /**
     * 链表大小(不包括头尾节点)
     * */
    int size;
    /**
     * 链表头节点
     * */
    DoublyLinkedListNode head;
    /**
     * 链表尾节点
     * */
    DoublyLinkedListNode tail;

    /**
     * 初始化链表方法
     * */
    public MyDoublyLinkedList(){
        // 头尾节点不算链表长度
        size = 0;

        // 头尾节点赋默认值0
        head = new DoublyLinkedListNode(0);
        tail = new DoublyLinkedListNode(0);

        // 头尾节点互相关联
        head.next = tail;
        tail.prev = head;
    }

    /**
     * index=0,1,...,size-1,size时
     * 表示在index处添加值为val的节点
     * 如果存在>index的节点 则依次后延
     *
     * index<0视为0 index>size不做任何操作
     * */
    public void addAtIndex(int index, int val) {
        // index>size不做任何操作
        if(index > size) return;
        // index<0视为0
        if(index < 0) index = 0;
        // 以下 index=0,1...,size-1,size

        // 因为必定插入所以size+1
        size = size + 1;

        // 遍历找到增加操作的前节点
        DoublyLinkedListNode pre = this.head;
        for(int i = 0; i<index; i++){
            pre = pre.next;
        }

        // 定义新Node
        DoublyLinkedListNode addNode = new DoublyLinkedListNode(val);
        // 前节点 <-> 新Node <-> 前节点之后
        // 特殊情况: 前节点<->尾节点 则新Node<->尾节点 赋值过程并不需要特殊处理
        addNode.next = pre.next;
        addNode.prev = pre;
        // 前节点之后 向前关联 addNode
        pre.next.prev = addNode;
        pre.next = addNode;
    }
    /**
     * 插入头节点
     * 相当于index=0处插入
     * */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }
    /**
     * 插入尾节点
     * 相当于index=size处插入
     * */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /**
     * index=0,1,...,size-1时
     * 删除index处节点
     * 其余情况不做任何处理
     * */
    public void deleteAtIndex(int index){
        // 其余情况不做任何处理
        if(index < 0 || index >= size) return;

        // 因为必定删除所以size-1
        size--;

        // 遍历找到删除操作的前节点
        DoublyLinkedListNode pre = this.head;
        for(int i = 0; i<index; i++){
            pre = pre.next;
        }

        // 特殊情况: 删除节点<->尾节点 则前节点<->null 赋值过程并不需要特殊处理
        pre.next = pre.next.next;
        pre.next.prev = pre;
    }
}
