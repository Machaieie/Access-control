package Model;

public class Usuario {


    private int Id;
    private String Nome;
    private  String UserName;
    private  String Senha;

    public Usuario(int id, String nome, String userName, String senha) {
        Id = id;
        Nome = nome;
        UserName = userName;
        Senha = senha;
    }

    public Usuario() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }


}
