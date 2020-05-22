String[] strvls = { "Alessio", "Ale" };
Object container = strvls;
if (container.getClass().isArray()) {
    Object[] data = (Object[]) container;
    System.out.println(data.length);
}