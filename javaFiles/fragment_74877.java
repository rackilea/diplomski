class MyService {

   def grailsApplication

   private apiBean // use different name so 'api' resolves as property to getApi()

   def someMethod() {
      def foo = api.someMethodCall()
      ...
   }

   def someOtherMethod() {
      def bar = api.someOtherMethodCall()
      ...
   }

   private getApi() {
      if (apiBean == null) {
         String beanString = grailsApplication.configuration.api
         apiBean =  grailsApplication.mainContext.getBean(
               GrailsNameUtils.getPropertyName(beanString))
      }
      apiBean
   }
}