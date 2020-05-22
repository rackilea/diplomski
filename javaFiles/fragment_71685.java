refsideMerge=existingRepo.exactRef("refs/heads/sideMerge");
tmpMerge = git.merge();
tmpMerge.include(refsideMerge);
tmpMerge.setCommit(false);//dry run to get conflicting files
tmpMergeRes = tmpMerge.call();

Map allConflicts = tmpMergeRes.getConflicts();          
 for (Map.Entry<String,int[][]> entry : tmpMergeRes.getConflicts().entrySet()) {
 System.out.println("Key: " + entry.getKey());
  for(int[] arr : entry.getValue()) {
   System.out.println("value: " + Arrays.toString(arr));
  }
}
git.reset().setMode(ResetType.HARD).call();