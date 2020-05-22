object Functional
{
    @JvmStatic fun <T> toKotlin(supplier: Supplier<T>): () -> T = supplier::get
    @JvmStatic fun <T, R> toKotlin(function: Function<T, R>): (T) -> R = function::apply
    @JvmStatic fun <T> toKotlin(function: BinaryOperator<T>): (T, T) -> T = function::apply
    @JvmStatic fun <T> toKotlin(consumer: Consumer<T>): (T) -> Unit = consumer::accept
    ...
}