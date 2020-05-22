<form class="form-horizontal" role="form" method="post" name="registration" novalidate>
  <div class="form-group" ng-class="{ 'has-error' : (registration.phone.$invalid || registration.phone.$pristine)}">
    <label for="inputPhone" class="col-sm-3 control-label">Phone :</label>
    <div class="col-sm-9">
      <input type="number" class="form-control" ng-pattern="ph_numbr"  id="inputPhone" name="phone" placeholder="Phone" ng-model="user.phone" ng-required="true">
      <div class="help-block" ng-messages="registration.phone.$error">
        <p ng-message="required">Phone number is required.</p>
        <p ng-message="pattern">Phone number is invalid.</p>
      </div>
    </div>
  </div>
</form>