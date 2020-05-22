import javax.persistence.Table;
import java.util.function.Function;

interface Join<T> {
    //select * from tab_a a left join tab_b b on a.col1 = b.col2
    Join<T> leftJoin(Sql Sql);
    //select * from tab_a a left join tab_b b `on a.col1 = b.col2`
    // 1.Function implements Serializable
    // 2.class.getDeclaredMethod("writeReplace")
    // 3.get field name
    <T1,T2> Sql<T> on(Function<T1,Object> bf1, Function<T2,Object> bf2);
}

interface BuilderFunction<T,R> {
    R build(T t);
}

class SqlCondition {

    public <T> SqlCondition andEquals(BuilderFunction<T, String> f, String x) {
        return this;
    }
}

interface Sql<T> extends Join<T> {
    // select a,b,c ...
    Sql<T> select(BuilderFunction<T, Object>... t);
    // from tab_a,tab_b
    Sql<T> from(Class<T> t);
    // select * from tab_a a
    Sql<T> alias(String name);
    //select * from tab_a where col = ?
    Sql<T> where(SqlCondition condition);
    // get sql
    String build();
}

class SqlImpl<T> implements Sql<T> {

    @Override
    public Join<T> leftJoin(Sql Sql) {
        return null;
    }

    @Override
    public <T1, T2> Sql<T> on(Function<T1, Object> bf1, Function<T2, Object> bf2) {
        return null;
    }

    @Override
    public Sql<T> select(BuilderFunction<T, Object>... t) {
        return null;
    }

    @Override
    public Sql<T> from(Class<T> t) {
        return null;
    }

    @Override
    public Sql<T> alias(String name) {
        return null;
    }

    @Override
    public Sql<T> where(SqlCondition condition) {
        return null;
    }

    @Override
    public String build() {
        return null;
    }
}

@Table(name="a_tab")
class A {
    private Long aId;
    private String name;

    public String getName() {
        return name;
    }

    public Long getAId() {
        return aId;
    }

    //getter setter
}

@Table(name="b_tab")
class B {
    private Long bId;
    private Long aId;

    public Long getAId() {
        return aId;
    }

    public Long getBId() {
        return bId;
    }

    //getter setter
}

public class Mappers {
    public static class SqlBuilder {
        //SqlImpl class implements Sql, and select,from,method,alias,where return this.
        public static <T> SqlImpl<T> builder() {
            return new SqlImpl<>();
        }
    }

    public static void main(String[] args) {
        Mappers.SqlBuilder.<A>builder()
                .select(A::getAId,A::getName)
                .from(A.class)
                .where(new SqlCondition().andEquals(A::getName,"x"))
                .leftJoin(Mappers.SqlBuilder.<B>builder()
                        .select(B::getAId,B::getBId)
                        .from(B.class)
                        .alias("b_tab")
                )
                .on(A::getAId,B::getAId); // error: Non-static method cannot be referenced from a static context`.
    }
}