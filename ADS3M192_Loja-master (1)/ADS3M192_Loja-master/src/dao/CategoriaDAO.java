package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

/**
 *
 * @author assparremberger
 */
public class CategoriaDAO {
    
    public static void inserir(Categoria categoria){
        String query = "INSERT INTO categorias ( nome ) "
                + " VALUES ('" + categoria.getNome() + "'); ";
        Conexao.executar( query );
    }
    
    public static void editar(Categoria categoria){
        String query = "UPDATE categorias SET "
                     + " nome =  '" + categoria.getNome() + "' "
                     + " WHERE id = " + categoria.getId();
        Conexao.executar( query );
    }
    
    public static void excluir(int idCategoria){
        String query = "DELETE FROM categorias  "
                     + " WHERE id = " + idCategoria;
        Conexao.executar( query );
    }
    
    public static List<Categoria> getCategoria(){
        List<Categoria> lista = new ArrayList<>();
        String query = "SELECT id, nome FROM categorias ORDER BY nome";
        ResultSet rs = Conexao.consultar( query );
        
        if( rs != null ){
           
            try {
                while ( rs.next() ) {                    
                    Categoria cid = new Categoria();
                    cid.setId( rs.getInt( 1 ) );
                    cid.setNome( rs.getString( 2 ) );
                    lista.add(cid);
                }
            } catch (Exception e) {
                
            }
        }
        return lista;
    }
    
    public static Categoria getCidadeById( int idCategoria ){
 
        String query = "SELECT id, nome FROM categorias "
                     + " WHERE id = " + idCategoria;
        ResultSet rs = Conexao.consultar( query );
        if( rs != null ){
            try {
                rs.next();                   
                Categoria cid = new Categoria();
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
