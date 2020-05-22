class MenuNode {
    private MenuNode() {
        // Does nothing important
    }
    public static MenuNode createStatic(param1, param2, param3) {
         MenuNode result = new MenuNode();
         result.setItemType(ITEM_TYPE_STATIC);
         result.setParam1(param1);
         result.setParam2(param2);
         result.setParam3(param3);
         result.doStuffHere();
         return result;
    }
    public static MenuNode createDynamic(paramX, paramY) {
         MenuNode result = new MenuNode();
         result.setItemType(ITEM_TYPE_DYNAMIC);
         result.setParamX(paramX);
         result.setParamY(paramY);
         result.doStuffHere();
         return result;
    }