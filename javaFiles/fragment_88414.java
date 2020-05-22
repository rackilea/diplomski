@RequestMapping(value = "/test_point", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
@ResponseBody
public Point testPoint() {

    Point point =geometryFactory.createPoint(new Coordinate(37.77, 60.01));
    String result = "";
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JtsModule());
    try {
        result = objectMapper.writeValueAsString(point);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }

    return point;
}