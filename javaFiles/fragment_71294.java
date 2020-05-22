class UserViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: UserViewModel

    private val observer: Observer<User> = mock()

    @Before
    fun before() {
        viewModel = UserViewModel()
        viewModel.user.observeForever(observer)
    }

    @Test
    fun testUserViewModel() {
        val expectedUser = viewModel.user.value
        viewModel.setName("John")

        val captor = ArgumentCaptor.forClass(User::class.java)
        captor.run {
            verify(observer, times(2)).onChanged(capture())
            assertNotNull(expectedUser)
            assertEquals("John", value.name)
        }
    }
}