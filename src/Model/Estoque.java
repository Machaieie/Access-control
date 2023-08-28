package Model;

public class Estoque {

    private int id;
    private Produto produto;
    private int quantidade;
    private double preco;

    private Produto IdProduto;

    public Estoque(int id, Produto produto, int quantidade, double preco, Produto idProduto) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
        IdProduto = idProduto;
    }

    public Estoque() {
    }

    public int getId() {
        return id;
    }

    public Produto getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(Produto idProduto) {
        IdProduto = idProduto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    @Override
    public String toString() {
        return "<------ Produto: "+produto.getNome()+" ---------->"+"\n" +
                "Quantidade: "+quantidade+"\n" +
                "Preco: "+preco;
    }
}
