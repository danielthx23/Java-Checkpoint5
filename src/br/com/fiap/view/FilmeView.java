package br.com.fiap.view;

import br.com.fiap.controller.FilmeController;

import javax.swing.*;

public class FilmeView {
    public static void main(String[] args) {
        int codigo;
        String titulo, genero, produtora;
        String[] escolha = {"Inserir","Alterar","Excluir","Listar"};
        int opcao;
        FilmeController filmeController = new FilmeController();
        do {
            try {
                opcao = JOptionPane.showOptionDialog(null, "Escolha uma das opções abaixo para manipular um Cliente", "Escolha", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, escolha, escolha[0]);
                switch (opcao) {
                    case 0:
                        titulo = JOptionPane.showInputDialog("Digite o titulo do filme");
                        genero = JOptionPane.showInputDialog("Digite o genero do filme");
                        produtora = JOptionPane.showInputDialog("Digite a produtora do filme");
                        System.out.println(filmeController.inserirFilme(titulo, genero, produtora));
                        break;
                    case 1:
                        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do filme"));
                        titulo = JOptionPane.showInputDialog("Digite o NOVO titulo do filme");
                        genero = JOptionPane.showInputDialog("Digite o NOVO genero do filme");
                        produtora = JOptionPane.showInputDialog("Digite a NOVA produtora do filme");
                        System.out.println(filmeController.alterarFilme(codigo, titulo, genero, produtora));
                        break;
                    case 2:
                        codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do filme"));
                        System.out.println(filmeController.excluirFilme(codigo));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, filmeController.listarTodosFilmes());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
        JOptionPane.showMessageDialog(null, "Fim de Programa");
    }
}
