// setup our sub-query on the Unit table first
QueryBuilder<Unit,Integer> uQb = unitDao.queryBuilder();
uQb.where().eq(Unit.TYPE_FIELD_NAME, UnitType.JUICES);
// outer query on UnitResult table
QueryBuilder<UnitResult,Integer> urQb = unitResultDao.queryBuilder();
// in using the sub-query
urQb.where().in(UnitResult.UNIT_COLUMN_NAME, uQb);
List<UnitResult> results = urQb.query();