package io.sphere.sdk.deletemeplese;

import io.sphere.sdk.producttypes.ProductType;
import io.sphere.sdk.producttypes.queries.ProductTypeQuery;
import io.sphere.sdk.queries.PagedQueryResult;
import io.sphere.sdk.test.IntegrationTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SomeIntegrationTest extends IntegrationTest {


    @Test
    public void test(){

        final int PAGE_SIZE = 500;
        final long totalProductTypes = client().executeBlocking(ProductTypeQuery.of().withLimit(0)).getTotal();

        List<ProductType> allProductTypes = IntStream.range(0,(int)(totalProductTypes/PAGE_SIZE) +1)
                .mapToObj(i->i)
                .map(i -> ProductTypeQuery.of().withLimit(500).withOffset(i*PAGE_SIZE))
                .map(client()::executeBlocking)
                .map(PagedQueryResult::getResults)
                .flatMap(List::stream)
                .collect(Collectors.toList());

        assertThat(allProductTypes).hasSize((int)totalProductTypes);

    }

}