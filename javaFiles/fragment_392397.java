@Service
public class SomeClass{

        private final MappingDef mappingDef;

        @Autowired
        public SomeClass(MappingDef mappingDef) {
            this.mappingDef = mappingDef; 
        }

        public UserDto myMethodToTest(){

        // doing some business logic here returning a user
        // User user = Some Business Logic

        return mappingDef.userToUserDto(user)
}