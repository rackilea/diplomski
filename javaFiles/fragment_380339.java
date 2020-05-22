@Grab('org.spockframework:spock-core:0.7-groovy-2.0')
@Grab('cglib:cglib-nodep:3.1')
@Grab('org.apache.httpcomponents:httpclient:4.3.4')

import spock.lang.*
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.HttpClient
import org.apache.http.HttpEntity
import org.apache.http.HttpResponse
import org.apache.http.StatusLine
import org.apache.http.message.BasicHttpResponse

class Test extends Specification {

    def "test doGet(HttpGet httpGet) throws the correct exceptions when given unsuccessful HttpGet instance"() {
        given:
        def client = new Client()
        client.httpClient = GroovyMock(HttpClient) {
            execute(_) >> new BasicHttpResponse(null, 401, '')
        }

        when:
        client.doGet(GroovyMock(HttpGet))

        then:
        def e = thrown(ApiClientException)
        e.code == 401
        e.message == 'Recheck your login username & password credentials in the file Configurations.groovy as they are NOT working.'
    }
}

class ApiClientException extends Exception {

    def code
    def msg

    ApiClientException(code, msg) {
        this.code = code
        this.msg = msg
    }

    String getMessage() {
        'Recheck your login username & password credentials in the file Configurations.groovy as they are NOT working.'
    }
}

class Client {

    def HttpClient httpClient

    HttpEntity doGet(HttpGet httpGet) {

        HttpResponse response = httpClient.execute(httpGet)
        int statusCode = response.getStatusLine().getStatusCode()
        if (statusCode == 401) {
            throw new ApiClientException(401, "Recheck your login username & password credentials in the " +
                    "file Configurations.groovy as they are NOT working.");
        }
    }
}