Git git = ... // you get it through a CloneCommand, InitCommand 
              // or through the file system

CheckoutCommand coCmd = git.checkout(); 
// Commands are part of the api module, which include git-like calls
coCmd.setName("master");
coCmd.setCreateBranch(false); // probably not needed, just to make sure
coCmd.call(); // switch to "master" branch

MergeCommand mgCmd = git.merge();
mgCmd.include("foo"); // "foo" is considered as a Ref to a branch
MergeResult res = mgCmd.call(); // actually do the merge

if (res.getMergeStatus().equals(MergeResult.MergeStatus.CONFLICTING)){
   System.out.println(res.getConflicts().toString());
   // inform the user he has to handle the conflicts
}