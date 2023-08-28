package Controle;

import Data.DataBase;
import Model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {

    public static void criarProduto(Produto produto) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "INSERT INTO Produtos (Nome, Preco, Quantidade, Descricao) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setString(4, produto.getDescricao());
            statement.executeUpdate();
            System.out.println("Produto criado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar produto: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

    public static List<Produto> lerProdutos() {
        List<Produto> produtos = new ArrayList<>();
        Connection connection = DataBase.getConnection();
        try {
            String sql = "SELECT * FROM Produtos";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String nome = resultSet.getString("Nome");
                double preco = resultSet.getDouble("Preco");
                int quantidade = resultSet.getInt("Quantidade");
                String descricao = resultSet.getString("Descricao");
                Produto produto = new Produto(id, nome, preco,quantidade,descricao);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ler produtos: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
        return produtos;
    }

    public static void atualizarProduto(Produto produto) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "UPDATE Produtos SET Nome = ?, Preco = ?, Quantidade = ?, Descricao = ? WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setString(4, produto.getDescricao());
            statement.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

    public static void deletarProduto(int id) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "DELETE FROM Produtos WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Produto deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar produto: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }
}
