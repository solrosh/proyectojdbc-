// Mostraremos los departamentos al usuario al iniciar la aplicacion
// Le mostraremos un menú para que decida que necesita realizar:
//  1.- Insertar departamento
//  2.- Modificar departamento
//  3.- Eliminar departamento
//  4.- Salir

// Después ponemos cuantos registros han sido insertados/actualizados o eliminados.

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class07departamentos {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectionString, "root", "root");
            int opcion = 0;
            int registros = 0;
            while (opcion != 4) {
                String sqlVista = "select DNOMBRE from DEPT";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sqlVista);
                System.out.println("------------------------");
                System.out.println("Departamentos disponibles".toUpperCase());
                System.out.println("");
                while (rs.next()){
                    String nombreDepart = rs.getString("DNOMBRE");
                    System.out.println(nombreDepart.toLowerCase());
                }
                rs.close();
                System.out.println("------------------------");
                System.out.println("1.- Insertar departamento");
                System.out.println("2.- Modificar departamento");
                System.out.println("3.- Eliminar departamento");
                System.out.println("4.- Salir");
                System.out.println("------------------------");
                // Integer.parseInt (Sino te salta la línea)
                opcion = Integer.parseInt(read.nextLine());
                if (opcion == 1){
                    System.out.println("Introduzca id departamento: ");
                    String idDepartamento = read.nextLine();
                    System.out.println("Nombre departamento");
                    String nombreDepart = read.nextLine();
                    System.out.println("Localidad");
                    String localidadDepart = read.nextLine();
                    String sql = "insert into DEPT values (" + idDepartamento + ", '" + nombreDepart + "', '"
                            + localidadDepart + "'" + ")";
                    System.out.println(sql);
                    Statement st2 = cn.createStatement();
                    registros = st2.executeUpdate(sql);
                }else if (opcion ==2){
                    System.out.println("Introduzca id departamento: ");
                    String idDepartamento = read.nextLine();
                    System.out.println("Nombre departamento");
                    String nombreDepart = read.nextLine();
                    System.out.println("Localidad");
                    String localidadDepart = read.nextLine();
                    String sql = "insert into DEPT values (" + idDepartamento + ", '" + nombreDepart + "', '"
                            + localidadDepart + "'" + ")";
                    System.out.println(sql);
                    Statement st2 = cn.createStatement();
                    registros = st2.executeUpdate(sql);
                    System.out.println("Registros insertados: " + registros);
                }else if (opcion == 3) {

                }
            }
            System.out.println("Registros insertados: " + registros);
            cn.close();
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }
}
