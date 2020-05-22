import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MockitoSettingDatabaseIds {

    private static class TestEntity {
        private long id;
        private String text;

        public TestEntity(String text) {
            this.text = text;
        }

        public long getId() {
            return id;
        }

        public String getText() {
            return text;
        }
    }

    private interface TestEntityDAO {
        void save(TestEntity entity);
    }

    private static long someLogicToTest(TestEntityDAO dao, TestEntity entity) {
        dao.save(entity);
        return entity.getId();
    }

    @Test
    public void shouldReturnDatabaseGeneratedId() {
        long expectedId = 12345L;

        TestEntityDAO dao = mock(TestEntityDAO.class);
        TestEntity entity = new TestEntity("[MESSAGE]");

        doAnswer(invocation -> {
            ReflectionTestUtils.setField((TestEntity) invocation.getArgument(0), "id", expectedId);
            return null;
        }).when(dao).save(entity);

        assertThat(someLogicToTest(dao, entity)).isEqualTo(expectedId);
    }
}