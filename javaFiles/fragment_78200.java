private static CategoryDataset createDataset()
{

    DefaultCategoryDataset categorydataset = new DefaultCategoryDataset();

    categorydataset.addValue(3D, "Super", "Sales/Q1");
    categorydataset.addValue(4D, "Super", "Sales/Q2");
    categorydataset.addValue(3D, "Super", "Sales/Q3");
    categorydataset.addValue(5D, "Super", "Sales/Q4");

    categorydataset.addValue(5D, "Student", "Sales/Q1");
    categorydataset.addValue(7D, "Student", "Sales/Q2");
    categorydataset.addValue(6D, "Student", "Sales/Q3");
    categorydataset.addValue(8D, "Student", "Sales/Q4");

    categorydataset.addValue(5D, "VIP", "Sales/Q1");
    categorydataset.addValue(7D, "VIP", "Sales/Q2");
    categorydataset.addValue(0D, "VIP", "Sales/Q3");
    categorydataset.addValue(3D, "VIP", "Sales/Q4");

    return categorydataset;
}