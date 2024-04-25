/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution637 {//bfs+hashmap
    public List<Double> averageOfLevels(TreeNode root) {
        //traverse the tree and save each node into a List<HashMap<node.val,height>>
        //不能用hashmap！因为可能会有【1，1】这样的exp，hashmap不能有same key
        //因此还是应该用set
        //traverse the hashmap and cal the ave of each height

        //corner case
        if(root.left==null&&root.right==null) return Collections.singletonList((double)root.val);
        List<Double> res = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        bfs(root,0,list);
        System.out.println(list);

        for(int i = 0; i<list.size();i++){
            if(!list.get(i).isEmpty()){
                double currSum = 0.00000;
                for(int j = 0;j<list.get(i).size();j++){
                    currSum += list.get(i).get(j);
                }
                double result = currSum / list.get(i).size();
                res.add(result);
            }
        }
        return res;
    }

    public void bfs(TreeNode node,int height,List<List<Integer>> list){
        if(node == null) return;

        list.get(height).add(node.val);

        if(node.left != null || node.right != null){
            list.add(new ArrayList<Integer>());
            bfs(node.right,height+1,list);
            bfs(node.left,height+1,list);
        }
    }
}


class Solution637 { //bfs+queue
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return null;
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            double currSum = 0.00000;
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                currSum += node.val;
                if(node.left!=null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            res.add(currSum/size);
        }
        return res;

    }
}