package Controle;

import Data.DataBase;
import Model.Estoque;
import Model.Produto;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EstoqueController {

    public static void criarEstoque(Estoque estoque) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "INSERT INTO Estoque ( Produto, Quantidade, Preco, IdProduto) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, estoque.getProduto());
            statement.setDouble(2, estoque.getQuantidade());
            statement.setDouble(3, estoque.getPreco());
            statement.setObject(4, estoque.getIdProduto());
            statement.executeUpdate();
            System.out.println("Estoque criado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar Estoque: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }


    public static List<Estoque> lerEstoque() {
        List<Estoque> estoque = new ArrayList<>();
        Connection connection = DataBase.getConnection();
        try {
            String sql = "SELECT * FROM Estoque";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                Object Produto = resultSet.getObject("Produto");
                int  quantidade = resultSet.getInt("Quantidade");
                double preco = resultSet.getDouble("Preco");
                Object IdProduto = resultSet.getObject("IdProduto");
                Estoque estoque1 = new Estoque(id, (Model.Produto) Produto, quantidade,preco, (Model.Produto) IdProduto);
                estoque.add(estoque1);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao ler Estoque: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
        return estoque;
    }

    public static void atualizarEstoque(Estoque estoque) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "UPDATE Estoque SET Produto = ?, Quanidade = ?, preco = ?, IdProduto = ? WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, estoque.getProduto());
            statement.setDouble(2, estoque.getQuantidade());
            statement.setDouble(3, estoque.getPreco());
            statement.setObject(4, estoque.getIdProduto());
            statement.executeUpdate();
            System.out.println("Estoque atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Estoque: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

    public static void deletarEstoque(int id) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "DELETE FROM Estoque WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Estoque deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar estoque: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }


}
