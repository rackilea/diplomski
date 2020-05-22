@RunWith(MockitoJUnitRunner.class)
    public class StackOverflowTest {

        @InjectMocks
        private StackOverflow userService = new StackOverflow();

        @Mock
        private UserRepository userRepository;

        @Mock
        private ObjectMapperUtils modelMapper;
        private UserDTO userDTO = new UserDTO();
        private UserEntity userEntity = new UserEntity();

        @Before
        public void setUp() {
            when(modelMapper.map(any(), any())).thenReturn(userDTO);

            userDTO.setId(1L);
            userDTO.setUsername("zavada");
            userDTO.setUserId("33b4c069-e907-45a9-8d49-2042044c56e0");
        }

        @Test
        public void testGetByUserId() throws Throwable {
            when(userRepository.findByUserId(anyString())).thenReturn(Optional.of(userEntity));

            UserDTO result = userService.getByUserId("33b4c069-e907-45a9-8d49-2042044c56e0");
            System.out.println(result);

            assertEquals("zavada", result.getUsername());
            assertNotNull(result);

        }
    }