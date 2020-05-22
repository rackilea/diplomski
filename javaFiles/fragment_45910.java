private String  convertPolygonToJSON(Polygon p) {
        List<LatLng> points=p.getPoints();
        StringBuilder sb = new StringBuilder("[1,["+points.get(0));
        for (int i = 1; i < points.size(); i++) {
            sb.append(+ ","+points.get(i));
        }
        sb.append("],{\"strokeColor\":\"#FF0000\",\"fillColor\":\"#00FFFF\"}]");
        return sb.toString();

}