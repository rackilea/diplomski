class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Task extends RecursiveTask<TreeNode>
{
    int[] nums;
    int start,end;
    public Task(int[] nums,int start,int end)
    {
        this.nums =nums;
        this.start = start;
        this.end = end;
    }
    protected TreeNode compute()
    {
        if(start>end)
        {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        Task leftSubTask = new Task(nums,start,mid-1);
        Task rightSubTask = new Task(nums,mid+1,end);
        leftSubTask.fork();
        rightSubTask.fork();
        node.left = leftSubTask.join();
        node.right = rightSubTask.join();
        return node;

    }
}
class Main
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        int nums[] = {1,5,7,8,9};
        Task task = new Task(nums,0,nums.length-1);
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        TreeNode root = forkJoinPool.invoke(task);
    }
}