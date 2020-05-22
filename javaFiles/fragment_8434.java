package sorapid;

import com.rapidminer.Process;
import com.rapidminer.RapidMiner;
import com.rapidminer.operator.Operator;
import com.rapidminer.operator.OperatorException;
import com.rapidminer.operator.io.ExcelExampleSource;
import com.rapidminer.tools.XMLException;
import java.io.File;
import java.io.IOException;

public class SOrapid {

  public static void main(String[] args) {
    try {
      RapidMiner.setExecutionMode(RapidMiner.ExecutionMode.COMMAND_LINE);
      RapidMiner.init();

      Process process = new Process(new File("c:\\Users\\Matlab\\.RapidMiner5\\repositories\\Local Repository\\processes\\test.rmp"));
      Operator op = process.getOperator("Read Excel");
      op.setParameter(ExcelExampleSource.PARAMETER_EXCEL_FILE, "d:\\excel.xls");
      process.run();

    } catch (IOException | XMLException | OperatorException ex) {
      ex.printStackTrace();
    }
  }
}