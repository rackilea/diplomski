import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckTables {

public WebDriver driver;


public static void main(String[] args) throws Exception {


    CheckTables objTest = new CheckTables();
    objTest.runTest();

}

public void runTest(){

    driver = new FirefoxDriver();

    driver.navigate().to("file:///D:/00_FX_WorkSpace/X_Hour/RoadTest_1.html");
    Map<String, List<String>> objTable_1 = readTable();
    System.out.println("TABLE:1" + objTable_1);

    //event to refresh the table
    driver.navigate().to("file:///D:/00_FX_WorkSpace/X_Hour/RoadTest_2.html");
    Map<String, List<String>> objTable_2 = readTable();
    System.out.println("TABLE:2" + objTable_2);

    compareTables(objTable_1, objTable_2);

}

public Map<String, List<String>> readTable(){

    Map<String, List<String>> objTable = new HashMap<>();

    List<WebElement> objRows = driver.findElements(By.cssSelector("tr#data"));
    for(int iCount=0; iCount<objRows.size(); iCount++){
        List<WebElement> objCol = objRows.get(iCount).findElements(By.cssSelector("td.tableTxt"));
        List<String> columns = new ArrayList<>();
        for(int col=0; col<objCol.size(); col++){
            columns.add(objCol.get(col).getText());
        }
        objTable.put(String.valueOf(iCount), columns);
    }

    return objTable;
}

public void compareTables(Map<String, List<String>> objTable1, Map<String, List<String>> objTable2){


    for(int count=0; count<objTable1.size(); count++){

        List<String> objList1 = objTable1.get(String.valueOf(count));
        System.out.println(objList1);
        List<String> objList2 = objTable2.get(String.valueOf(count));
        System.out.println(objList2);

        if(objList1.containsAll(objList2)){
            System.out.println("Row [" + count + "] is SAME");
        }
        else{
            //notify
            System.out.println("Row [" + count + "] has CHANGED");
        }
    }
}
}