package Controle;

import Data.DataBase;
import Model.Produto;
import Model.Vendas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendasController {

    public static void criarVendas(Vendas vendas) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "INSERT INTO Vendas (codigoProduto, Quantidade, Preco, Total) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1, vendas.getCodigoProduto());
            statement.setDouble(2, vendas.getQuantidade());
            statement.setDouble(3, vendas.getPreco());
            statement.setDouble(4, vendas.getTotal());
            statement.executeUpdate();
            System.out.println("Vendas criado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao criar vendas: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

    public static List<Vendas> ConsultarVendas() {
        List<Vendas> vendas = new ArrayList<>();
        Connection connection = DataBase.getConnection();
        try {
            String sql = "SELECT * FROM Vendas";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String codigoVenda = resultSet.getString("CodigoVenda");
                String codigoProduto = resultSet.getString("codigoProduto");
                int quantidade = resultSet.getInt("Quantidade");
                double preco = resultSet.getDouble("Preco");
                double total = resultSet.getInt("Total");
                Vendas venda = new Vendas(codigoVenda, codigoProduto,quantidade,preco,total);
                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar vendas: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
        return vendas;
    }


    public static void atualizarVenda(Vendas venda) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "UPDATE Vendas SET CodigoProduto = ?, Preco = ?, Quantidade = ?, Total = ? WHERE codigoVenda = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, venda.getCodigoProduto());
            statement.setDouble(2, venda.getPreco());
            statement.setInt(3, venda.getQuantidade());
            statement.setDouble(4, venda.getTotal());
            statement.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }

    public static void deletarVenda(String codigovenda) {
        Connection connection = DataBase.getConnection();
        try {
            String sql = "DELETE FROM Venda WHERE codigovenda = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, codigovenda);
            statement.executeUpdate();
            System.out.println("Venda deletada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar venda: " + e.getMessage());
        } finally {
            DataBase.closeConnection();
        }
    }
}
