
public class Main {

	public static void main(String[] args) {
//		Solution solution=new Solution();
//		ListNode head=new ListNode(1);
//		ListNode node1=new ListNode(2);
//		ListNode node2=new ListNode(3);
//		ListNode node3=new ListNode(4);
//		solution.deleteDuplicates(head);
//		solution.mergeTwoLists(head, head);
		
		System.out.println("dp:");
		DP dp=new DP();
		int[] nums={4,2,5,6,2,1,1};
		System.out.println("rob:"+dp.rob(nums));
		System.out.println("maxSubArray:"+dp.maxSubArray(nums));
		int[] nums1={7,1,5,3,6,4};
		int[] nums2={7,6,4,3,1};
		System.out.println("maxProfit:"+dp.maxProfit(nums1));
		System.out.println("maxProfit:"+dp.maxProfit(nums2));
		System.out.println("maxProfit_2:"+dp.maxProfit_2(nums1));
		System.out.println("maxProfit_2:"+dp.maxProfit_2(nums2));
		System.out.println("climbStairs:"+dp.climbStairs(4));
		DP obj=new DP(nums2);
		System.out.println("sumRange:"+dp.sumRange(0,2));
		int[] nums3={1,2,3};
		System.out.println("combinationSum4:"+dp.combinationSum4(nums3,4));
		int[] nums4={1,2,3,0,2,8};
		
		System.out.println("maxProfit1:"+dp.maxProfit1(nums4));
		System.out.println("maxProfit2:"+dp.maxProfit2(nums4));
		int[] nums5={23, 2, 6, 4, 7};
		System.out.println("checkSubarraySum:"+dp.checkSubarraySum(nums5,6));
		System.out.println("checkSubarraySum_2:"+dp.checkSubarraySum_2(nums5,6));
		System.out.println("numDecodings:"+dp.numDecodings("10"));
	}

}
