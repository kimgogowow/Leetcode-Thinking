class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //base case
        if(n==0 || n==1 || edges == null){
            return Collections.singletonList(0);
        }
        //create the graph structure
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new HashSet<>());
        }
        //store all elements according to the edge
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //use queue to store leaves(has only one neigbor)
        Queue<Integer> leaves = new LinkedList<>();
        for(int i = 0 ;i <n;i++){
            if(graph.get(i).size()==1) leaves.offer(i);
        }
        /*
        set:
        0[3]
        1[3]
        2[3]
        3[0,1,2,4]
        4[3,5]
        5[4]

        leaves:[0,1,2,5]
        */

        //iteratively remove the leaves until the last two node
        while(n>2){
            int size = leaves.size();
            n = n - size;
            while(size>0){
                int leaf = leaves.poll();
                int nei = graph.get(leaf).iterator().next();
                graph.get(nei).remove(leaf);
                size--;

                if(graph.get(nei).size()==1){
                    leaves.add(nei);
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}