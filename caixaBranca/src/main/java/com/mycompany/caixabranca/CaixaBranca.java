import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe `CaixaBranca` é sistema de autenticação que se conecta a um banco de dados MySQL
 * e verifica se o usuário: login e senha existe no banco de dados.
 */
public class CaixaBranca {

    /**
     * Método para estabelecer uma conexão com o banco de dados MySQL.
     *
     * @return Um objeto de conexão com o banco de dados ou null se a conexão não puder ser estabelecida.
     */
    public Connection conectarDB(){
        Connection conn = null;
        try {
            // Carrega o driver do MySQL.
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // Define a URL de conexão ao banco de dados.
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            // Estabelece a conexão com o banco de dados.
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Manipula exceções se ocorrerem durante a conexão, mas não faz nada neste exemplo.
        }
        return conn;
    }

    // Campos para armazenar o nome do usuário e o resultado da verificação.
    public String nome = "";
    public boolean result = false;

    /**
     * Verifica se um usuário com um login e senha específicos existe no banco de dados.
     *
     * @param login O nome de usuário a ser verificado.
     * @param senha A senha a ser verificada.
     * @return true se o usuário existe, false caso contrário.
     */
    public boolean VerificarUsuario(String login, String senha){
        String sql = "";
        Connection conn = conectarDB();

        // Monta a consulta SQL para verificar o usuário.
        sql += "select nome from usuarios ";
        sql += "where login = " + "'" + login + "'";
        sql += " and senha = " + "'" + senha + "';";

        try {
            // Cria uma declaração SQL e executa a consulta.
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Se um resultado for retornado, o usuário existe.
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Manipula exceções se ocorrerem durante a verificação, mas não faz nada neste exemplo.
        }

        return result;
    }
}
