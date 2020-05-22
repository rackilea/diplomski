public static class NF {
    public static NumberFormat formatShares = NumberFormat.getInstance();
    public static NumberFormat formatCash = NumberFormat.getInstance();

    static {
        formatShares.setGroupingUsed(true);
        formatShares.setMaximumFractionDigits(0);
        formatCash.setGroupingUsed(true);
        formatCash.setMaximumFractionDigits(2);
        formatCash.setMinimumFractionDigits(2);
   }       
}