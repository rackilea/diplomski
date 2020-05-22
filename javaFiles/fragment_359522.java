package myatm;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class ATMtest {

    // Class Under Test
    ATM atm;

    @Before
    public void setup() {
        Card card = mock(Card.class);
        Account acc = mock(Account.class);
        when(card.isBlocked()).thenReturn(Boolean.FALSE);
        when(card.checkPin(1234)).thenReturn(Boolean.TRUE);
        when(acc.getBalance()).thenReturn((double) 1);
        atm = new ATM(1500);
        atm.setAcc(acc);
    }

    @Test
    public void testCheckBalance() {

        /* Test */
        double result = atm.checkBalance();

        /* Asserts */
        Assert.assertEquals((double) 1, result, .001);
    }

}