package conexion;

import clases.Filtro;
import clases.Operaciones;
import clases.Persona;
import clases.Preguntas;
import clases.Repertorio;
import clases.Respuestas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Consultas {

    //devuelva las respuesta de cada persona de la base de datos
    public void respuestas(int id_persona, Preguntas p       ) {

        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "select r.respuesta\n"
                    + "from PreguntaRespuesta pr INNER JOIN Respuesta r on pr.id_respuesta = r.id_respuesta\n"
                    + "where pr.id_persona = " + id_persona;
            ResultSet rs = sql.executeQuery(consulta);
            Respuestas res = new Respuestas();

            while (rs.next()) {
                res.ingresarRespuesta(rs.getString(1));
            }
            rs.close();
            sql.close();
            p.ingresarPregunta(res);

        } catch (SQLException ex) {
            System.out.println("respuestas" + ex.toString());
        }
    }

    //devuelve la cantidad de personas en la base de datos
    public int cantPersonas() {
        int x = 0;
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "select COUNT(id_persona)\n"
                    + "from Persona";
            ResultSet rs = sql.executeQuery(consulta);

            while (rs.next()) {
                x = rs.getInt(1);
            }

            rs.close();
            sql.close();

        } catch (SQLException ex) {
            System.out.println("cantPersonas" + ex.toString());
        }
        return x;
    }

    //carga las personas de la base de datos al repertorio local
    public void personas(int id_persona, Repertorio r, Preguntas p, Operaciones op) {
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta
                    = "select p.DNI, p.nombres, p.apellidos, DATEDIFF(YEAR,p.fecha_nacimiento,GETDATE()) as edad, r.porcentaje, r.tieneDiabetes, r.fecha, p.imgfoto "
                    + "from Reporte r	INNER JOIN Persona p ON r.id_persona = p.id_persona "
                    + "where p.id_persona = " + id_persona;
            ResultSet rs = sql.executeQuery(consulta);

            while (rs.next()) {
                op.registrarPersona(r, new Persona(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), 
                        rs.getDate(7), rs.getString(8)), p
                );
            }
            rs.close();
            sql.close();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    //agrega la persona a la base de datos
    public void agregarPersona(int id, String dni, String nombres, String apellidos, String fNacimiento, String telefono, String correo, int distrito, String urlFoto) {
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "EXEC RegistrarPersona"
                    + " " + id
                    + ", '" + dni + "'"
                    + ", '" + nombres + "'"
                    + ", '" + apellidos + "'"
                    + ", '" + fNacimiento + "'"
                    + ", '" + telefono + "'"
                    + ", '" + correo + "'"
                    + ", " + distrito
                    + ", '" + urlFoto + "'";

            sql.executeUpdate(consulta);
            sql.close();
            System.out.println("Persona Agregada");
        } catch (SQLException ex) {
            System.out.println("agregar personas " + ex.toString());
        }
    }

    //agrega sus respuestas
    public void agregarRespuestas(int id, int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "EXEC RegistrarRespuestas"
                    + " " + id
                    + ", " + r1
                    + ", " + r2
                    + ", " + r3
                    + ", " + r4
                    + ", " + r5
                    + ", " + r6
                    + ", " + r7
                    + ", " + r8;

            sql.executeUpdate(consulta);
            sql.close();
            System.out.println("Respuestas Agregadas");
        } catch (SQLException ex) {
            System.out.println("agregar respuestas " + ex.toString());
        }
    }

    //genera su reporte
    public void agregarReporte(int id) {
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "EXEC RegistrarReporte " + id;

            sql.executeUpdate(consulta);
            sql.close();
            System.out.println("Reporte Agregado");
        } catch (SQLException ex) {
            System.out.println("error agregar reporte " + ex.toString());
        }
        
    }
    
    //Actualiza la respuesta de la persona
    public void actualizar(int id_persona, int id_pregunta, int id_respuesta) {
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "EXEC Actualizar " + id_persona + ", " + id_pregunta + ", " + id_respuesta;
            sql.executeUpdate(consulta);
            System.out.println("Respuesta Actualizada");
            Conexion.getConexion().close();

        } catch (SQLException ex) {
            System.out.println("actualizar" + ex.toString());
        }
    }
    
    public ArrayList<String> comboDep() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "select departamento from departamentos";
            ResultSet rs = sql.executeQuery(consulta);

            while (rs.next()) {
                lista.add(rs.getString(1));
            }
            rs.close();
            sql.close();

        } catch (SQLException ex) {
            System.out.println("departamentos " + ex.toString());
        }
        return lista;
    }
    
    public ArrayList<String> comboPro() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "select provincia from provincias";
            ResultSet rs = sql.executeQuery(consulta);

            while (rs.next()) {
                lista.add(rs.getString(1));
            }
            rs.close();
            sql.close();

        } catch (SQLException ex) {
            System.out.println("provincia " + ex.toString());
        }
        return lista;
    }
    
    public ArrayList<String> comboDis() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "select distrito from Distritos";
            ResultSet rs = sql.executeQuery(consulta);

            while (rs.next()) {
                lista.add(rs.getString(1));
            }
            rs.close();
            sql.close();

        } catch (SQLException ex) {
            System.out.println("distritos " + ex.toString());
        }
        return lista;
    }
    
    public ArrayList<Filtro> filtro(String tieneDiabetes, String distrito, int edad) {
        ArrayList<Filtro> lista = new ArrayList<>();
        try {
            Statement sql = Conexion.getConexion().createStatement();
            String consulta = "EXEC Filtro '" + tieneDiabetes + "', '" + distrito + "', "+ edad;
            System.out.println(consulta);
            ResultSet rs = sql.executeQuery(consulta);

            while (rs.next()) {
                lista.add(new Filtro(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getString(5), 
                        rs.getInt(6),
                        rs.getString(7)));
            }
            rs.close();
            sql.close();

        } catch (SQLException ex) {
            System.out.println("filtros " + ex.toString());
        }
        return lista;
    }

}
