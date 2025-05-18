package proyectofinalparcial1;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * //En este programa consiste en una caja regitradora de una tienda pequeña de alimentos
 * @author andre
 */
public class Martinez_Andrea_ProyectoTienda {
     public static void main(String[] args) {
        Scanner texto = new Scanner(System.in).useDelimiter("\\n");

        
         int opcion = 0;
         double efectivo =0 ;
         String sino="";
         boolean cajaabierta = false;

         do{
             //menu 
             System.out.println("\n======================================");
             System.out.println("          --- BIENVENIDO ---          ");
             System.out.println("======================================");

             System.out.printf("Efectivo en la caja: L %.2f%n",efectivo);
             System.out.println("\nSeleccione una de las siguientes categorias.");// bienvenida
             System.out.println("1. Abrir Caja"); 
             System.out.println("2. Ventas");
             System.out.println("3. Compras");
             System.out.println("4. Reportes");
             System.out.println("5. Cierre de Caja");
             System.out.println("6. Salir");
             
             
             boolean entradamenu = false;
             
             while (!entradamenu){
              System.out.print("\nEliga una opcion: ");
             try{
              opcion = texto.nextInt();
              entradamenu = true;

             }catch(Exception e){
             System.out.println("No es valido, ingrese una opcion valida");
             texto.nextLine();

             }}
            
           switch(opcion){
               case 1: //Abrir caja
                 if (cajaabierta== false){
                     System.out.println("\n***** ABRIR CAJA ******");
                     System.out.print("Desea proseguir? (Si/No): ");
                     sino = texto.next().toLowerCase();
                     
                     if (sino.equals("si")) {
                      System.out.println("\nIngrese efectivo para poder abrir a la caja (LPS): ");
                      efectivo = texto.nextDouble();
                      cajaabierta = true;
                     }else {
                         System.out.println("Caja abierta.");
                     }
                 
                   } 
                 break;
                 
               case 2: //ventas
                  
                   System.out.println("\n****** VENTAS ******");
                   
                      double precioproducto = 0;
                      String producto ="";
                      int codigoprodu=0;
                       
                     if (cajaabierta) {
                       System.out.println("Bienvenido al apartado de ventas !");
                       System.out.print("Ingrese el tipo de cliente (A/B/C): ");
                       String TipoClien = texto.next().toLowerCase();

                     if (!TipoClien.equals("a") && !TipoClien.equals("b") && !TipoClien.equals("c")) {
                          System.out.println("\nTipo de cliente no valido.");
                     break;
                        }

                       boolean vender=true;
                       boolean comprobarcodigo=true;

                       while(vender){  
                         System.out.println("\nProductos disponibles:");
                           switch (TipoClien) {
                               case "a":
                                   System.out.println("1. Azucar - $30     2. Avena  - $25");
                                   System.out.println("3. Trigo  - $32     4. Maiz   - $20");
                                   break;
                               case "b":
                                   System.out.println("1. Azucar - $30     2. Avena  - $25");
                                   System.out.println("3. Trigo  - $32");
                                   break;
                               case "c":
                                   System.out.println("4. Maiz   - $20");
                                   break;
                               default:
                                   break;
                           }

                         boolean validarproductocliente =false;


                          while (!validarproductocliente){
                              System.out.print("\nIngrese el codigo del producto: ");
                            try{
                             codigoprodu = texto.nextInt();
                            
                             if (codigoprodu >=1 && codigoprodu<=4){
                                               
                             if (TipoClien.equals("a")){
                                validarproductocliente = true;
                             }else if (TipoClien.equals("b") && codigoprodu>=1 && codigoprodu<=3){
                                validarproductocliente = true;
                             }else if (TipoClien.equals("c") && codigoprodu>=4){
                                validarproductocliente = true;
                             } else {
                              System.out.println("No puede comprar este producto.");
                             }
                             }else {
                              System.out.println("Codigo de producto no valido, ingrese de nuevo los datos");        
                             }
                              }catch(Exception e){
                              System.out.println("Datos invalidos, ingrese de nuevo los datos");
                              texto.nextLine();
                                 }}
                                    
                            System.out.print("Ingrese la cantidad a comprar(kg): ");
                            double kg = texto.nextDouble();
                        
                     
                           System.out.println("\nQuisiera agregar/comprar otro producto?(Si/No)");
                           String sinoventas = texto.next().toLowerCase();
                           if(!sinoventas.equals("si")){
                            vender = false;
                            
                           }
                       }
                     }else{
                           System.out.println("No puede ingresar al apartado de ventas si la caja esta cerrada.");
                               }
                 
                   break;
                   
               case 3: //compras
                   int codproducompra=0;
                   String nombreproducto="";
                   double preciodecompra = 0;
                   boolean puedecomprar = false;
                   
                   System.out.println("\n****** COMPRAS ******");

                     if (cajaabierta==true){
                       System.out.println("Bienvenido al apartado de compras !");  
                       System.out.print("Ingrese el tipo de proveedor (A/B/C): ");
                       String tipoProveedor = texto.next().toLowerCase();

                     if (!tipoProveedor.equals("a") && !tipoProveedor.equals("b") && !tipoProveedor.equals("c")) {
                          System.out.println("\nTipo de proveedor no valido.");
                     break;
                        }
                     
                     boolean comprar=false;
                   
                        while(!comprar){  
                              
                         System.out.println("\nProductos disponibles por cada proveedor:");
                           switch (tipoProveedor) {
                               case "a":
                                   System.out.println("1. Azucar - 25     4. Maiz  - $18");
                                   break;
                               case "b":
                                   System.out.println("2. Avena - 20     3. Trigo  - $30");
                                   break;
                               case "c":
                                   System.out.println("2. Avena - 20");
                                   break;
                               default:
                                   break;
                           } 
                           
                         boolean validarproductoproveedor =false;
                        while(!validarproductoproveedor){  

                         System.out.print("\nIngrese el codigo del producto:");
                         try{
                           codproducompra = texto.nextInt();
                         if (codproducompra >=1 && codproducompra<=4){
                              validarproductoproveedor =true;                                    
                         }else{
                            System.out.println("Datos invalidos, ingrese de nuevo los datos");

                         }
                          
                         }catch(Exception e){
                             System.out.println("Codigo invalido");
                             System.out.print("Ingrese el codigo del producto:");
                             texto.next();
                         }

                        }

                         switch (codproducompra){
                             case 1:
                                 if(tipoProveedor.equals("a")){
                                 puedecomprar = true;
                                 preciodecompra= 25;
                                 nombreproducto = "Azucar";
                                 comprar = true;
                                 }else{
                                    System.out.println("El proveedor no ofrece Azucar");
                                 }
                                break;
                            case 2:
                                 if(tipoProveedor.equals("b")){
                                 puedecomprar = true;
                                 preciodecompra= 20;
                                 nombreproducto = "Avena";
                                 comprar = true;
                                 }else if (tipoProveedor.equals("c")){
                                 puedecomprar = true;
                                 preciodecompra= 22;
                                 nombreproducto = "Avena";
                                 comprar = true;
                                 }else {
                                     System.out.println("El proveedor no ofrece Avena");
                                 }
                                break;
                             case 3:
                                 if(tipoProveedor.equals("b")){
                                 puedecomprar = true;
                                 preciodecompra= 30;
                                 nombreproducto = "Trigo";
                                 comprar = true;
                                 }else{
                                    System.out.println("El proveedor no ofrece Trigo");
                                 }
                                break;
                              case 4:
                                 if(tipoProveedor.equals("a")){
                                 puedecomprar = true;
                                 preciodecompra= 18;
                                 nombreproducto = "Maiz";
                                 comprar = true;
                                 }else{
                                    System.out.println("El proveedor no ofrece Maiz");
                                 }
                                break;
                         }
                         
                         
                              }
                        
                      
                   } else {
                       System.out.println("No puedes ingresar a este apartado si no abres la caja");
                   
                   }
                     break;
                case 4: //reportes
                     if (cajaabierta==true){
                       System.out.println("\n******* REPORTES ******");
                      
                   } else {
                       System.out.println("No puedes ingresar a este apartado si no abres la caja");
                   
                   }
                     break;
                     
               case 5://cerrar caja
                    if (cajaabierta==true){
                        
                        
                        
                       System.out.println("\n******* CIERRE DE CAJA  ******");
                        System.out.printf("Actualmente tiene en la caja una cantidad de: %.2f%n " ,efectivo);

                       System.out.println("Esta seguro de cerrar la caja? (Si/No)");
                     sino = texto.next().toLowerCase();
                       
                     if (sino.equals("si")) {
                           cajaabierta = false;
                     }
                      
                   }else{
                        System.out.println("La caja esta cerrada.");
                    
                    }
                    
                    
                    break;

               case 6: //salir del sistema 
                   System.out.println("Saliendoo del sistema.");
                   break;
           }
             
         }while (opcion!=6);
         
}
}
