package Model;

public class Usuario {


    private int Id;
    private String Nome;
    private  String UserName;
    private  String Senha;

    public Usuario(String nome, String userName, String senha) {
        Nome = nome;
        UserName = userName;
        Senha = senha;
    }

    public Usuario() {
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
