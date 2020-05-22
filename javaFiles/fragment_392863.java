package de.scrum_master.stackoverflow

import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.http.HttpStatus.*

class OnboardingControllerTest extends Specification {
  OnboardingService service = new OnboardingService()
  OnboardingController controller
  ResponseEntity response

  @Unroll
  def "HTTP response #statusCode when creating service model"() {
    given:
    if (exception) {
      service = Stub() {
        createServiceModel(_) >> { throw exception }
      }
    }
    controller = new OnboardingController(onboardingService: service)

    when:
    response = controller.createServiceModel("test", Mock(MultipartFile))

    then:
    response.statusCode == statusCode

    where:
    exception                                    | statusCode
    null                                         | OK
    new MalformedContentException()              | BAD_REQUEST
    new ServiceModelNameAlreadyExistsException() | CONFLICT
    new ServiceUnavailableException()            | SERVICE_UNAVAILABLE
  }
}