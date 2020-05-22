DetachedCriteria innerCrit = DetachedCriteria.forClass(Campagne.class);
        innerCrit.createAlias("progressionCampagnes", "prog");
        innerCrit.setProjection(Projections.avg("prog.campaignProgression");
        innerCrit.add(Restrictions.eqProperty("id", "campOuter.id"));

        DetachedCriteriaouterCrit = DetachedCriteria.forClass(Campagne.class, "campOuter");
        outerCrit.add(Subqueries.eq(100, innerCrit));