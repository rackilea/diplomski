import org.hamcrest.Description;
import org.junit.internal.matchers.TypeSafeMatcher;

public class UniformInterfaceExceptionMatcher extends TypeSafeMatcher<UniformInterfaceException> {

public static UniformInterfaceExceptionMatcher hasStatus(int status) {
    return new UniformInterfaceExceptionMatcher(status);
}

private int actualStatus, expectedStatus;

private UniformInterfaceExceptionMatcher(int expectedStatus) {
    this.expectedStatus = expectedStatus;
}

@Override
public boolean matchesSafely(final UniformInterfaceException exception) {
    actualStatus = exception.getResponse().getStatus();
    return expectedStatus == actualStatus;
}

@Override
public void describeTo(Description description) {
    description.appendValue(actualStatus)
            .appendText(" was found instead of ")
            .appendValue(expectedStatus);
}