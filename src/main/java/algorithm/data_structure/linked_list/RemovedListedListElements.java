package algorithm.data_structure.linked_list;

/**
 * Leetcode 203 移除链表元素
 * 单链表的头节点head 与 值val>=0
 * 将单链表中所有值为val的节点删除后
 * 返回新的头节点newHead
 * */
public class RemovedListedListElements {
    /**
     * 单链表节点内部类
     * */
    public class ListNode {
       /**
        * 节点值
        * */
       int val;
       /**
        * 下一节点
        * */
       ListNode next;
       /**
        * 节点值与下一节点的构造方法
        * */
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    /**
     * 直接做 考虑情况多
     * */
    public ListNode removeElementsDefault(ListNode head, int val) {
         // 考虑头节点自删的情况
         // 直到head==null 或 head.val!=val为止
         while(head != null && head.val == val)
             head = head.next;

         // 因为需要返回head 所以之后的删除需要新变量
         ListNode curr = head;

         // 每次循环都保证 curr!=null 且 curr.next!=null
         while(curr != null && curr.next != null){
            // 若此时有curr.next.val=val 则删除curr.next
            if(curr.next.val == val)
                curr.next = curr.next.next;
            // 若没有 则快进到下一节点
            else curr = curr.next;
         }

         // 返回新的头节点
         return head;
    }

    /**
     * 虚拟头节点 写起来简单
     *
     * 直接写的时候 头节点的删除 和 当前节点的删除 的内容实质是一样的
     * 只是因为我们没有头节点的前一节点 所以用了两者不同方法写
     * 但其实我们可以构造一个虚拟头节点当头节点的前一节点
     * */
    public ListNode removeElementsVirtualHead(ListNode head, int val) {
        // 虚拟头节点指向头节点 因为val>=0 所以虚拟头节点的值!=val
        ListNode virtualHead = new ListNode(-1, head);

        // 这样我们就跳过了头节点的删除 直接快进到当前节点的删除
        ListNode curr = virtualHead;

        // 同上 注意此时while条件可以去掉curr!=null
        while(curr.next != null){
            if(curr.next.val == val)
                curr.next = curr.next.next;
            else curr = curr.next;
        }

        // 新的头节点就是虚拟头节点的下一节点
        return virtualHead.next;
    }
}
