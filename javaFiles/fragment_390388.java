try {
                    p.fireBuildStarted();
                    p.init();
                    ProjectHelper helper = ProjectHelper.getProjectHelper();
                    p.addReference("ant.projectHelper", helper);
                    helper.parse(p, buildFile);
                    p.executeTarget(p.getDefaultTarget());
                    p.fireBuildFinished(null);
                } catch (BuildException e1) {
                    //p.fireBuildFinished(e);
                }