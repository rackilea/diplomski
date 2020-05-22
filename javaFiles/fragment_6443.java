@RequestMapping(value = "/horario/{fecha}", method = RequestMethod.GET)
@ResponseBody
public Object queryHorariosLibres(@PathVariable("fecha") @DateTimeFormat(pattern="yyyy-MM-dd") Date fecha) {
List<Long> horariosLibres = null;
List<Long> turnosTomados = turnoService.getTurnosTomados(fecha);
Calendar dia = new GregorianCalendar();
dia.setTime(fecha);
Horario horario = horarioRepository.findByDia(dia.get(Calendar.DAY_OF_WEEK));  
horariosLibres = horario.getHorariosLibres(turnosTomados);
if (horariosLibres == null) {
    return "hola";
} else
return horariosLibres;
}