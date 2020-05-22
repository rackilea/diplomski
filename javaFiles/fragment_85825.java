public Collection<Long> getPropertyIdsByTaxId(Long externalTaxId) {
        SQLQuery query = currentSession().createSQLQuery("select b.OMH_PROPERTY_ID from OMH_EXTERNAL_TAX a , " +
                "OMH_EXTERNAL_TAX_PROP_XREF b\n" +
                "where a.OMH_EXTERNAL_TAX_ID=b.OMH_EXTERNAL_TAX_ID and a.OMH_EXTERNAL_TAX_ID = :externalTaxId ")
                .addScalar("OMH_PROPERTY_ID", LongType.INSTANCE);
        query.setParameter("externalTaxId", externalTaxId);
        Collection<BigDecimal> propertyIdsList = (Collection<BigDecimal>) query.list();
        Long propertyIdsListValue = null;
        Collection<Long> propertyIds = new HashSet<Long>();
        for (BigDecimal propertyId : propertyIdsList) {
            propertyIdsListValue = propertyId.longValue();
            propertyIds.add(propertyIdsListValue);
        }
        return propertyIds;
    }