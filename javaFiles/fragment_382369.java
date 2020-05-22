class SmsParameters {
    ... // Add methods to set parameters, in some non-restrictive way.
    ... // In particular, users should be able to pass login parameters through it
}

class SmsReturn {
    ... // Add methods to harvest the return value, e.g. as an Object
}

interface ISmsService {
     SmsReturn sendSms(SmsParameters args);
}