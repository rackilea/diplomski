String repoLocation = "http://hamcrest.googlecode.com/svn/trunk";
logOperation.setSingleTarget(
        SvnTarget.fromURL(
                SVNURL.parseURIEncoded( repoLocation )
        )
);