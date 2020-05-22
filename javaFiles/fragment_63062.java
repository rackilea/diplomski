<form class="form-activate" th:action="@{/invite}" method="post">
    <h2 class="form-activate-heading" th:text="#{invite.title}">Nodig een student uit</h2>
    <p th:text="#{invite.email}">Vul hier het e-mailadres in van de student die je wil uitnodigen:</p>
    <div class="form-group">
        <input type="text" name="email[]" class="form-control input-lg" data-validation="email"
               placeholder="Email" tabindex="2" th:attr="placeholder=#{general.email}"/>
    </div>
    <div class="form-group">
        <input type="text" name="email[]" class="form-control input-lg" data-validation="email"
               placeholder="Email" tabindex="2" th:attr="placeholder=#{general.email}"/>
    </div>
    <div class="row">
        <div class="col-xs-6 col-sm-6 col-md-6">
            <input type="submit" class="btn btn-secondary" value="Invite"
                   th:attr="value=#{invite.enter}"/>
        </div>
    </div>
</form>