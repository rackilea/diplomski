package ${PACKAGE_NAME};

#if ($NAME.endsWith("Test"))
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
#end

#parse("File Header.java")
public class ${NAME} 
{  

#if ($NAME.endsWith("Test"))
    // Add any default test methods or such you want here.
#end

}