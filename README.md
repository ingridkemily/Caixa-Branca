## Fluxo de Grafo no código

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


    public class User {
    4 - public Connection conectarDB(){
    5 - Connection conn = null;
    6 - try{
    7 - Class.forName("com.mysql.Driver.Manager").newInstance();
    7 - tring url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
    7 - conn = DriverManager.getConnection(url);
    }8 

        9 - catch (Exception e){} 10
        11 - return conn;
    }

    
    1 - public String nome = "";
    1 - public boolean result = false;
    

    
   2 -  public boolean VerificarUsuario(String login, String senha){
        3 - String sql = "";
        3 - Connection conn = conectarDB();

       12 - sql += "select nome from usuarios ";
       12 - sql += "where login = " + "'" + login + "'";
       12 - sql += " and senha = " + "'" + senha + "';";
        13- try{
            14 - Statement st = conn.createStatement();
            14 - ResultSet rs = st.executeQuery(sql);
            15 - if(rs.next()){
                16 - result  = true;
                16 - nome = rs.getString("nome");
            }17

        } 18
        19 - catch (Exception e){

        }20 
        21 - return  result;
    }

}     

## Grafo de Fluxo

<img src="/img/grafo-de-fluxo.png">
