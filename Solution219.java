public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        //corner case
        if(nums.length <= 1 || k<=0) return false;

        //hashmap<value,index>
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                System.out.println("find this!");
                int j = map.get(nums[i]);
                System.out.println("j is "+ j);
                int gap = Math.abs(j - i);
                System.out.println("gap is "+gap);
                if( gap <= k){
                    return true;

                }else{
                    map.put(nums[i],i);
                    System.out.println("update the right one + "+map.get(nums[i]));
                }
            }else{
                map.put(nums[i],i);
                System.out.println("add new");
            }
        }

        return false;
    }
}
