interface HaHa

@Component 
@ConditionalOnProperty(name = "myApp.haha", havingValue = "impl1", matchIfMissing = true)
class HahaImpl1: Haha {
    @Autowired 
    lateinit var repo: JpaRepository<Data, Long>
}

@Component 
@ConditionalOnProperty(name = "myApp.haha", havingValue = "impl2")
class HahaImpl2: Haha {
    // ...
}