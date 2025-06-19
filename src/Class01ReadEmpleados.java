
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Class01ReadEmpleados {
    public static void main(String[] args) {
        // 1) Registrar la clase de nuestro driver
        // JDBC de mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2) Necestiamos una cadean de conexion
            String connecString = "jdbc:mysql://localhost:3306/hospital";
            // 3) Crear una conexion mediante drivermanager
            Connection cn = DriverManager.getConnection(connecString, "root", "root");
            // 4) Consulta sobre la BBDD
            String sql = "select * from EMP";
            // 5) Creamos el tipo de statement dependiendo de la consulta
            Statement st = cn.createStatement();
            // 6) Como es sonsulta select, necestiamos
            // UN ResultSet y el metodo executeQuery()
            ResultSet rs = st.executeQuery(sql);
            // Recuoeramos el primer apellido:
            // rs.next();
            // String apellido = rs.getString("APELLIDO");
            // System.out.println("Apellido: "+apellido);

            // 7) Recorremos los registros mediante un bucle while:

            while (rs.next()){
                String apellido =
                    rs.getString("APELLIDO");
                System.out.println("Apellido: "+apellido);
            }
            // 8 Liberamos los recursos

            rs.close();
            cn.close();
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.out.println("Class"+e);
        } catch (SQLException ex) {
            System.out.println("Sql: "+ex);
        }
    }
}
