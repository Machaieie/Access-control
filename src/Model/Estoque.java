package Model;

import java.util.Date;

public class Estoque {
    private String codigo;
    private String codigoProduto;
    private int quantidade;
    private double preco;
    private Date data;

    public Estoque(String codigo, String codigoProduto, int quantidade, double preco, Date data) {
        this.codigo = codigo;
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.data = data;
    }

    public Estoque() {
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
