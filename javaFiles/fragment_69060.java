Rate rate = (Rate)table.getModel().getValueAt(row, col);
switch (rate.getRateSource()) {
   case EMPTY:
        // set some color
        break;
   case EDITED:
        // set some color
        break;
   default:
        // not edited, set some color
}