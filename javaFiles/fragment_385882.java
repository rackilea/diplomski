import org.apache.hadoop.fs.Path;
import scala.runtime.AbstractFunction1;
import java.io.Serializable;

public class FileFilter extends AbstractFunction1<Path, Object> implements Serializable {

  @Override
  public Object apply(Path v1) {
    if ( v1.toString().endsWith((".json")) ) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}