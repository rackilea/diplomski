import java.util.Arrays;
import java.util.List;

import java8.util.stream.Collectors;
import java8.util.stream.StreamSupport;
import static java.lang.Boolean.TRUE;
import static java.lang.Boolean.FALSE;

public class CaseDetails {

    Boolean caseClosed = FALSE;

    public CaseDetails(Boolean caseClosed) {
        this.caseClosed = caseClosed;
    }

    public String toString() {
        return "caseClosed: " + caseClosed;
    }

    public static void main(String[] args) {
        List<CaseDetails> caseDetailsList = Arrays.asList(
                new CaseDetails(TRUE), new CaseDetails(FALSE), new CaseDetails(
                        TRUE));
        List<CaseDetails> closedCaseDetailsList = StreamSupport
                .stream(caseDetailsList)
                .filter(item -> item.caseClosed.equals(TRUE))
                .collect(Collectors.toList());

        System.out.println(closedCaseDetailsList);
    }
}