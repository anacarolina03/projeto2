package br.com.ana.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.ana.dao.Persistente;
import br.com.ana.exceptions.TipoChaveNaoEncontradaException;

public interface IGenericService<T extends Persistente, E extends Serializable> {

    /**
     * Método para cadastrar novos registro no banco de dados
     *
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
     */
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    /**
     * Método para excluir um registro do banco de dados
     */
    public void excluir(E valor);

    /**
     * Método para alterar um registro no bando de dados.
     */
    public void alterar(T entity) throws TipoChaveNaoEncontradaException;

    /**
     * Método para consultar um registro no banco de dados
     */
    public T consultar(E valor);

    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     */
    public Collection<T> buscarTodos();
}