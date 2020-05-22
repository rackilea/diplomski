. . .
    Map<String, String> formData = form.data();
    String schoolId = formData.get("school.id");
    Integer id = Integer.parseInt(schoolId);
    if (id == null) {
        return badRequest("Incorrect school identifier: " + schoolId);
    }
    School scl = School.find.byId(id);
    if (scl == null) {
        return notFound("Can't found school with id " + schoolId);
    }
    String specialityId = formData.get("speciality.id");
    id = Integer.parseInt(specialityId);
    if (id == null) {
        return badRequest("Incorrect speciality identifier: " + specialityId);
    }
    Speciality spc = Speciality.find.byId(id);
    if (spc == null) {
        return notFound("Can't found speciality with id " + specialityId);
    }
    Card card = form.get();
    card.person = p;
    card.school = scl;
    card.speciality = spc;
    . . .