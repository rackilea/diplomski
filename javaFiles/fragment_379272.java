package moduleprototype

class ConfigTest {
    int id //int configid
    String name
    String type
    String value
    String description
    int status

    static mapping /*constraints*/ = {
        version false
        id column: 'CONFIGID', name:'id' /*name:'configid'*/,  type: 'integer'
    }
}