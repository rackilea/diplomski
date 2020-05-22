public class CategoryResultTransformer extends AliasToBeanResultTransformer {
    public static final String CID_ALIAS = "cid";
    private int cidIndex = -1;

    public CategoryResultTransformer() {
        super(ProductResults.class);
    }

    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        if (cidIndex < 0) {
            for (int i = 0; i < aliases.length; ++i) {
                if (CID_ALIAS.equals(aliases[i])) {
                    cidIndex = i;
                    break;
                }
            }
        }

        return new Object[] { tuple[cidIndex], super.transformTuple(tuple, aliases) };
    }

    @Override
    public List transformList(List list) {
        List<CategoryResult> res = new ArrayList<CategoryResult>();
        Map<Long, CategoryResult> map = new HashMap<Long, CategoryResult>();

        for (Object[] row : (List<Object[]>)list) {
            long cid = ((Number)row[0]).longValue();
            CategoryResult cat = map.get(cid);

            if (cat == null) {
                cat = new CategoryResult();
                cat.setCid(cid);
                res.add(cat);
                map.put(cid, cat);
            }

            cat.getProducts().add((ProductResults)row[1]);
        }

        return res;
    }
}