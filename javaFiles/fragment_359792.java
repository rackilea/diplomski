import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.binarisinformatik.api.AppConfig;
import org.binarisinformatik.satzrechner.SatzRechner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class SatzRechnerTest {

    @Autowired
    private SatzRechner satzRechner;

    @Test
    public void addiere_satz_4komma6_zu_zahlwert_10() {

        assertThat("Addition von \"4,6\" ergibt nicht 10!",
                satzRechner.summe("4,6"), is(equalTo(10)));
    }
}