int months = -2;
    int years = -3;
    JsDate j = JsDate.create(new Date().getTime());
    j.setMonth(j.getMonth() + months);
    j.setFullYear(j.getFullYear() + years);
    Date d = new Date((long)j.getTime());