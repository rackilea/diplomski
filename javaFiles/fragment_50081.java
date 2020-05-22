public class InicioModel implements InicioMvpModel{

@Inject
public InicioModel() {

}

@Override
public void recuperarAgendamentos(Presenter inicioPresenter) {

    //...

      inicioPresenter.atualizarListaAgendamentos(agendamentos);

    }
}