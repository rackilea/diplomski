@Override
public boolean hasNotaFiscal(Pojo pojo) {

    String sql = "SELECT nota_fiscal.numero, nota_fiscal.tipo_emissao, d.cnpj as cnpjDestinatario, e.cnpj as cnpjEmitente FROM nota_fiscal";
    sql = sql.concat(" INNER JOIN destinatario ON (nota_fiscal.destinatario_id = destinatario.id)");
    sql = sql.concat(" INNER JOIN emitente ON (nota_fiscal.emitente_id = emitente.id)");
    sql = sql.concat(" INNER JOIN dados_empresa e ON (e.id = emitente.dados_empresa_id)");
    sql = sql.concat(" INNER JOIN dados_empresa d ON (d.id = destinatario.dados_empresa_id)");
    sql = sql.concat(" WHERE e.cnpj = :cnpjEmitente AND d.cnpj = :cnpjDestinatario AND numero = :numero AND tipo_emissao = :tipoEmissao");

    SQLQuery query = (SQLQuery) this.createSQLQuery(sql);

    query.setParameter("cnpjDestinatario", pojo.getDestinatario().getDadosEmpresa().getCnpj());
    query.setParameter("cnpjEmitente", pojo.getEmitente().getDadosEmpresa().getCnpj());
    query.setParameter("numero", pojo.getNumero());
    query.setParameter("tipoEmissao", pojo.getTipoEmissao().getIndex());

    return query.list().size() > 0;
}