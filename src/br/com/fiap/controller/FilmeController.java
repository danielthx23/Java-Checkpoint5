package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Daniel Saburo Akiyama / RM: 558263
 * @author João Vitor Di Re / RM: 554749
 * @author Marcus Vila Nova da Silva / RM:
 * @author João Pedro R. / RM: 558199
 */
public class FilmeController {
    public String inserirFilme(String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.inserir(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterar(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String excluirFilme(int codigo) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluir(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarTodosFilmes() throws ClassNotFoundException, SQLException {
        String resultado = "";
        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        ArrayList<Filme> resultados = filmeDAO.listarTodos();
        if (resultados != null) {
            for (Filme filme : resultados) {
                resultado = resultado + "Código: " + filme.getCodigo()
                        + "\nTitulo: " + filme.getTitulo()
                        + "\nGenero: " + filme.getGenero()
                        + "\nProdutora: " + filme.getProdutora()
                        + "\n\n";

            }
        }
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
