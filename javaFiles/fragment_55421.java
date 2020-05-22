<script>
    jQuery.noConflict();
    jQuery(document).ready(function() {
        initDataTable();
    });
    function initDataTable() {
        jQuery('.table').dataTable({
            "bSort": false
        }); 
    }
</script>