// Eliminar datos de la tabla enfermo. delete from ENFERMO where INSCRIPCION=1234;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class05EliminarEnfermo {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");
            System.out.println("Introduzca inscripcion: ");
            String inscripcion = read.nextLine();
            String sql = "delete from ENFERMO where INSCRIPCION="+inscripcion;
            Statement st = cn.createStatement();
            int deleted = st.executeUpdate(sql);
            System.out.println("Enfermos eliminados: "+deleted);

            String sqlSelect = "select * from ENFERMO";
            ResultSet rs = st.executeQuery(sqlSelect);
            while (rs.next()){
                String ins = rs.getString("INSCRIPCION");
                String ape = rs.getString("APELLIDO");
                System.out.println(ins+"-"+ape);
            }
            rs.close();
            // Cerramos conexion:
            cn.close();
        } catch (Exception e) {
            System.out.println("Buenas error"+e);
        }
    }
}
