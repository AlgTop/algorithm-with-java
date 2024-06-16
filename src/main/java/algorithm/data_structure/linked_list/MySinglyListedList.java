package algorithm.data_structure.linked_list;

/**
 * 单链表
 * */
public class MySinglyListedList {
    /**
     * 链表大小(不包括头节点)
     * */
    int size;
    /**
     * 链表头节点
     * */
    SinglyLinkedListNode head;

    /**
     * 初始化链表方法
     * */
    public MySinglyListedList(){
        // 头节点不算链表长度
        size = 0;

        // 头节点赋默认值0
        head = new SinglyLinkedListNode(0);
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
        SinglyLinkedListNode pre = this.head;
        for(int i = 0; i<index; i++){
            pre = pre.next;
        }

        // 定义新Node
        SinglyLinkedListNode addNode = new SinglyLinkedListNode(val);
        // 前节点指向新Node 新Node指向前节点之后
        // 特殊情况: 前节点指向null 则新Node也指向null 赋值过程并不需要特殊处理
        addNode.next = pre.next;
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
        SinglyLinkedListNode pre = this.head;
        for(int i = 0; i<index; i++){
            pre = pre.next;
        }

        // 特殊情况: 删除节点指向null 则前节点也指向null 赋值过程并不需要特殊处理
        pre.next = pre.next.next;
    }
}
