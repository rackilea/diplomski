private ArgumentCaptor<FacesMessage> facesMessageCaptor;
@Before
public void setUp() {facesMessageCaptor = ArgumentCaptor
            .forClass(FacesMessage.class);
}
@After
public void tearDown() { facesMessageCaptor = null; }