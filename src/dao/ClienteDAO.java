package dao;

import model.Cliente;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	
    public void inserir(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO cliente (nome, data_nasc, cpf, email, senha) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try {
            conn = Conexao.getConexao(); 
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getData_nasc());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getSenha());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar no banco: " + e.getMessage());
        } finally {
            fecharConexoes(conn, stmt, null);
        }
    }

    public void atualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "UPDATE cliente SET nome=?, data_nasc=?, cpf=?, email=?, senha=? WHERE id=?";

        try {
            conn = Conexao.getConexao();
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getData_nasc());
            stmt.setString(3, cliente.getCpf());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getSenha());
            stmt.setInt(6, cliente.getId());

            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar no banco: " + e.getMessage());
        } finally {
            fecharConexoes(conn, stmt, null);
        }
    }
    private void fecharConexoes(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}