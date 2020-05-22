package huru;

import huru.util.Async;
import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

@RunWith(VertxUnitRunner.class)
public class AsyncTest {


  @Test
  public void test(TestContext tc) {
    Async.Parallel(Arrays.asList(

      v -> {
        v.done(null, null);
      }

    ), (e, results) -> {

    });
  }

}