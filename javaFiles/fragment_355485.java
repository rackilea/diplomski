import java.util.ArrayList;
import java.util.List;

public class ExpedienteImpl {

    public List<Nota> notas;
    public Double notaMedia;

    //Constructor
    public ExpedienteImpl() {
        this.notas = new ArrayList<Nota>();
        this.notaMedia = getNotaMedia();
    }

    private Double getNotaMedia() {
        // TODO Auto-generated method stub
        return null;
    }

    private void checkNota(Integer cursoAcademico, TipoConvocatoria tipoConvocatoria, Asignatura asignatura){
        Nota objNota = new NotaImpl(asignatura, cursoAcademico, tipoConvocatoria, 0.0, null, null);
        if(notas.contains(objNota)){
                System.out.println("Nota matched");
        }
    }

}

interface Nota {

Asignatura getAsignatura();

Integer getCursoAcademico(); //Dado por el primer aÃ±o del curso, eg: 2014/15 -> 2014

TipoConvocatoria getTipoConvocatoria(); //Primero, segundo o tercero

Double getValorNota();
TipoNota getTipoNota(); //0-5 Supenso, 5-7 Aprobado, 7-9 Notable, 9-10 Sobresaliente, 9-10 + menciÃ³n = MatrÃ­cula de Honor,  
Boolean getMencionHonor();


}

class NotaImpl implements Nota {

//Atributos
private Integer cursoAcademico;
private TipoConvocatoria tipoConvocatoria;
private Double valorNota;
private TipoNota tipoNota;
private Boolean mencionHonor;
private Asignatura asignatura;

//Constructores
public NotaImpl(Asignatura asignatura, Integer cursoAcademico, TipoConvocatoria tipoConvocatoria, Double valorNota, TipoNota tipoNota, Boolean mencionHonor) {
    checkerNumero(valorNota);
    checkerMencion(mencionHonor, valorNota);
    this.cursoAcademico = cursoAcademico;
    this.tipoConvocatoria = tipoConvocatoria;
    this.tipoNota = tipoNota;
    this.valorNota = valorNota;
    this.mencionHonor = mencionHonor;
}

private void checkerMencion(Boolean mencionHonor2, Double valorNota2) {
    // TODO Auto-generated method stub

}

private void checkerNumero(Double valorNota2) {
    // TODO Auto-generated method stub

}

@Override
public Asignatura getAsignatura() {
    return null;
}

@Override
public Integer getCursoAcademico() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public TipoConvocatoria getTipoConvocatoria() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public Double getValorNota() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public TipoNota getTipoNota() {
    // TODO Auto-generated method stub
    return null;
}

@Override
public Boolean getMencionHonor() {
    // TODO Auto-generated method stub
    return null;
}

public boolean equals(Nota nota){
    if(this.getCursoAcademico().equals(nota.getCursoAcademico()))
        return true;
    return false;
}
}


class Asignatura{
}

class TipoConvocatoria{

}

class TipoNota{

}