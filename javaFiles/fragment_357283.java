import spark.Request
import spark.routematch.RouteMatch
import spock.lang.Shared
import spock.lang.Specification

class ChargeRouterValidatorSpec extends Specification {
@Shared
HttpServletRequest servletRequest = Mock(HttpServletRequest.class)
@Shared
Request request

void "test"() {
    given:
    RouteMatch match = new RouteMatch(null, "/charges/:id", "/charges/1" , "text/html")
    request = new Request(match, servletRequest)

    when:
    servletRequest.getParameter("test") >> "test"
    def test = request.queryParams("test")

    then:
    test == "test"
}
}