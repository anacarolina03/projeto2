package br.com.ana.dao;

import br.com.ana.dao.generic.IGenericDAO;
import br.com.ana.domain.Venda;
import br.com.ana.exceptions.TipoChaveNaoEncontradaException;

public interface IVendaDAO extends IGenericDAO<Venda, String> {
    public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}