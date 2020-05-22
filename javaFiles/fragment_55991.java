@Singleton
class ResourceProvider @Inject constructor(private val context: Context) {
  fun getString(@StringRes id: Int): String {
    return context.getString(id)
  }

  fun getString(@StringRes id: Int, vararg formatArgs: Any): String {
    return context.getString(id, *formatArgs)
  }
...
}