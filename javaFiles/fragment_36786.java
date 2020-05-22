interface TransformT {}
interface TransformS {}
interface Transformable extends TransformT, TransformS {}

interface Transformer<T extends TransformT, S extends TransformS>
    T transform(S s);
    S transform(T t);
}

abstract class AbstractDTO implements Transformable {}
abstract class AbstractDomain implements Transformable {}

new SomeTransformerImpl<AbstractDTO, AbstractDomain>()