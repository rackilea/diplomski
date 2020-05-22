/**
 * Obtain GitWorkingCopyLog for all changes on branch with (svn --stop-on-copy equivalent) 
 * @param repoDir
 * @return GitWorkingCopyLog
   */
private GitWorkingCopyLog getLogs(File repoDir) {
  List<RevCommit> commits = []
  Git git = openExistingRepository(repoDir)

  ObjectId head = getHead(git.repository)  // tip of current branch

  // find common merge ancestor branch points for all branches
  List<String> forkCandidates = mergeBaseForAllBranches(git, head)

  for (RevCommit r in git.log().call()) {
    if (r.name in forkCandidates) {
      break // stop looping on first rev in common merge base
    }
    commits.add(r)
  }
  return new GitWorkingCopyLog(git.repository, commits)
}

/**
 * Generate list of commit ids for merge base with all candidates.  All branches come from master
 * so all branches share a common point of origin even if unrelated.
 * @param git jgit controller
 * @param head head revision for target branch
 * @return list of commit ids
 */
private ArrayList mergeBaseForAllBranches(Git git, ObjectId head) {
  def baseCandidates = []
  getBranches(git).each { Ref other ->
    if (other.objectId != head) {
      String base = getMergeBase(git.repository, head, other.objectId)
      baseCandidates.add(base)
    }
  }
  baseCandidates
}

/**
 *
 * @param repository
 * @param commitIdA
 * @param commitIdB
 * @return divergence point between the two branches (even if seemingly unrelated all must come back to master)
 */
private String getMergeBase(Repository repository, ObjectId commitIdA, ObjectId commitIdB) {
  RevWalk walk = new RevWalk(repository)
  try {
    RevCommit revA = walk.lookupCommit(commitIdA)
    RevCommit revB = walk.lookupCommit(commitIdB)

    walk.setRevFilter(RevFilter.MERGE_BASE)


    walk.markStart(revA)
    walk.markStart(revB)
    RevCommit mergeBase = walk.next()
    println "\tA: ${revA.name}\n\tB: ${revB.name}\n\tM: ${mergeBase.name}"
    if (! mergeBase) { return null }
    return mergeBase.name
  } catch(Exception e) {
    project.logger.error("GetMergeBase Failed: ${commitIdA}, ${commitIdB} because ${e.message}")
  }
  return null
}

/**
 * Get Refs for all branches
 * @param git
 * @return Ref list
 */
private List<Ref> getBranches(Git git) {
  List<Ref> branchRefs = git.branchList().call()
  return branchRefs
}    `