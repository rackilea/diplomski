import com.sun.star.awt.XControlModel;
import com.sun.star.beans.XPropertySet;
import com.sun.star.container.XIndexAccess;
import com.sun.star.container.XNameAccess;
import com.sun.star.drawing.XControlShape;
import com.sun.star.drawing.XDrawPage;
import com.sun.star.drawing.XDrawPageSupplier;
import com.sun.star.sheet.XSpreadsheetDocument;
import com.sun.star.sheet.XSpreadsheets;
import com.sun.star.uno.AnyConverter;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XInterface;

//...
public void codesnippet(XInterface _oUnoEntryObject){
try{
    XSpreadsheetDocument xSpreadsheetDocument =  (XSpreadsheetDocument) UnoRuntime.queryInterface(XSpreadsheetDocument.class, _oUnoEntryObject);
    XSpreadsheets xSpreadsheets = xSpreadsheetDocument.getSheets();
    XNameAccess xNameAccess =  (XNameAccess) UnoRuntime.queryInterface(XNameAccess.class, xSpreadsheets);
    Object oName = xNameAccess.getByName("Sheet1");
    XDrawPageSupplier xDrawPageSupplier =  (XDrawPageSupplier) UnoRuntime.queryInterface(XDrawPageSupplier.class, oName);
    XDrawPage xDrawPage = xDrawPageSupplier.getDrawPage();
    XIndexAccess xIndexAccess =  (XIndexAccess) UnoRuntime.queryInterface(XIndexAccess.class, xDrawPage);
    Object oIndex = xIndexAccess.getByIndex(0);
    XControlShape xControlShape =  (XControlShape) UnoRuntime.queryInterface(XControlShape.class, oIndex);
    XControlModel xControlModel = xControlShape.getControl();
    XPropertySet xPropertySet =  (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, xControlModel);
    String sLabel = AnyConverter.toString(xPropertySet.getPropertyValue("Label"));
}catch (com.sun.star.beans.UnknownPropertyException e){
    e.printStackTrace(System.out);
    //Enter your Code here...
}catch (com.sun.star.lang.WrappedTargetException e2){
    e2.printStackTrace(System.out);
    //Enter your Code here...
}catch (com.sun.star.lang.IllegalArgumentException e3){
    e3.printStackTrace(System.out);
    //Enter your Code here...
}
}
//...