@RequestMapping(method=RequestMethod.POST) 
public ModelAndView gravar(ContaCorretora contaCorretora)   { 

    contaCorretora.setPessoa(pessoaDao.find(contaCorretora.getPessoa().getIdPessoa()));
    //I escaped  null check and not found exceptions, you should apply some logic to take care of that
    contaCorretoraDao.gravar(contaCorretora);
    return new ModelAndView("pessoa/listageral"); 
}