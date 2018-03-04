/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201730555;
import java.util.Scanner;
/**
 *
 * @author Jose
 */
public class Practica1_201730555 {

    /**
     * @param args the command line arguments
     */
    public static int cantJugadores=2; 
    public static String [][] jugadores= new String [3][2];
    public static String [][] tablero= new String [20][10];
    public static String [][] tableromm= new String [20][10];
    public static boolean Dificultad=false;
    public static int subidas=5;
    public static int bajadas=5;
    public static int rangox=0, rangoy=0;
    public static void DificultadDelJuego (){
        Scanner in = new Scanner(System.in);
        int op=0;
        String pausa;
        while(op!=3){
        limpiar_pantalla(8);
        System.out.println("Dificultad del juego\n\n 1. Fácil\n 2. Difícil\n 3. Regresar\n");
        System.out.println("Elige una opción: ");
        op=in.nextInt();
        limpiar_pantalla(9);
        switch(op){
            case 1:{
                Dificultad=false;
                subidas=5; bajadas=5;
                System.out.println("Dificultad FÁCIL seleccionada.\n Jugadores de 2 a 3\n Subidas 5 a 10.\n Bajones 5 a 10.\n Presione Enter para continuar... ");
                pausa=in.nextLine();
                pausa=in.nextLine();
            }break;
            case 2:{
                Dificultad=true;
                subidas=20; bajadas=20;
                System.out.println("Dificultad DIFIÍCIL seleccionada.\n Jugadores de 2 a 3\n Subidas 20 a 40.\n Bajones 20 a 40.\n Presione Enter para continuar... ");
                pausa=in.nextLine();
                pausa=in.nextLine();
            }break;
        }
       }    
    }   
    public static void ParametrosIniciales (){
        Scanner in = new Scanner(System.in);
        int op=0;
        while(op!=3){
        limpiar_pantalla(8);
        System.out.println("Parámetros iniciales\n\n 1. Jugadores\n 2. Subidas y bajones\n 3. Regresar\n");
        System.out.println("Elige una opción: ");
        op=in.nextInt();
        switch(op){
            case 1:{
                do{
                limpiar_pantalla(12);   
                if((cantJugadores!=2)&&(cantJugadores!=3)){
                    System.out.println("Cantidad de jugadores inválida, inténtalo de nuevo");
                }   
                System.out.println("Ingrese la cantidad de jugadores 2-3: ");
                cantJugadores=in.nextInt();    
                }while((cantJugadores!=2)&&(cantJugadores!=3));  
                SimboloJugadores();
            }break;
            case 2:{
                SeleccionarSubidasYBajones();
            }break;
        }
        }
        
        
    }
    public static void NombreDeJugadores (){
        Scanner in = new Scanner(System.in);
        for(int i=0; i<cantJugadores; i++){
                System.out.println("Ingresa el nombre del jugador "+(i+1)+":");
                jugadores[i][0]=in.nextLine();   
        }
 
    }
    public static void SimboloJugadores (){
        Scanner in = new Scanner(System.in);
        for(int i=0; i<cantJugadores; i++){
                limpiar_pantalla(12);
                System.out.println("Ingresa el símbolo del jugador "+(i+1)+":");
                jugadores[i][1]=in.nextLine(); 
                if((jugadores[i][1].equals("$")==true) || (jugadores[i][1].equals("+")==true) || (jugadores[i][1].equals("-")==true)){
                    System.out.println("Símbolo no permitido, inténtalo de nuevo. ");
                    i--;
                    String pausa;
                    System.out.println("Presiona Enter para continuar...");
                    pausa=in.nextLine();
                }
        }
    }
    public static void SeleccionarSubidasYBajones (){
        Scanner in=new Scanner(System.in);
        limpiar_pantalla(12);
        System.out.println("Los parámetros iniciales son:\n Cantidad de subidas: "+subidas+"\nCantidad de bajadas: "+bajadas);
        String pausa;
        System.out.println("Presiona Enter para continuar");
        pausa=in.nextLine();
        int subir1=0, subir2=0;
        if(Dificultad){
            subir1=20; subir2=40;
        }else{
            subir1=5; subir2=10;
        }
        do{
          limpiar_pantalla(12);  
          if((subidas<subir1) || (subidas>subir2)){
              System.out.println("Error en la cantidad de subidas, debe pertenecer al rango de "+subir1+" y "+subir2+"\n Intentalo de nuevo...");
          } 
          System.out.println("Ingresa la cantidad de subidas: ");
          subidas =in.nextInt();
          limpiar_pantalla(12);
          System.out.println("Ingresa la cantidad de bajadas: ");
          bajadas=in.nextInt();
        }while((subidas<subir1) || (subidas>subir2) || (bajadas<subir1) || (bajadas>subir2));
    }
    public static void Tablero(int x, int y){
        int r1=9,r2=0;
        if(Dificultad){
            r2=99;
            
        }
        else{
            r2=0;
           
        }
        for (int f=1; f<=y; f++){
            
                        for (int i=1; i<=x; i++){
                            
                            if(r2!=0){
                                System.out.print("-------");  
                            }
                            else
                            {
                        System.out.print("------");
                            }
                       

                        }
                        System.out.println("");  
                        for (int i=1; i<=x; i++){
                                        if(r2!=0){
                                                if(Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))])>r2){
                                                System.out.print("| "+tablero[(i-1)][((y-1)-(f-1))]+" |");
                                                }
                                            else if(Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))])>r1){
                                                System.out.print("| "+tablero[(i-1)][((y-1)-(f-1))]+"  |");
                                                }  
                                            else
                                            {
                                                System.out.print("|  "+tablero[(i-1)][((y-1)-(f-1))]+"  |");
                                            }
                                       }
                                        else if(Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))])>r1){
                                            System.out.print("| "+tablero[(i-1)][((y-1)-(f-1))]+" |");
                                        }  
                                       
                                        else{
                                            System.out.print("|  "+tablero[(i-1)][((y-1)-(f-1))]+" |");
                                        }
                        }
                        System.out.println(""); 
                        for (int i=1; i<=x; i++){
                            if(r2!=0){
                                System.out.print("|     |");  
                            }
                            else
                            {
                                System.out.print("|    |");  
                            }
                        
                        }
                        System.out.println("");  
                        for (int i=1; i<=x; i++){
                            if(r2!=0){
                                System.out.print("|     |");  
                            }
                            else
                            {
                        System.out.print("|    |");  
                        
                            }
                        }
                         System.out.println("");  
                        for (int i=1; i<=x; i++){
                            if(r2!=0){
                                System.out.print("-------");  
                            }
                            else
                            {
                        System.out.print("------");
                            }
                        }
                        System.out.println(""); 
                }

        
    }
    public static void IniciarJuego (){
        NombreDeJugadores ();
        boolean simbolo=false;
        for(int i=0; i<cantJugadores; i++){
            if(jugadores[i][1]==null){
                simbolo=true;
            }
        }
        if(simbolo){
          SimboloJugadores();  
        }     
    }
    public static void Jugadas(){
        Scanner in = new Scanner(System.in);
        int movimiento=0;
        System.out.println("Jugador "+jugadores[0][0]+"Se mueve "+movimiento+" casillas.");
        System.out.println("Presiona Enter para continuar...");
        String pausa;
        pausa=in.nextLine();
        
    }
    public static void Llenado (){
        boolean lado = false; 
        if(Dificultad){
            rangox=20; rangoy=10;
        }else{
            rangox=5; rangoy=8;
        }
        for(int x=0; x<rangoy; x++){
            for(int y=0; y<rangox; y++){
                if(lado){
                    tablero[((rangox-1)-y)][x]=String.valueOf((y+1)+(x*rangox));
                }else{
                    tablero[y][x]=String.valueOf((y+1)+(x*rangox));
                }
                
            }
            lado=!lado;
        }
        int [][] ab= new int [3][40];
        for (int w=0; w<subidas; w++){
                ab[0][w]= (int)(Math.random()*rangox);
                ab[1][w]= (int)(Math.random()*rangoy);
            for(int r=0; r<w; r++){
             if(((ab[0][w]==ab[0][r])&&(ab[1][w]== ab[1][r]))){
                w--;
             } 
             else if (((ab[0][w]==(ab[0][r]+1))&&(ab[1][w]== ab[1][r]))){
                w--;
             } 
             else if (((ab[0][w]==(ab[0][r]-1))&&(ab[1][w]== ab[1][r]))){
                w--;
             } 
             else if (((ab[0][w]==ab[0][r])&&(ab[1][w]== (ab[1][r]+1)))){
                w--;
             } 
             else if (((ab[0][w]==ab[0][r])&&(ab[1][w]== (ab[1][r])))){
                w--;
             }
            }   
            
            
        }
        for(int s=0; s<subidas; s++){
            System.out.println("La posicion x es: "+ab[0][s]);
            System.out.println("La posicion y es: "+ab[1][s]);
        }
        
        
    }
    public static void limpiar_pantalla(int espacios){
        for (int i=0; i<espacios; i++){
         System.out.println("\n");  
        }      
    }
    public static void menu (){
        Scanner in = new Scanner(System.in);
        int op=0;
        while (op!=4){
        limpiar_pantalla(8);
        System.out.println("Menú principal\n\n 1. Dificultad del juego\n 2. Parámetros iniciales\n 3. Iniciar juego\n 4. Salir\n");
        System.out.println("Elige una opción: ");
        op=in.nextInt(); 
        switch(op){
            case 1:{
                DificultadDelJuego();
            }break;
            case 2:{
                ParametrosIniciales();
            }break;
            case 3:{
                Llenado();
            }
        }
        }

    }
            
    
    public static void main(String[] args) {
        menu();
    }
    
}
