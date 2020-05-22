import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import java.util.stream.StreamSupport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.FluentEntity;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class FluentEntityRepositoryTests {

    @Autowired
    private FluentEntityRepository fluentEntityRepository;

    @Test
    public void insertAndReceiveFluentEntityCreatedWithBuilder() {
        final String someName = "name";
        final int someNumber = 1;
        final boolean someFlag = true;

        FluentEntity entity = FluentEntity.builder().setSomeName(someName).setSomeNumber(someNumber)
                .setSomeFlag(someFlag).build();

        entity = fluentEntityRepository.save(entity);
        assertThat("Entity did not get an generated Id!", entity.getId(), greaterThan(-1L));
        assertThat("Entity name did not match!", entity.getSomeName(), is(someName));
        assertThat("Entity number did not match!", entity.getSomeNumber(), is(someNumber));
        assertThat("Entity flag did not match!", entity.isSomeFlag(), is(someFlag));
    }

    @Test
    public void insertSomeAndReceiveFirst() {
        fluentEntityRepository.save(FluentEntity.builder().setSomeName("A").setSomeNumber(1).setSomeFlag(true).build());
        fluentEntityRepository
                .save(FluentEntity.builder().setSomeName("B").setSomeNumber(2).setSomeFlag(false).build());
        fluentEntityRepository.save(FluentEntity.builder().setSomeName("C").setSomeNumber(3).setSomeFlag(true).build());

        final Iterable<FluentEntity> findAll = fluentEntityRepository.findAll();
        assertThat("Should get some iterable!", findAll, notNullValue());

        final FluentEntity fluentEntity = StreamSupport.stream(findAll.spliterator(), false).findFirst().get();
        assertThat("Should get some entity!", fluentEntity, notNullValue());
    }

}