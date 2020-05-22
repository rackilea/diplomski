public static List<BeanClass> sumPerItemCode
    (List<BeanClass> list) {

    Map<String, BeanClass> map = new HashMap<>();

    for (BeanClass p : list) {
        String code = p.getItemCode();
        BeanClass aggregatedItem = map.get(code);
        if (aggregatedItem == null) {
            aggregatedItem = new BeanClass(code, 0,0,0);
            map.put(code, aggregatedItem);
        }

        aggregatedItem.setCases(aggregatedItem.getCases() + p.getCases());
        aggregatedItem.setPacks(aggregatedItem.getPacks() + p.getPacks());
        aggregatedItem.setPcs(aggregatedItem.getPcs() + p.getPcs());
    }
    return new ArrayList<BeanClass>(map.values());
}