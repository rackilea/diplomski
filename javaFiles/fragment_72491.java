function showPleaseWait()
{
    $('.modal').modal('show');
}

<div class="modal fade bd-example-modal-lg" data-backdrop="static" data-keyboard="false" tabindex="-1">
    <div class="modal-dialog modal-sm">
        <div class="modal-content" style="width: 200px;">
            <span class="fa fa-spinner fa-spin fa-5x fa-fw" style="width: 200px;"></span>
            <p class="please-wait-message">Please wait</p>
        </div>
    </div>
</div>