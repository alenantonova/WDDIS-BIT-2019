package hello;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class RatesManagerTest {

    @Mock
    private RatesManager ratesManagerMock;

    @Before
    public void setUp() throws Exception {
        ratesManagerMock = mock(RatesManager.class);
        RatesManager manager = new RatesManager();
        String[] rows = manager.getData("30");
        Mockito.when(ratesManagerMock.getData(any())).thenReturn(rows);
        double[] rates = manager.parseRates(rows);
        Mockito.when(ratesManagerMock.parseRates(any())).thenReturn(rates);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getMaxRateTest() {
        RatesManager manager = new RatesManager();
        assertEquals(65.3354, manager.getMaxRate(ratesManagerMock.parseRates(null)), 0.001);
    }
}