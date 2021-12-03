package model.dao;
import connection.ConnectionFactory;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.bean. Table;

public class TableDAO {
    public void create(Table p){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    try{
        stmt=con.prepareStatement("INSERT INTO tabela (nome,ddd,tel) VALUES (?,?,?)");
        stmt.setString(1,p.getNome());
        stmt.setString(2,p.getDdd());
        stmt.setString(3,p.getTel());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null,"Salvo com Sucesso");
    } catch (SQLException ex)
    {JOptionPane.showMessageDialog(null, "Erro ao salvar:"+ex);}
    finally{ ConnectionFactory.closeConnection(con,stmt);}
    }

    public List<Table> read () throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Table> produtos = new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT *FROM TABELA");
            rs=stmt.executeQuery();
            while (rs.next()) {
                Table produto = new Table();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDdd(rs.getString("ddd"));
                produto.setTel(rs.getString("tel"));
                produtos.add(produto);
            }
        }catch (SQLException ex)
            {JOptionPane.showMessageDialog(null, "Erro na leitura:"+ex);}
            finally{ConnectionFactory.closeConnection(con,stmt,rs);}
            return produtos;
            }
    
    public void update (Table p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt=con.prepareStatement("UPDATE tabela SET nome =?, ddd =?, tel =? WHERE id=?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDdd());
            stmt.setString(3, p.getTel());
            stmt.setInt(4 ,p.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        }catch (SQLException ex)
        {JOptionPane.showMessageDialog(null, "Erro ao atualizar"+ex);}
        finally { ConnectionFactory.closeConnection(con,stmt);}
    }
    
    public void delete (Table p){
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    try {
        stmt=con.prepareStatement("DELETE FROM tabela WHERE id=?");
        stmt.setInt(1, p.getId());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "Excluido com sucesso");
    }catch (SQLException ex)
        {JOptionPane.showMessageDialog(null, "Erro ao excluir"+ex);}
        finally {ConnectionFactory.closeConnection(con,stmt);}
    
    }
    public List<Table> readForDesc(String desc) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Table> produtos = new ArrayList<>();
        try{
            stmt=con.prepareStatement("SELECT * FROM tabela WHERE nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs=stmt.executeQuery();
            while (rs.next()){
                Table produto = new Table();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDdd(rs.getString("ddd"));
                produto.setTel(rs.getString("tel"));
                produtos.add (produto);
                }
        } catch (SQLException ex)
        {JOptionPane.showMessageDialog(null,"Erro na leitura"+ex);}
        finally { ConnectionFactory.closeConnection(con, stmt, rs);}
        return produtos;
    }
}       
