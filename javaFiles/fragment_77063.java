public class RexTester {
    // MAIN CLASS

    static class Rextester {
        public static void main(String args[]) {
            new MyFragment();
        }
    }

// MVP CODE

    interface BaseView {}

    final static class MyPresenter extends BasePresenter<MyPresenter.MyView> {

        public MyPresenter() {}

        public void executeAction() {
            mView.onCallback();
        }

        interface MyView extends BaseView {
            void onCallback();
        }

    }

    abstract static class BasePresenter<V extends BaseView> {

        protected V mView;

        public void attachView(V view) { mView = view;}
        public void detachView() { mView = null; }

    }

    final static class MyFragment extends BaseFragment<MyPresenter.MyView, MyPresenter> implements MyPresenter.MyView {

        private MyPresenter mPresenter;

        public MyFragment() {
            mPresenter = new MyPresenter();

            onResume(); // Mock onResume() lifecycle event!

            mPresenter.executeAction();

            onPause(); // Mock onPause() lifecycle event!
        }

        protected MyPresenter getPresenter() {
            return mPresenter;
        }

        @Override
        protected MyPresenter.MyView getThis() {
            return this;
        }

        public void onCallback() {
            System.out.println("Hello AndroidMVP!");
        }
    }

    abstract static class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends Fragment implements BaseView {

        protected abstract P getPresenter();

        protected void onResume() {
            super.onResume();
            getPresenter().attachView(getThis());
        }

        protected abstract V getThis();

        protected void onPause() {
            super.onPause();
            getPresenter().detachView();
        }
    }

// ANDROID FRAMEWORK MOCK

    abstract static class Fragment {

        protected void onResume() {}

        protected void onPause() {}

    }
}