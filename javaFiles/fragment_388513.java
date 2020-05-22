TinkerGraph tg = TinkerGraph.open() ;
tg.io(IoCore.graphml()).readGraph("src\\main\\resources\\air-routes.graphml");
GraphTraversalSource g = tg.traversal();

g.V().propertyMap().select(Column.keys).next();
// result = {LinkedHashSet@1831}  size = 12
// 0 = "country"
// 1 = "code"
// 2 = "longest"
// 3 = "city"
// 4 = "elev"
// 5 = "icao"
// 6 = "lon"
// 7 = "type"
// 8 = "region"
// 9 = "runways"
// 10 = "lat"
// 11 = "desc"