import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class04InsertarDepartamento {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn =  DriverManager.getConnection(connectionString, "root", "root");
            cn.setAutoCommit(false);
            System.out.println("Introduzca id departamento: ");
            String idDepartamento = teclado.nextLine();
            System.out.println("Nombre departamento");
            String nombreDepart = teclado.nextLine();
            System.out.println("Localidad");
            String localidadDepart = teclado.nextLine();
            String sql = "insert into DEPT values ("+idDepartamento+", '"+nombreDepart+"', '"+localidadDepart+"'"+")";
            System.out.println(sql);
            Statement st =  cn.createStatement();
            int registros = st.executeUpdate(sql);
            System.out.println("Registros insertados: "+registros);
            // Al ser una base de datos Transaccional (Mysql, Oracle)
            // debemos indicar que los cambios son permanentes
            // 1.- Permanente: commit
            // 2.-Deshacer los cambios: rollback
            cn.commit();
            // Cerramos la conexión:
            cn.close();
            // ResultSet rt = st.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("Error 16"+e);
        }
    }
}
