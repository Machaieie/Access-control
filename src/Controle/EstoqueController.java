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
            String sql = "INSERT INTO Estoque ( codigoProduto, Quantidade, Preco, data) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, estoque.getCodigoProduto());
            statement.setDouble(2, estoque.getQuantidade());
            statement.setDouble(3, estoque.getPreco());
            statement.setDate(4, (Date) estoque.getData());
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
                String codigo = resultSet.getString("codigo");
                String codigoProduto = resultSet.getString("codigoProduto");
                int  quantidade = resultSet.getInt("Quantidade");
                double preco = resultSet.getDouble("Preco");
                Date data = resultSet.getDate("Data");
                Estoque estoque1 = new Estoque(codigo, codigoProduto, quantidade,preco, data);
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
            String sql = "UPDATE Estoque SET CodigoProduto = ?, Quanidade = ?, preco = ?, Data = ? WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, estoque.getCodigoProduto());
            statement.setDouble(2, estoque.getQuantidade());
            statement.setDouble(3, estoque.getPreco());
            statement.setObject(4, estoque.getData());
            statement.executeUpdate();
            System.out.println("Estoque atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar Estoque: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

    public static void deletarEstoque(String codigo) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "DELETE FROM Estoque WHERE codigo = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, codigo);
            statement.executeUpdate();
            System.out.println("Estoque deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar estoque: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }


}
