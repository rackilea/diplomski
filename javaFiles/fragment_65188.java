import grails.converters.JSON

class TestController {

    def test(RestCommand r){
        if(r.hasErrors()) {
           render (
               status: 400, 
               text: r.getErrors() as JSON)
        } else {
            render "id: "+r.id+" data: "+r.someData
        }
    }

}

class RestCommand {
    Integer id
    String someData

    static constraints = {
        id nullable: false
    } 

}