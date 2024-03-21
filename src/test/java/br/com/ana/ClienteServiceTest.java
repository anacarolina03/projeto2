package br.com.ana;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.ana.dao.ClienteDaoMock;
import br.com.ana.dao.IClienteDAO;
import br.com.ana.domain.Cliente;
import br.com.ana.exceptions.TipoChaveNaoEncontradaException;
import br.com.ana.services.ClienteService;
import br.com.ana.services.IClienteService;

public class ClienteServiceTest {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf(12312312312L);
        cliente.setNome("Ana");
        cliente.setCidade("Rio de Janeiro");
        cliente.setEnd("Rua Angélica");
        cliente.setEstado("RJ");
        cliente.setNumero(100);
        cliente.setTel(2199999888L);

    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Ana");
        clienteService.alterar(cliente);

        Assert.assertEquals("Ana", cliente.getNome());
    }
}