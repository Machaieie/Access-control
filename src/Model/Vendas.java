package Model;


public class Vendas {

    private String codigoVenda;
     private String codigoProduto;
     private int quantidade;
     private double preco;
     private double total;

    public Vendas(String codigovenda, String codigoProduto, int quantidade, double preco, double total) {
        this.codigoVenda = codigovenda;
        this.codigoProduto = codigoProduto;
        this.quantidade = quantidade;
        this.preco = preco;
        this.total = total;
    }

    public Vendas(){

    }

    public String getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(String codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
