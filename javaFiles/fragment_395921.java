class Presenter : BaseJPresenter<Presenter, View> {
    override fun bindView(view: View) { ... }
}
class View : BaseJView<View, Presenter> {
    override fun createPresenter(): Presenter { ... }
}