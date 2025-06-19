// Para el siguiente ejemplo necestiamos mostrar el APELLIDO y el oficio de todos los empleados cuyo departamento sea un número que vamos a .

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class02BuscadorEmpleadosDept {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca número de departamento: ");
        String idDepartamento = teclado.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String conectionString =
                "jdbc:mysql://localhost:3306/hospital";
            Connection cn =
                DriverManager.getConnection
                    (conectionString,"root","root");
            String sql = "select APELLIDO, OFICIO from EMP where DEPT_NO="+idDepartamento;
            System.out.println(sql);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            String apellido = rs.getString("APELLIDO");
            String oficio = rs.getString("OFICIO");
            System.out.println("apellido: "+apellido+" oficio: "+oficio);
        } catch (Exception e) {
            System.out.println("Error gordo: "+e);
        }
    }
}
