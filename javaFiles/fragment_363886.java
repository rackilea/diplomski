public static Result save() {
    Form<Device> boundForm = deviceForm.bindFromRequest();
    if (boundForm.hasErrors()){
        return badRequest(devices.details.render(boundForm));
    }

    Device boundDevice = boundForm.get();
    Device existingDevice = Device.find.byId(boundDevice.id);

    if (boundDevice.name.equals(existingDevice.name)){
        boundForm.reject("Contents are identical");
        return badRequest(devices.details.render(boundForm));
    }

    // else... form hasn't errors, name changed - should be updated...
    boundDevice.update(boundDevice.id);
}