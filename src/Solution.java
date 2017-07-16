public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null)
    		return head;
    	ListNode p=head;
    	int tmp=p.val;
    	while(p.next!=null){
    		if(p.next.val==tmp){
    			p.next=p.next.next;
    		}else {
    			p=p.next;
				tmp=p.val;
			}
    	}
        return head;
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1==null)
    		return l2;
    	if(l2==null)
    		return l1;
    	ListNode p1=l1,p2=l2;
    	ListNode newList=new ListNode(-1);
    	ListNode newHead=newList;
    	while(p1!=null && p2!=null){
    		if(p1.val<=p2.val){
    			newList.next=p1;
    			newList=newList.next;
    			p1=p1.next;
    		}else if(p1.val>p2.val){
    			newList.next=p2;
    			newList=newList.next;
    			p2=p2.next;
    		}
    	}
    	while(p1!=null){
    		newList.next=p1;
    		newList=newList.next;
    		p1=p1.next;
    	}
    	while(p2!=null){
    		newList.next=p2;
    		newList=newList.next;
    		p2=p2.next;
    	}
        return newHead.next;
    }
}
