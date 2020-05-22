int gridcol1 = 0;
int gridcol2 = 1;


Insets ins = new Insets(0,0,0,0);

int y=0;
GridBagConstraints SymbolTextc           = new GridBagConstraints(gridcol1, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);
GridBagConstraints SymbolLabelc          = new GridBagConstraints(gridcol2, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0); 

y++;

GridBagConstraints ComapnyTextc          = new GridBagConstraints(gridcol1, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);
GridBagConstraints ComapnyLabelc         = new GridBagConstraints(gridcol2, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);

y++;

GridBagConstraints PriceTextc            = new GridBagConstraints(gridcol1, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);
GridBagConstraints PriceLabelc           = new GridBagConstraints(gridcol2, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);

y++;

GridBagConstraints MaxQtyTextc           = new GridBagConstraints(gridcol1, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);
GridBagConstraints MaxQtyLabelc          = new GridBagConstraints(gridcol2, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);

y++;

GridBagConstraints PurchasePowerTextc    = new GridBagConstraints(gridcol1, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);
GridBagConstraints PurchasePowerLabelc   = new GridBagConstraints(gridcol2, y, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE,ins,0,0);