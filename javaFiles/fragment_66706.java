public void More ...decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
46            throws AccessDeniedException {
47        int deny = 0;
48
49        for (AccessDecisionVoter voter : getDecisionVoters()) {
50            int result = voter.vote(authentication, object, configAttributes);
51
52            if (logger.isDebugEnabled()) {
53                logger.debug("Voter: " + voter + ", returned: " + result);
54            }
55
56            switch (result) {
57            case AccessDecisionVoter.ACCESS_GRANTED:
58                return;
59
60            case AccessDecisionVoter.ACCESS_DENIED:
61                deny++;
62
63                break;
64
65            default:
66                break;
67            }
68        }
69
70        if (deny > 0) {
71            throw new AccessDeniedException(messages.getMessage("AbstractAccessDecisionManager.accessDenied",
72                    "Access is denied"));
73        }
74
75        // To get this far, every AccessDecisionVoter abstained
76        checkAllowIfAllAbstainDecisions();
77    }