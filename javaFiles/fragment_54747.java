Date startDate = ...;
Date endDate = ...;
DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Event.class, Event.class.getClassLoader());
Property startDateProperty = PropertyFactoryUtil.forName("startDate");
Property endDateProperty = PropertyFactoryUtil.forName("endDate");
dynamicQuery.add(startDateProperty.ge(startDate));
dynamicQuery.add(endDateProperty.le(endDate));