import java.util.*;
import java.util.Map.Entry;

/** old structure */
class KeyMapMediciones {
    public int tipoTransaccion;
    public String canal;
    public String aplicacion;
}

class Snippet {

    public static void main(String[] args) {

        Map<KeyMapMediciones,ResultadoConsultaNegocioStandard> medicionesMap =
                new HashMap<KeyMapMediciones,ResultadoConsultaNegocioStandard>();

        Map<KeyMapMediciones, ResultadoConsultaNegocioStandard> medicionesAplicacionMap =
                new HashMap<KeyMapMediciones,ResultadoConsultaNegocioStandard>();

        // create map of aplicacion to Medicion by second map
        Map<String, MedicionAplicacion> aplicacions = new HashMap<>();
        for (Entry<KeyMapMediciones, ResultadoConsultaNegocioStandard> entry : medicionesAplicacionMap.entrySet()) {
            KeyMapMediciones key = entry.getKey();
            ResultadoConsultaNegocioStandard value = entry.getValue();

            // copy data from old structure into new Medicion
            MedicionAplicacion medicionAplicacion = new MedicionAplicacion();
            medicionAplicacion.tipoTransaccion = key.tipoTransaccion;
            medicionAplicacion.aplicacion = key.aplicacion;
            medicionAplicacion.standard = value;

            aplicacions.put(medicionAplicacion.aplicacion, medicionAplicacion);
        }

        // create map of canal to Medicion by second map
        Map<String, MedicionCanal> canals = new HashMap<>();
        for (Entry<KeyMapMediciones,ResultadoConsultaNegocioStandard> entry : medicionesMap.entrySet()) {
            KeyMapMediciones key = entry.getKey();
            ResultadoConsultaNegocioStandard value = entry.getValue();

            // copy data from old structure into new Medicion
            MedicionCanal medicionCanal = new MedicionCanal();
            medicionCanal.tipoTransaccion = key.tipoTransaccion;
            medicionCanal.canal = key.canal;
            medicionCanal.standard = value;

            // link to aplication
            medicionCanal.medicionAplicacion = aplicacions.get(key.canal);

            canals.put(medicionCanal.canal, medicionCanal);
        }

    }
}