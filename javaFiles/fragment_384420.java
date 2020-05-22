VelocityEngine ve = new VelocityEngine();
ve.init();
incl = new existTemplate(ve);

VelocityContext c = new VelocityContext();
c.put("date", new DateTool());
c.put("incl", incl);