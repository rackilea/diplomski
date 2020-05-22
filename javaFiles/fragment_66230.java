Git repo = Git.cloneRepository()
          .setURI(url)
          .setDirectory(destination))
          .setBranchesToClone(Arrays.asList("refs/heads/master"))
          .setCloneAllBranches(false)
          .setCloneSubmodules(true)
          .setNoCheckout(true)
          .call();

         repo.checkout().setStartPoint("origin/master").addPath("file1.txt").call();