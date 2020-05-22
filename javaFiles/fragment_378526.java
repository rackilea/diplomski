interface Provider
class ProviderImpl1 : Provider
class ProviderImpl2 : Provider

enum class Providers(private val supplier: () -> Provider) {
    ONE({ ProviderImpl1() }),
    TWO({ ProviderImpl2() });

    fun provider(): Provider = supplier.invoke()
}