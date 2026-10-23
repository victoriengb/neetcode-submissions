class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 2)
            return new int[] {0, 1};
        
        HashMap<Integer, Integer> differenceToIndex = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++){
            if (differenceToIndex.containsKey(nums[i]))
                return new int[] {differenceToIndex.get(nums[i]), i};
            differenceToIndex.put(target - nums[i], i);
        }
        return new int[] {-1, -1};
    }
}
