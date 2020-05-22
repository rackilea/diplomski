import java.io.ByteArrayOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;



import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.techdisqus.App;
import com.techdisqus.config.SpringSecurityConfig;
import com.techdisqus.controller.DefaultController;

@RunWith(SpringRunner.class)
/*@SpringBootTest
@ContextConfiguration*/
@WebMvcTest(DefaultController.class)
@ContextConfiguration(classes= {App.class,SpringSecurityConfig.class
        })
@WebAppConfiguration
public class MvcTest {


      @Autowired
        private  MockMvc mockMvc;

      @Autowired
        private FilterChainProxy springSecurityFilterChain;

      @Autowired
        private WebApplicationContext wac;

      @Before
        public void setup() {
            this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac)
                .addFilters(this.springSecurityFilterChain).apply(SecurityMockMvcConfigurers.springSecurity()).build();
        }


    @Test
    public void testDown() {
        String url = "/down";
        try {

            MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            byte[] bytes = mvcResult.getResponse().getContentAsByteArray();
            FileOutputStream fos = new FileOutputStream("/Users/me/Desktop/output.xlsx");
            fos.write(bytes);
            fos.close();

            FileInputStream fis = new FileInputStream("/Users/me/Desktop/output.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            int count = wb.getNumberOfSheets();  
            System.out.println("count "+count);
            for(int i=0;i<count;i++) {
              System.out.println(wb.getSheetAt(i).getSheetName());
              //perform asserts here if needed
            }
            System.out.println("done!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}