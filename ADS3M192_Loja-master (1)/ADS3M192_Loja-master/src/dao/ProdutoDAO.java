package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author assparremberger
 */
public class ProdutoDAO {
    
    public static void inserir(Produto produto){
        String query = "INSERT INTO produtos ( nome ) "
                + " VALUES ('" + produto.getNome() + "'); ";
        Conexao.executar( query );
    }
    
    public static void editar(Produto produto){
        String query = "UPDATE produtos SET "
                     + " nome =  '" + produto.getNome() + "' "
                     + " WHERE id = " + produto.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idCidade){
        String query = "DELETE FROM cidades  "
                     + " WHERE id = " + idCidade;
        Conexao.executar( query );
    }
    
    public static List<Produto> getCidades(){
        List<Produto> lista = new ArrayList<>();
        String query = "SELECT id, nome FROM cidades ORDER BY nome";
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
           
            try {
                while ( rs.next() ) {                    
                    Produto cid = new Produto();
                    cid.setId( rs.getInt( 1 ) );
                    cid.setNome( rs.getString( 2 ) );
                    lista.add(cid);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Produto getCidadeById( int idProduto ){
 
        String query = "SELECT id, nome FROM produtos "
                     + " WHERE id = " + idProduto;
        ResultSet rs = Conexao.consultar( query );
        if( rs != null ){
            try {
                rs.next();                   
                Produto cid = new Produto();
                cid.setId( rs.getInt( 1 ) );
                cid.setNome( rs.getString( 2 ) );
                return cid;
            } catch (Exception e) {
                return null;
            }
        }else{
            return null;
        }
    }
    
}
