import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Class06incrementarSalario {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectorString = "jdbc:mysql://localhost:3306/hospital";
            Connection cn = DriverManager.getConnection(connectorString, "root", "root");
            System.out.println("Introduzca el oficio");
            String oficio = read.nextLine();
            System.out.println("Incremento salarial");
            Integer incrementSalario = read.nextInt();
            String sql = "update EMP set SALARIO=SALARIO+"+incrementSalario+" where OFICIO='"+oficio+"'";
            System.out.println(sql);
            Statement st = cn.createStatement();
            int registros = st.executeUpdate(sql);

            // visualizar los cambios

            String sqlVista = "Select * from EMP where OFICIO ='"+oficio+"'";
            cn.createStatement();
            ResultSet rs = st.executeQuery(sqlVista); 
            while (rs.next()){
                String apellido = rs.getString("APELLIDO");
                oficio = rs.getString("OFICIO");
                String salario = rs.getString("SALARIO");
                System.out.println("-----------------");
                System.out.println("Nombre: "+ apellido.toUpperCase());
                System.out.println("Oficio: "+oficio);
                System.out.println("Salario Actualizado: "+salario);
                System.out.println("-----------------");
            }
            cn.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Error nuevo"+e);
        }
    }
}
