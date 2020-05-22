@ContextConfiguration(classes = {SpringConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public void UnitTest {
   @Autowired Bean1 bean1;

   @Autowired Bean2 bean2;
}