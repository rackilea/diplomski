/* Creating Hotfix Branch */
createBranchCommand = git.branchCreate();
createBranchCommand.setName("hotfix_" + releaseVersion);
createBranchCommand.setUpstreamMode(SetupUpstreamMode.SET_UPSTREAM);
createBranchCommand.setStartPoint("origin/" + "hotfix_" + releaseVersion);
createBranchCommand.setForce(true);
createBranchCommand.call();