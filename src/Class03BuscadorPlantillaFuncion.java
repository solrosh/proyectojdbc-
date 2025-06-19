// Programa que nos mopstrará el Apellido, función y salario de las Personas de la plantilla.
// Filtraremos dichas personas mediantes sus función.
// Pediremos la función al usuario y mostraremos los datos.
// select APELLIDO,FUNCION,SALARIO from PLANTILLA where FUNCION ="";

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class03BuscadorPlantillaFuncion {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Introduzca la funciona del empleado: ");
        String funcionHospital = read.nextLine();
        String c = "'";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conectionString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection (conectionString,"root","root");
            // En las bases de datos se usan SIEMPRE comillas simples ' '
            // Varias opciones de hacerlo : FUNCION like '"+funcionHospital+"'" || FUNCION= '"+funcionHospital+"'";
            // c son comillas
            String sql = "select APELLIDO,FUNCION,SALARIO from PLANTILLA where FUNCION="+c+funcionHospital+c;
            // Linea de abajo solo para ver como sale el SELECT
            System.out.println(sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String apellido = rs.getString("APELLIDO");
                String funcion = rs.getString("FUNCION");
                String salario = rs.getString("SALARIO");
                System.out.println("Apellido: "+apellido);
                System.out.println("Funcion: "+funcion);
                System.out.println("Salario: "+salario);
            }
            rs.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error telible");
        }
    }
}
