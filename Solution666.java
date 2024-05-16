class Solution666 {
    class TreeNode{
        public TreeNode left,right;
        public int val;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    private int res = 0;
    public int pathSum(int[] nums) {
        if( nums == null || nums.length == 0) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        q.add(root);
        int i = 1;
        while(!q.isEmpty() && i < nums.length){
            TreeNode node = q.poll();
            // left tree node
            if(checkLeft(node.val, nums[i])) {
                TreeNode leftNode = new TreeNode(nums[i]);
                q.add(leftNode);
                node.left = leftNode;
                //      System.out.print(" left node "+nums[i]);
                i++;
            }
            // right tree node
            if( i < nums.length && checkRight(node.val,nums[i])) {
                TreeNode rightNode = new TreeNode(nums[i]);
                q.add(rightNode);
                node.right = rightNode;
                //     System.out.print(" right node "+nums[i]);
                i++;
            }
        }
        // get path pathSum
        helper(root,0);
        return res;
    }
    private boolean checkLeft(int root, int leave) {
        if (leave / 100 -root / 100 != 1) return false;
        int rootLayer = root / 100;
        int rootPos = (root / 10) % 10;
        int leavePos = (leave / 10) % 10;
        int correctPos = (leavePos == 1) ? 1 : rootPos * 2 - 1;
        return leavePos == correctPos;
    }

    private boolean checkRight(int root, int leave) {
        if (leave / 100 -root / 100 != 1) return false;
        int rootLayer = root / 100;
        int rootPos = (root / 10) % 10;
        int leavePos = (leave / 10) % 10;
        int correctPos = rootPos * 2;
        return leavePos == correctPos;
    }

    private void helper(TreeNode root, int tmp){
        if(root == null){
            return ;
        }
        // leave node
        if( root.left == null && root.right == null) {
            res += tmp + root.val % 10;
            return ;
        }
        tmp += root.val % 10;
        helper(root.left, tmp);
        helper(root.right, tmp);

    }

}