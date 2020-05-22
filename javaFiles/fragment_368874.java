import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductRestClientTestWithMockMvc {

    private static final String PRODUCT_API_URI = "http://localhost:8080/api/products/{productId}";
    private MockMvc mockMvc = null;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void before() throws Exception {
        mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @After
    public void after() throws Exception {
        mockMvc = null;
    }

    /*
     * Testing Happy Path scenario
     */
    @Test
    public void testProductFound() throws Exception {
        final MockHttpServletRequestBuilder builder = get(PRODUCT_API_URI, 35);
        final ResultActions result = mockMvc.perform(builder);
        result.andExpect(status().isOk());
    }

    /*
     * Testing Error scenario
     */
    @Test
    public void testProductNotFound() throws Exception {
        final MockHttpServletRequestBuilder builder = get(PRODUCT_API_URI, 555);
        final ResultActions result = mockMvc.perform(builder);
        result.andExpect(status().isNotFound());
    }

}