interface BaseJView<TSelf : BaseJView<TSelf, P>, P : BaseJPresenter<P, TSelf>> {
    fun createPresenter(): P
}

interface BaseJPresenter<TSelf : BaseJPresenter<TSelf, V>, V : BaseJView<V, TSelf>> {
    fun bindView(view: V)
}