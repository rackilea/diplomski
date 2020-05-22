public class ServiceAgreementFactory {

  List<Transportation> get(SaveTransportationCommand command, Validator validator) {
      if(!validator.validate(command)) {
        // throw Exception
      }
  }
}