package Model;

public class Produto {
    private int Codigo;
    private String nome;
    private double preco;
    private int quantidade;
    private String descricao;

    public Produto(int codigo, String nome, double preco, int quantidade, String descricao) {
        this.Codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }


    public Produto() {
    }

    public int getId() {
        return Codigo;
    }

    public void setId(int codigo) {
        this.Codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Nome: "+nome+"\n" +
                "Preco: "+preco+"\n" +
                "Quantidade: "+quantidade+"\n" +
                "Descricao: "+descricao;
    }
}
