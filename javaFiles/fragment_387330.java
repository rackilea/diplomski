@RunWith(CucumberJar.class)
@CucumberOptions(glue = {"com.abc.common"},
        tags = {"~@ignore"},
        plugin = {"json:target/cucumber/cucumber-report-common.json"})
@CucumberGroupsOptions({
        @CucumberOptions(glue = {"com.abc.def"},
                features = {"classpath:com/abc/def/",
                        "classpath:com/abc/common.feature"}
        ),
        @CucumberOptions(glue = {"com.abc.ghi"},
                features = {"classpath:com/abc/ghi/",
                        "classpath:com/abc/common.feature"}
        )
})
public class CucumberJarRunner {
}