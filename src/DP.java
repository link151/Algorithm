
public class DP {
	public DP(){
		
	}
    public int rob(int[] nums) {
    	int len=nums.length;
    	if(nums==null || nums.length==0)
    		return 0;
    	int[][] f=new int[len][2];
    	f[0][0]=0;
    	f[0][1]=nums[0];
    	for(int i=1;i<len;i++){
    		f[i][0]=Math.max(f[i-1][0], f[i-1][1]);
    		f[i][1]=f[i-1][0]+nums[i];
    	}
		return f[len-1][0]>=f[len-1][1]?f[len-1][0]:f[len-1][1];
    }
    
    public int maxSubArray(int[] nums) {
    	int len=nums.length;
    	if(nums==null || len==0)
    		return 0;
    	int[] dp=new int[len];
    	dp[0]=nums[0];
    	int max=nums[0];
    	for(int i=1;i<len;i++){
    		dp[i]=nums[i]+(dp[i-1]>0?dp[i-1]:0);
    		max=Math.max(dp[i], max);
    	}
		return max;
    }
    public int maxSubArray2(int[] nums) {
    	int len=nums.length;
    	if(nums==null || len==0)
    		return 0;
    	int maxSoFar=nums[0],maxEndingHere=nums[0];
    	for(int i=1;i<nums.length;i++){
    		maxEndingHere=Math.max(maxEndingHere+nums[i], nums[i]);
    		maxSoFar=Math.max(maxEndingHere, maxSoFar);
    	}
    	return maxSoFar;
    }
    
    public int maxProfit(int[] prices) {
    	if(prices.length==0)
    		return 0;
    	int[] dt=new int[prices.length];
    	dt[0]=0;
    	for(int i=1;i<prices.length;i++){
    		dt[i]=prices[i]-prices[i-1];
    	}
    	
    	int maxEndingHere=0,maxSoFar=0;
    	for(int i=1;i<dt.length;i++){
    		maxEndingHere=maxEndingHere>0?maxEndingHere+dt[i]:dt[i];
    		maxSoFar=Math.max(maxEndingHere, maxSoFar);
    	}
		return maxSoFar;
    }
    public int maxProfit_2(int[] prices) {
    	if(prices.length==0)
    		return 0;
    	int[] dt=new int[prices.length];
    	dt[0]=0;
    	for(int i=1;i<prices.length;i++){
    		dt[i]=prices[i]-prices[i-1];
    	}
    	
    	int[] maxCur=new int[prices.length];
    	maxCur[0]=0;
    	int max=dt[0];
    	for(int i=1;i<dt.length;i++){
    		maxCur[i]=dt[i]+(maxCur[i-1]>0?maxCur[i-1]:0);
    		max=Math.max(maxCur[i], max);
    	}
    	return max;
    }
    
    public int climbStairs(int n) {
    	int [] cnt=new int[n];
    	if(n>=1)
    	    cnt[0]=1;
    	if(n>=2)
    	    cnt[1]=2;
    	for(int i=2;i<n;i++){
    		cnt[i]=cnt[i-1]+cnt[i-2];
    	}
		return cnt[n-1];
    }
    
    static int[] sum;
    public DP(int[] nums) {
    	if(nums.length==0)
    		return;
    	sum=new int[nums.length];
    	sum[0]=nums[0];
    	for(int i=1;i<nums.length;i++){
    		sum[i]=sum[i-1]+nums[i];
    	}
    }
    
    public int sumRange(int i, int j) {
        if(i==0)
            return sum[j];
        return sum[j]-sum[i-1];
    }
    
    public int combinationSum4(int[] nums, int target) {
    	int[] dp=new int[target+1];
    	dp[0]=1;
    	for(int i=1;i<=target;i++){
    		for(int j=0;j<nums.length;j++){
    			if(i>=nums[j]){
    				dp[i]+=dp[i-nums[j]];
    			}
    		}
    	}
		return dp[target];
    }
    
    public int maxProfit1(int[] prices) {
    	if(prices==null || prices.length==0)
    		return 0;
    	int len=prices.length;
    	int[][] dp=new int[len][len];
    	for(int i=0;i<len-1;i++){
    		dp[i][i]=0;
    		dp[i][i+1]=prices[i+1]-prices[i]>0?prices[i+1]-prices[i]:0;
    	}
//    	printArr2(dp);
    	for(int L=2;L<len;L++){
    		for(int i=0;i<len-L;i++){
    			int j=i+L;
				dp[i][j]=prices[j]-prices[i];
				dp[i][j]=Math.max(dp[i][j], dp[i+1][j]);
				for(int k=i+1;k<j;k++)
					dp[i][j]=Math.max(dp[i][j], dp[i][k-1]+dp[k+1][j]);
				dp[i][j]=Math.max(dp[i][j], dp[i][j-1]);
    		}
    	}
		return dp[0][len-1];
    }
    public int maxProfit2(int[] prices) {
    	if(prices==null || prices.length==0)
    		return 0;
    	int len=prices.length;
    	int[][] dp=new int[len][len];
    	for(int i=0;i<len-1;i++){
    		dp[i][i]=0;
    		dp[i][i+1]=prices[i+1]-prices[i]>0?prices[i+1]-prices[i]:0;
    	}
//    	printArr2(dp);
    	for(int L=2;L<len;L++){
    		int j=L;
    		dp[0][j]=prices[j]-prices[0];
			dp[0][j]=Math.max(dp[0][j], dp[1][j]);
    		for(int k=1;k<j;k++)
    			dp[0][j]=Math.max(dp[0][j], dp[0][k-1]+dp[k+1][j]);
    		dp[0][j]=Math.max(dp[0][j], dp[0][j-1]);
    	}
    	return dp[0][len-1];
    }

    
    public void printArr2(int[][] nums){
    	for(int i=0;i<nums.length;i++){
    		for(int j=0;j<nums[0].length;j++)
    			System.out.printf("%4d",nums[i][j]);
    		System.out.println();
    	}
    }
    
    /***
     *  Time Limit Exceeded
     * */
    public boolean checkSubarraySum(int[] nums, int k) {
    	if(nums==null || nums.length==0)
    		return false;
    	int[][] subSum=new int[nums.length][nums.length];
    	for(int i=0;i<nums.length;i++)
    		subSum[i][i]=nums[i];

    	for(int len=2;len<=nums.length;len++){
    		for(int i=0;i<=nums.length-len;i++){
    			int j=i+len-1;
    			subSum[i][j]=subSum[i][j-1]+nums[j];
    			if(k==0 && subSum[i][j]==0)
    				return true;
    			if(k!=0 && subSum[i][j]%k==0)
    				return true;
    		}
    	}
		return false;
    }
    
    public boolean checkSubarraySum_2(int[] nums, int k) {
    	if(nums==null || nums.length==0)
    		return false;
    	int[] subSum=new int[nums.length+1];
    	for(int i=0;i<nums.length;i++)
    		subSum[i+1]=subSum[i]+nums[i];
    	
    	for(int i=2;i<=nums.length;i++){
    		for(int j=i-2;j>=0;j--){
    			if(k==0 && subSum[i]-subSum[j]==0)
    				return true;
    			if(k!=0 && (subSum[i]-subSum[j])%k==0)
    				return true;
    		}
    	}
    	return false;
    }
    
    public int numDecodings(String s) {
    	if(s==null || s.length()==0)
    		return 0;
    	int[] dp=new int[s.length()+1];
    	if(s.length()>1)
    		dp[0]=(s.charAt(0)-'0')*10+s.charAt(1)-'0'<=26 && (s.charAt(0)-'0')*10+s.charAt(1)-'0'>=10?1:0;
		dp[1]=s.charAt(0)=='0'?0:1;
    	for(int i=1;i<s.length();i++){
    		if(s.charAt(i)=='0' && (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'!=10 && (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'!=20)
    			dp[i+1]=0;
    		else if((s.charAt(i-1)-'0')*10+s.charAt(i)-'0'<=26 && (s.charAt(i-1)-'0')*10+s.charAt(i)-'0'>=10)
    			dp[i+1]=dp[i]+dp[i-1];
    		else
    			dp[i+1]=dp[i];
    	}
    	return dp[s.length()];
    }
}
