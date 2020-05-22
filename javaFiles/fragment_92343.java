function getContextPath() {
   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

requirejs.config({
    baseUrl: getContextPath() + '/js/ops/libs',
    paths:{
        jquery:'jQuery-2.2.4/jquery-2.2.4.min',
        bootstrap:'Bootstrap-3.3.7/js/bootstrap.min',
        dataTables: 'datatables.min',
    }
});