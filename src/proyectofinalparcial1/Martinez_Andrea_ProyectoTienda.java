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
         double efectivo =0, efectivoingresado =0; ;
         String sino="", estadodecaja ="";
         boolean cajaabierta = false, reaabrir=false;
         int contadorventas=0, contadorcompras = 0;
         int contadorazucar=0, contadormaiz=0, contadoravena=0, contadortrigo=0;
         int disponibleazucar = 0, disponiblemaiz =0, disponibleavena=0, disponibletrigo =0, disponible=0;
         int ventakgdeazucar = 0, ventakgdeavena=0, ventakgdetrigo=0, ventakgdemaiz=0;
         double ventamayor=0, compramayor =0, totaldeventas=0, totaldecompras=0;


         do{
             //menu 
             System.out.println("\n======================================");
             System.out.println("            ---  MENU  ---            ");
             System.out.println("======================================");

             System.out.printf("Efectivo en la caja: L %.2f%n",efectivo);
             System.out.println("\nSeleccione una de las siguientes categorias.");// bienvenida
             System.out.println("1. Abrir Caja"); 
             System.out.println("2. Ventas");
             System.out.println("3. Compras");
             System.out.println("4. Reportes");
             System.out.println("5. Cierre de Caja");
             System.out.println("6. Salir");
             
             String opcionmenu = "";
             boolean entradamenu = false;
             
             while (!entradamenu){
              System.out.print("\nEliga una opcion: ");
              opcionmenu = texto.next();
              if (opcionmenu.equals("1")){
                  opcion =1;
                  entradamenu = true;
              }else if(opcionmenu.equals("2")){
                  opcion =2;
                  entradamenu = true;
              }
              else if (opcionmenu.equals("3")){
                  opcion =3;
                  entradamenu = true;}
              else if (opcionmenu.equals("4")){
                  opcion =4;
                  entradamenu = true;}
              else if (opcionmenu.equals("5")){
                  opcion =5;
                  entradamenu = true;}
              else if (opcionmenu.equals("6")){
                  opcion =6;
                  entradamenu = true;}
              else{
             
             System.out.println("Datos invalidos, ingreselos de nuevo.");
             texto.nextLine();

             }}
            
           switch(opcion){
               case 1: //Abrir caja
                     System.out.println("\n***** ABRIR CAJA ******");
                     System.out.println("Estado de caja actualmente: " +estadodecaja);
                       if (cajaabierta==false){
                        estadodecaja="Cerrada."; 
                        System.out.println("\nIngrese efectivo para poder abrir a la caja (LPS): ");
                        efectivoingresado = texto.nextDouble();  
                        if (efectivoingresado>0){
                          efectivo += efectivoingresado;
                          
                          if(cajaabierta == false){
                             cajaabierta = true;
                              System.out.println("\nCaja abierta.");
                              estadodecaja ="Abierta";

                          }
                          System.out.println("Se agrego el efectivo.");
                          
                      }
                     System.out.print("Desea agregar efectivo a la caja? (Si/No): ");
                     sino = texto.next().toLowerCase();
                      }
                     else if(cajaabierta == true){
                         System.out.println("La caja ya esta abierta.");

                     }else{
                         System.out.println("No se puede abrir la caja.");
                          estadodecaja ="Cerrada";

                     }
   
                 break;
                 
               case 2: //ventas
                  
                   System.out.println("\n****** VENTAS ******");
                   
                      double precioproducto = 0;
                      String producto ="";
                      int codigoprodu=0;
                      boolean puedevender = false;
                      String nombreprodu = "", productosfactura="";
                      double precioventas=0;
                      double totalapagarventas =0, totalapagar=0;
                      double subtotal=0;
                      double descuento=0;
                      double impuesto=0;
                      double kg = 0;
                   
                      
                     if (cajaabierta) {
                          if(contadorazucar==0 && contadoravena==0 && contadormaiz==0 && contadortrigo==0){
                         System.out.println("No hay ningun producto disponible."); 
                         continue;
                     }
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
                                   System.out.println("1. Azucar - L.30     2. Avena  - L.25");
                                   System.out.println("3. Trigo  - L.32     4. Maiz   - L.20");
                                   break;
                               case "b":
                                   System.out.println("1. Azucar - L.30     2. Avena  - L.25");
                                   System.out.println("3. Trigo  - L.32");
                                   break;
                               case "c":
                                   System.out.println("4. Maiz   - L.20");
                                   break;
                               default:
                                   break;
                           }

                         boolean validarproductocliente =false;


                          while (!validarproductocliente){
                              System.out.print("\nIngrese el codigo del producto: ");
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
                              }
                          
                           switch (codigoprodu){
                               case 1: 
                                   if(TipoClien.equals("a") || TipoClien.equals("b")){
                                   puedevender = true;
                                   nombreprodu = "Azucar";
                                   disponible = contadorazucar;
                                   precioventas = 30;
                                   }
                                   break;   
                               case 2:
                                   if(TipoClien.equals("a") || TipoClien.equals("b")){
                                   puedevender = true;
                                   nombreprodu = "Avena";
                                   disponible = contadoravena;
                                   precioventas = 25;
                                   }
                                   break;
                               case 3:
                                   if(TipoClien.equals("a") || TipoClien.equals("b")){
                                   puedevender = true;
                                   nombreprodu = "Trigo";
                                   disponible = contadortrigo;
                                   precioventas = 32;
                                   }
                                   break;
                               case 4:
                                   if(TipoClien.equals("a") || TipoClien.equals("c")){
                                   puedevender = true;
                                   nombreprodu = "Maiz";
                                   disponible = contadormaiz;
                                   precioventas = 20;
                                   }
                                   break;
                           }
                           
                                    
                            System.out.print("Ingrese la cantidad a comprar(kg): ");
                             kg = texto.nextDouble();
                        if (kg<=0){
                            System.out.println("Cantidad Invalida.");
                        }else if (disponible < kg){
                            System.out.println("No hay suficiente producto.");
                            System.out.println("Cantidad de kg actualmente: " +disponible);
                        }else{
                            totalapagarventas = kg * precioventas;
                            
                            subtotal+=totalapagarventas;
                            
                            totaldeventas+=totalapagarventas;
                            
                            if (totalapagarventas>ventamayor){
                             ventamayor = totalapagarventas;
                            }
                            productosfactura+= "\n* Producto: " +nombreprodu+ " / Cantidad(kg): " +kg+ " / Precio(c/u): L. " +precioventas+" /  A pagar: "+ totalapagarventas;
                            
                            System.out.println("\nPrecio por kg: " +precioventas);
                            System.out.println("Subtotal: " +subtotal);
                            switch (codigoprodu){
                                case 1: 
                                    contadorazucar -= kg;
                                    ventakgdeazucar += kg;
                                        break; 
                                case 2: 
                                    contadoravena -= kg;
                                    ventakgdeavena += kg;
                                        break;
                                case 3: 
                                    contadortrigo -= kg;
                                    ventakgdetrigo += kg;
                                        break;
                                case 4: 
                                    contadormaiz -= kg;
                                    ventakgdemaiz += kg;
                                        break;
                            }
                        }
                        
                          
                           System.out.println("\nQuisiera agregar/comprar otro producto?(Si/No)");
                           String sinoventas = texto.next().toLowerCase();
                           if(!sinoventas.equals("si")){
                            vender = false;
                           }          
                       }
                            if (subtotal>0){
                               if(subtotal>=5000){
                               descuento = subtotal*0.10;
                               }else if(subtotal>1000){
                               descuento = subtotal * 0.05;
                               }else if (subtotal<1000){
                               descuento = 0;
                               }
                               contadorventas++;
                               impuesto = (subtotal-descuento)*0.07;
                               totalapagar = subtotal - descuento + impuesto;
                               System.out.println("\n=== FACTURA ===");
                                System.out.println("Detalles:");
                                System.out.println(productosfactura);
                                
                               System.out.printf("Subtotal: L. %.2f%n" ,subtotal);
                               if (descuento>0){
                                System.out.println("Descuento:" +descuento);
                               }else {
                                System.out.println("Descuento: No aplica un descuento");
                               }
                                System.out.printf("Impuesto: L. %.2f%n" ,impuesto);
                                System.out.printf("Total a Pagar: L. %.2f%n" ,totalapagar);
                                
                                efectivo += subtotal;
                           }else {
                               System.out.println("No se hizo alguna venta.");
                           }
                     } else{
                           System.out.println("No puede ingresar al apartado de ventas si la caja esta cerrada.");
                               }
                 
                   break;
                   
               case 3: //compras
                   int codproducompra=0;
                   boolean puedecomprar = false;
                   double kgcompras =0,totalcompra=0;
                   String nombreproducto="";

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
                                   System.out.println("1. Azucar - L.25     4. Maiz  - L.18");
                                   break;
                               case "b":
                                   System.out.println("2. Avena - L.20     3. Trigo  - L.30");
                                   break;
                               case "c":
                                   System.out.println("2. Avena - L.20");
                                   break;
                               default:
                                   break;
                           } 
                           
                         boolean validarproductoproveedor =false;
                        while(!validarproductoproveedor){  

                         System.out.print("\nIngrese el codigo del producto:");
                         codproducompra = texto.nextInt();

                         if (codproducompra >=1 && codproducompra<=4){
                              validarproductoproveedor =true;                                    
                         }else{
                            System.out.println("Datos invalidos, ingrese de nuevo los datos");

                         }
                          
                         
                        }
                             double preciodecompra=0;

                         switch (codproducompra){
                             case 1:
                                 if(tipoProveedor.equals("a")){
                                 puedecomprar = true;
                                 preciodecompra= 25;
                                 nombreproducto = "Azucar";
                                 comprar = true;

                                 }else{
                                    System.out.println("El proveedor no vende dicho producto");
                                     comprar = true;
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
                                     System.out.println("El proveedor no vende dicho producto");
                                      comprar = true;
                                 }
                                break;
                             case 3:
                                 if(tipoProveedor.equals("b")){
                                 puedecomprar = true;
                                 preciodecompra= 30;
                                 nombreproducto = "Trigo";
                                 comprar = true;
                                 }else{
                                    System.out.println("El proveedor  no vende dicho producto");
                                     comprar = true;
                                 }
                                break;
                              case 4:
                                 if(tipoProveedor.equals("a")){
                                 puedecomprar = true;
                                 preciodecompra= 18;
                                 nombreproducto = "Maiz";
                                 comprar = true;
                                 }else{
                                    System.out.println("El proveedor  no vende dicho producto");
                                    comprar = true;
                                 }
                                break;
                         }
                         
                         if (puedecomprar){
                         
                            System.out.print("Ingrese la cantidad a comprar(kg): ");
                            kgcompras = texto.nextInt();
                            
                            if (kgcompras <=0){
                                System.out.println("Cantidad Invalida.");
                            }else{
                            
                            totalcompra = kgcompras * preciodecompra;
                            totaldecompras +=totalcompra;
                            if (totalcompra>compramayor){
                                compramayor =totalcompra;
                            }
                            
                            if(totalcompra<= efectivo){
                                efectivo -= totalcompra;
                               switch (codproducompra){
                                    case 1:
                                        contadorazucar+=kgcompras;
                                        break;
                                    case 2:
                                        contadoravena +=kgcompras;
                                        break;
                                    case 3:
                                        contadortrigo += kgcompras;
                                        break;
                                    case 4:
                                        contadormaiz += kgcompras;
                                        break;
                               }
                   
                                
                                System.out.println("\n  Compra realizada con exito. ");
                                System.out.println("\n=== DETALLES: ===");
                                System.out.println("Producto: "+nombreproducto);
                                System.out.println("Precio por kg: " +preciodecompra);
                                System.out.println("Cantidad (kg): " +kgcompras);
                                System.out.println("Total a pagar: " +totalcompra);
                                System.out.println("Efectivo restante: " +efectivo);
                                      contadorcompras++;

                            }else{
                                System.out.println("No se puede pagar la compra");
                            }
                              }}
                        }
                        
                      
                   } else {
                       System.out.println("No puedes ingresar a este apartado si no abres la caja");
                   
                   }
                     break;
                case 4: //reportes
                     if (cajaabierta==true){
                         String productoestrella="Ninguno";
                         double ganancia = totaldeventas - totaldecompras;
                         double promediocompra=0, promedioventa=0;
                         
                         if (contadorventas> 0){
                         promedioventa = totaldeventas / contadorventas;
                         }
                         if (contadorcompras> 0){
                         promediocompra = totaldecompras / contadorcompras;
                         }
                         System.out.println("\n****** REPORTES ******");
                         System.out.printf("Efectivo en la caja actualmente L. %.2f%n" ,efectivo);
                         System.out.println("\nNumero de Ventas realizadas: "+contadorventas);
                         System.out.println("Numero de Compras realizadas: "+contadorcompras);
                         System.out.printf("Volumen Total de las Ventas: L. %.2f%n",totaldeventas);
                         System.out.printf("Volumen Total de las Compras: L. %.2f%n",totaldecompras);
                         System.out.println("Margen de ganancia: "+ganancia);
                         System.out.printf("Valor medio de ventas: L. %.2f%n",promedioventa);
                         System.out.printf("Valor medio de compras: L. %.2f%n",promediocompra);
                         System.out.printf("\nVenta con mayor ganancia: L. %.2f%n",ventamayor);
                         System.out.printf("Compra con mayor ganancia: L. %.2f%n",compramayor);
                         System.out.println("\n  PRODUCTO ESTRELLA ");
                         System.out.println(productoestrella);
                      
                   } else {
                       System.out.println("No puedes ingresar a este apartado si no abres la caja");
                       
                   }
                     break;
                     
               case 5://cerrar caja
                    if (cajaabierta==true){
                        double depositomaximo = efectivo * 0.60, deposito=0;
                         double ganancia = totaldeventas - totaldecompras;
                       System.out.println("\n******* CIERRE DE CAJA  *******");
                        System.out.printf("Actualmente tiene en la caja una cantidad de: L. %.2f%n " ,efectivo);
                        System.out.printf("Margen de ganacia: L. %.2f%n" ,ganancia);
                        
                        System.out.println("\n== DEPOSITAR ==");
                        System.out.println("(Debe de depositar menos o el 60% del efectivo.)");
                        
                       /* System.out.println("Cuanto del efectivo desea depositar en el banco?(Si/No)");
                        sino = texto.next().toLowerCase();*/
                       
                     if (sino.equals("si")) {
                         System.out.printf("\nLo maximo que puede depositar es de: L. %.2f%n",depositomaximo);
                         System.out.println("Ingrese la cantidad que depositara:");
                         deposito = texto.nextDouble();
                         
                         if (deposito <=depositomaximo && deposito >0){
                         efectivo -= deposito;
                             System.out.printf("El deposito que se realizo fue de: L. %.2f%n",deposito);
                             System.out.printf("Efectivo restante: L. %.2f%n",efectivo);
                         }else{
                             System.out.println("No puede depositar esta cantidad. Intentelo de nuevo.");
                         }
                     }else {
                         System.out.println("No se realizo algun deposito.");
                     } 
                       contadorventas=0;
                       contadorcompras = 0;
                       ventakgdeazucar = 0; 
                       ventakgdeavena=0;
                       ventakgdetrigo=0;
                       ventakgdemaiz=0;
                       ventamayor=0;
                       compramayor =0; 
                       totaldeventas=0;
                       totaldecompras=0;
                       reaabrir = true;
                       cajaabierta = false;
                      System.out.println("Caja cerrada.");

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
