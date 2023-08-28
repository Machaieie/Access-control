package Controle;

import Data.DataBase;
import Model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    public static void criarUsuario(Usuario usuario) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "INSERT INTO Usuario (Nome, UserName, Password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getUserName());
            statement.setString(3, usuario.getSenha());
            statement.executeUpdate();
            System.out.println("Usuario criado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar usuario: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

    public static List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        Connection connection = DataBase.getConnection();
        try {
            String sql = "SELECT * FROM Usuario";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String nome = resultSet.getString("Nome");
                String userName = resultSet.getString("UserName");
                String senha = resultSet.getString("Senha");
                Usuario usuario = new Usuario(id, nome, userName,senha);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ler usuarios: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
        return usuarios;
    }

    public static void atualizarUsuario(Usuario usuario) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "UPDATE Usuario SET Nome = ?, UserName = ?, Senha = ?, WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getUserName());
            statement.setString(3, usuario.getSenha());
            statement.executeUpdate();
            System.out.println("Usuario atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Usuario: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

    public static void deletarUsuario(int id) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "DELETE FROM Usuario WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Usuario deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar Usuario: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

}
