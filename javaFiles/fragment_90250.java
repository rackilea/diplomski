import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProductTest {
    private static final Product CACHED_PRODUCT = new Product("some parameters for cached product");
    private static final Product DB_PRODUCT = new Product("some parameters for DB product");

    private ProductService service;
    private ProductDao productDaoMock;
    private ProductCacheDao productCacheDaoMock;

    @Before
    public void setup() {
        service = new ProductService();
        productDaoMock = mock(ProdoctDao.class);
        service.setProductDao(productDaoMock);

        productCacheDaoMock = mock(ProdoctCacheDao.class);
        service.setProductCacheDao(productCacheDaoMock);
    }

    @Test
    public void testCache() {
        when(productCacheDaoMock.getProductLookUpData(any())).thenReturn(CACHED_PRODUCT);

        final Product product = service.getProductLookUpData();

        Assert.assertEquals(CACHED_PRODUCT, product);
        verify(productCacheDaoMock, times(1)).getProductLookUpData(any());
        verify(productDaoMock, never()).getIpacMetricCodeLookUpData(any());
    }

    @Test
    public void testDB() {
        when(productCacheDaoMock.getProductLookUpData(any())).thenThrow(new IllegalStateException());
        when(productDaoMock.getIpacMetricCodeLookUpData(any())).thenReturn(DB_PRODUCT);

        final Product product = service.getProductLookUpData();

        Assert.assertEquals(DB_PRODUCT, product);
        verify(productCacheDaoMock, times(1)).getProductLookUpData(any());
        verify(productDaoMock, times(1)).getIpacMetricCodeLookUpData(any());
    }
}