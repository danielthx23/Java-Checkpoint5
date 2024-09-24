package br.com.fiap.model.dto;

/**
 * @author Daniel Saburo Akiyama / RM: 558263
 * @author João Vitor Di Re / RM: 554749
 * @author Marcus Vila Nova / RM:
 * @author João Pedro R. / RM: 558199
 */
public class Filme {
    private int codigo;
    private String titulo;
    private String genero;
    private String produtora;

    public Filme() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }
}
