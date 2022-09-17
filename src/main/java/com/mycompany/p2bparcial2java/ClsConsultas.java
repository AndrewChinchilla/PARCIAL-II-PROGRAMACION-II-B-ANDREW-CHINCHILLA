
package com.mycompany.p2bparcial2java;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author chinc
 */
//ANDREW HENRY STIVE CHINCHILLA CHINCHILLA 
//0905-21-11296
//PROGRAMACION II B
public class ClsConsultas {
    
    public static void visualizar(){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/comisionesemp?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","Ingeniero2022!");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT * FROM tb_vendedores";
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
            while(resultado.next()){
                System.out.println("-->> VENDEDOR "+resultado.getInt(1)+" <<--");
                 System.out.println("\n");
                System.out.println("No = "+resultado.getInt(1));
                System.out.println("Niv = "+resultado.getInt(2));
                System.out.println("Nombre Vendedor = "+resultado.getString(3));
                System.out.println("Enero = "+resultado.getInt(4));
                System.out.println("Febrero = "+resultado.getInt(5));
                System.out.println("Marzo = "+resultado.getInt(6));
                System.out.println("Abril = "+resultado.getInt(7));
                System.out.println("Mayo = "+resultado.getInt(8));
                System.out.println("Junio = "+resultado.getInt(9));
                System.out.println("\n");
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema:"+ex.getMessage());
        }
}

    public static void consultaniv (){ //CONSULTA 1
        String url = "jdbc:mysql://localhost:3306/comisionesemp?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        int niv;
        try {
            Connection conexion =  DriverManager.getConnection(url,"root","Ingeniero2022!");
            
             Statement sentencia = conexion.createStatement();
             
             Scanner sc = new Scanner(System.in);
             System.out.println("\t>> INGRESE EL NIV QUE DESEA CONSULTAR: ");
             niv = sc.nextInt();
             
              String sql = "SELECT * FROM tb_vendedores Where niv ="+niv;
             
              ResultSet resultado = sentencia.executeQuery(sql);
              
       while(resultado.next()){
                System.out.println("\t\t\t-->> VENDEDOR "+resultado.getInt(1)+" <<--");
                 System.out.println("\n");
                System.out.println("NO\tNIV\tNombreVendedor\tEnero\tFebrero\tMarzo\tAbril\tMayo\tJunio");
                 System.out.println(resultado.getInt(1)+"\t"+resultado.getInt(2)+"\t"+resultado.getString(3)+"\t\t"+resultado.getInt(4)+"\t"+resultado.getInt(5)+"\t"+resultado.getInt(6)+"\t"+resultado.getInt(7)+"\t"+resultado.getInt(8)+"\t"+resultado.getInt(9));
                System.out.println("\n");
                int Total = (resultado.getInt(4)+resultado.getInt(5)+resultado.getInt(6)+resultado.getInt(7)+resultado.getInt(8)+resultado.getInt(9));
                System.out.println("EL TOTAL DE VENTAS DE: "+resultado.getString(3)+" ASCIENDE A: "+Total);
                
            }
        } catch (SQLException ex) {
            System.out.println("Hubo un problema: "+ex.getMessage());
        }
}
    public static void consultaListar(){
        String url = "jdbc:mysql://localhost:3306/comisionesemp?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        int sumaEnero =0, sumaFebrero=0, sumaMarzo=0, sumaAbril=0, sumaMayo=0, sumaJunio = 0,sumaGeneral=0;
        try {
            Connection conexion =  DriverManager.getConnection(url,"root","Ingeniero2022!");
            
             Statement sentencia = conexion.createStatement();
             
              String sql = "SELECT * FROM tb_vendedores";
             
              ResultSet resultado = sentencia.executeQuery(sql);
              System.out.println("\n");
              System.out.println("\n");
              System.out.print("NO.\tNIV\tNOMBRE VENDEDOR\n");
       while(resultado.next()){
                
                 //System.out.print("NO.\tNIV\tNOMBRE VENDEDOR\n"+resultado.getInt(1)+"\t"+resultado.getInt(2)+"\t"+resultado.getString(3));
                 System.out.println(resultado.getInt(1)+"\t"+resultado.getInt(2)+"\t"+resultado.getString(3));
                 sumaEnero +=(resultado.getInt(4));
                 sumaFebrero +=(resultado.getInt(5));
                 sumaMarzo +=(resultado.getInt(6));
                 sumaAbril +=(resultado.getInt(7));
                 sumaMayo +=(resultado.getInt(8));
                 sumaJunio +=(resultado.getInt(9));
              
            }
       System.out.println("\n");
        System.out.println("LA SUMA DE ENERO ES: "+sumaEnero);
         System.out.println("LA SUMA DE FEBRERO ES: "+sumaFebrero);
          System.out.println("LA SUMA DE MARZO ES: "+sumaMarzo);
           System.out.println("LA SUMA DE ABRIL ES: "+sumaAbril);
            System.out.println("LA SUMA DE MAYO ES: "+sumaMayo);
             System.out.println("LA SUMA DE JUNIO ES: "+sumaJunio);
             // System.out.println("LA SUMA DE ENERO ES: "+sumaEnero);
             sumaGeneral = (sumaEnero+sumaFebrero+sumaMarzo+sumaAbril+sumaMayo+sumaJunio);
             
             System.out.println("\n");
             System.out.println("->>> LA SUMA TOTAL DE VENTAS POR SEMESTRE EN CONJUNTO ASCIENDE A LA CANTIDAD DE: > "+sumaGeneral);
        } catch (SQLException ex) {
            System.out.println("\n");
            System.out.println("Hubo un problema: "+ex.getMessage());
        }
    }
    public static void insertar(){
        String url = "jdbc:mysql://localhost:3306/comisionesemp?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        int niv=0,enero=0,febrero=0,marzo=0,abril=0,mayo=0,junio=0;
        String nombre;
         try {
          Connection conexion =  DriverManager.getConnection(url,"root","Ingeniero2022!");
          
          Statement sentencia = conexion.createStatement();
          
          Scanner sc = new Scanner(System.in);
          
          System.out.println("-->> PARA INSERTAR UN NUEVO VENDEDOR POR FAVOR RELLENE LOS SIGUIENTES DATOS: ");
          System.out.println("\n");
          System.out.println("-> INGRESE EL NOMBRE DEL VENDEDOR: ");
          nombre = sc.nextLine();
          System.out.println("-> INGRESE EL NIV DEL VENDEDOR: ");
          niv = sc.nextInt();
          System.out.println("-> INGRESE LA VENTA DEL MES DE ENERO: ");
          enero = sc.nextInt();
          System.out.println("-> INGRESE LA VENTA DEL MES DE FEBRERO: ");
          febrero = sc.nextInt();
          System.out.println("-> INGRESE LA VENTA DEL MES DE MARZO: ");
          marzo = sc.nextInt();
          System.out.println("-> INGRESE LA VENTA DEL MES DE ABRIL: ");
          abril = sc.nextInt();
          System.out.println("-> INGRESE LA VENTA DEL MES DE MAYO: ");
          mayo = sc.nextInt();
          System.out.println("-> INGRESE LA VENTA DEL MES DE JUNIO: ");
          junio = sc.nextInt();
          
          String sql = "INSERT INTO tb_vendedores (niv, NombreVendedor, Enero, Febrero, Marzo, Abril, Mayo, Junio) VALUES ("+niv+",'"+nombre+"',"+enero+","+febrero+","+marzo+","+abril+","+mayo+","+junio+")";
         // System.out.println(sql);
          sentencia.executeUpdate(sql); 
          System.out.println("\n");
          System.out.println("-->> SE HA INGRESADO CORRECTAMENTE");
         }
         catch(SQLException ex) {
            System.out.println("Hubo un problema: "+ex.getMessage());
             
         }
    }
    public static void eliminar(){
        String url = "jdbc:mysql://localhost:3306/comisionesemp?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        int nivElim, opcion;
        try {
          Connection conexion =  DriverManager.getConnection(url,"root","Ingeniero2022!");
          
          Statement sentencia = conexion.createStatement();
             
             Scanner sc = new Scanner(System.in);
             System.out.println("\t>> INGRESE EL NIV DE VENDEDOR PARA SER ELIMINADO: ");
             nivElim = sc.nextInt();
             System.out.println("\t >>> ¡OJO!... ESTA SEGURO QUE DESEA ELIMARLO? ");
             System.out.println("1. SI\t2. NO");
             opcion = sc.nextInt();
             
             switch(opcion){
                 case 1:
                     String sql = "delete from tb_vendedores Where niv = "+nivElim;
                    //System.out.println(sql);
                    sentencia.execute(sql); 
                    System.out.println("\n");
                     System.out.println("\tSE HA ELIMINADO CORRECTAMENTE");
                     System.out.println("\n");

                     break;
                     
                 case 2:
                     System.out.println("\tSERÁ A LA PROXIMA...");
                     System.out.println("\n");
                     menu();
                     break;
             } 
        } catch (SQLException ex) {
            System.out.println("Hubo un problema: "+ex.getMessage());
        }
    }
    
    public static void Actualizar(){
        
          String url = "jdbc:mysql://localhost:3306/comisionesemp?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        int nivActua;
        String newNom;
        try {
          Connection conexion =  DriverManager.getConnection(url,"root","Ingeniero2022!");
          
          Statement sentencia = conexion.createStatement();
             
             Scanner sc = new Scanner(System.in);
           
             System.out.println("\t>> INGRESE EL CAMBIO A REALIZAR (NOMBRE): ");
             newNom = sc.nextLine();
             System.out.println("\t>> INGRESE EL NIV DE VENDEDOR QUE VA ACTUALIZAR: ");
             nivActua = sc.nextInt();
             
            String sql = "update tb_vendedores set NombreVendedor = '"+newNom+"' where niv = "+nivActua;
            
            // System.out.println(sql);
             sentencia.execute(sql); 
             
             System.out.println("\t -->> LOS CAMBIOS HAN SIDO ACTUALIZADOS <<--");
        } catch (SQLException ex) {
            System.out.println("Hubo un problema: "+ex.getMessage());
        }
    }
    
    public static void menu(){
         Scanner scann = new Scanner(System.in);
         int opcion;
         System.out.println("\n");
         System.out.println("\t -->> CONSULTAS A VENDEDORES <<-- ");
         System.out.println("\n");
         System.out.println("\t ELIJA UNA DE LAS OPCIONES:");
         System.out.println("\n");
         System.out.println("[ 1 ] VISUALIZAR DATOS VENDEDORES");
         System.out.println("[ 2 ] CONSULTA POR NIV");
         System.out.println("[ 3 ] CONSULTA VENDEDORES Y TOTALES");
         System.out.println("[ 4 ] INSERTAR NUEVO");
         System.out.println("[ 5 ] ELIMINAR ");
         System.out.println("[ 6 ] ACTUALIZAR");
         System.out.println("[ 7 ] NINGUNA DE LAS ANTERIORES");
         System.out.println("\n");
         
         System.out.println(" -->> SELECCIONE UNA OPCION");
         opcion = scann.nextInt();
         
         switch(opcion){
             case 1:
                 visualizar();
                  System.out.println("\n");
                   System.out.println("\n");
                 System.out.println("... -->> EJECUTADO <<-- ...");
                 System.out.println("\n");
                 menu();
                 break;
             case 2:
                 consultaniv();
                 System.out.println("\n");
                   System.out.println("\n");
                  System.out.println("... -->> EJECUTADO <<-- ...");
                 System.out.println("\n");
                 menu();
                 break;
             case 3:
                 consultaListar();
                 System.out.println("\n");
                   System.out.println("\n");
                  System.out.println("... -->> EJECUTADO <<-- ...");
                 System.out.println("\n");
                 menu();
                 break;
             case 4:
                 insertar();
                 System.out.println("\n");
                   System.out.println("\n");
                  System.out.println("... -->> EJECUTADO <<-- ...");
                 System.out.println("\n");
                 menu();
                 break;
             case 5:
                 eliminar();
                 System.out.println("\n");
                   System.out.println("\n");
                  System.out.println("... -->> EJECUTADO <<-- ...");
                 System.out.println("\n");
                 menu();
                 break;
             case 6:
                 Actualizar();
                 System.out.println("\n");
                   System.out.println("\n");
                  System.out.println("... -->> EJECUTADO <<-- ...");
                 System.out.println("\n");
                 menu();
                 break;
             case 7:
                 System.out.println("\n");
                   System.out.println("\n");
                 System.out.println("... -->> Gracias <<-- ...");
                 System.out.println("\n");
                 System.exit(0);
               
                 break;
                 
         }
    }
    public static void main(String[] args) {
        menu();
        //visualizar();
       // consultaniv();
       // consultaListar();
       //insertar();
       //eliminar();
       //Actualizar();
    }
}
