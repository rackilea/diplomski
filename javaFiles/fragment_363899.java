@Data
@AllArgsConstructor
static class RegionShopMap {
    private Integer regionId;
    private String shopId;
}

public static void main(String args[]) {
    ExpressionParser parser = new SpelExpressionParser();
    StandardEvaluationContext context = new StandardEvaluationContext();
    Set<RegionShopMap> regionShopMapSet = new HashSet<>();
    regionShopMapSet.add(new RegionShopMap(1, "2"));
    regionShopMapSet.add(new RegionShopMap(3, "4"));

    context.setVariable("regionShopMapSet", regionShopMapSet);
    Expression exp = parser.parseExpression("#regionShopMapSet[1].regionId");
    System.out.println(exp.getValue(context));
    return;
}