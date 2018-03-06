/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201730555;
import java.util.Scanner;
/**
 *
 * @author Javier
 */
public class Practica1_201730555 {

    /**
    /**
     * @param args the command line arguments
     */
    public static int cantJugadores=2; 
    public static String [][] jugadores= new String [5][5];
    public static String [][] tablero= new String [20][10];
    public static String [][] tableromm= new String [20][10];
    public static  int [][] ab= new int [3][40];
    public static boolean Dificultad=false;
    public static boolean Ganar=false;
    public static int subidas=5;
    public static int bajadas=5;
    public static int posicionActual=0;
    public static int rangox=0, rangoy=0;
    public static int espacioSubidas=1, espacioBajadas=1;
    
    public static void DificultadDelJuego (){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                jugadores[i][j]=null;
            }
        }
        Scanner in = new Scanner(System.in);
        int op=0;
        String pausa;
        while(op!=3){
        limpiar_pantalla(20);
        System.out.println("Dificultad del juego\n\n 1. Fácil\n 2. Difícil\n 3. Regresar\n");
        System.out.println("Elige una opción: ");
        op=in.nextInt();
        limpiar_pantalla(20);
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
        limpiar_pantalla(20);
        System.out.println("Parámetros iniciales\n\n 1. Jugadores\n 2. Subidas y bajones\n 3. Regresar\n");
        System.out.println("Elige una opción: ");
        op=in.nextInt();
        switch(op){
            case 1:{
                do{
                limpiar_pantalla(20);   
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
                jugadores[0][i]=in.nextLine();   
        }
    }
    public static void SimboloJugadores (){
        Scanner in = new Scanner(System.in);
        for(int i=0; i<cantJugadores; i++){
                limpiar_pantalla(20);
                System.out.println("Ingresa el símbolo del jugador "+(i+1)+":");
                jugadores[1][i]=in.nextLine(); 
                if((jugadores[1][i].equals("$")==true) || (jugadores[1][i].equals("+")==true) || (jugadores[1][i].equals("-")==true)){
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
        limpiar_pantalla(20);
        System.out.println("Los parámetros iniciales son:\n Cantidad de subidas: "+subidas+"\nCantidad de bajadas: "+bajadas);
        String pausa;
        System.out.println("Presiona Enter para continuar");
        pausa=in.nextLine();
        int subir1=0, subir2=0, rangoMax=0;
        if(Dificultad){
            subir1=20; subir2=40; rangoMax=20;
        }else{
            subir1=5; subir2=10; rangoMax=5;
        }
        do{
          limpiar_pantalla(20);  
          if((subidas<subir1) || (subidas>subir2)){
              System.out.println("Error en la cantidad de subidas, debe pertenecer al rango de "+subir1+" y "+subir2+"\n Intentalo de nuevo...");
          } 
          if((espacioSubidas<0) || (espacioSubidas>rangoMax)){
              System.out.println("Error en la cantidad de espacios para avanzar, debe pertenecer al rango de "+1+" y "+rangoMax+"\n Intentalo de nuevo...");
          }
           if((bajadas<subir1) || (bajadas>subir2)){
              System.out.println("Error en la cantidad de bajadas, debe pertenecer al rango de "+subir1+" y "+subir2+"\n Intentalo de nuevo...");
          } 
          if((espacioBajadas<0) || (espacioBajadas>rangoMax)){
              System.out.println("Error en la cantidad de espacios para retroceder, debe pertenecer al rango de "+1+" y "+rangoMax+"\n Intentalo de nuevo...");
          }
          System.out.println("Ingresa la cantidad de subidas: ");
          subidas =in.nextInt();
          limpiar_pantalla(20);
          System.out.println("Ingresa la cantidad de espacios para avanzar: ");
          espacioSubidas=in.nextInt();
          limpiar_pantalla(20);
          System.out.println("Ingresa la cantidad de bajadas: ");
          bajadas=in.nextInt();
          System.out.println("Ingresa la cantidad de espacios para retroceder: ");
          espacioBajadas=in.nextInt();
        }while((subidas<subir1) || (subidas>subir2) || (bajadas<subir1) || (bajadas>subir2) || (espacioSubidas>rangoMax) || (espacioSubidas<0) || (espacioBajadas>rangoMax) || (espacioBajadas<0));
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
                            else{
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
                                boolean jugada=false;
                                 int jugg=0;
                                for (int w=0; w<cantJugadores; w++){
                                    if((Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))]))==(Integer.parseInt(jugadores[2][w]))){
                                    jugada=true;
                                    jugg=w;
                                    }
                                    }
                                if(jugada)
                                {
                                    System.out.print("|   "+jugadores[1][jugg]+ " |");  
                                }
                                else
                                {
                                    System.out.print("|     |");  
                                }
                                  
                            }
                            else
                            {
                                 boolean jugada=false;
                                 int jugg=0;
                                for (int w=0; w<cantJugadores; w++){
                                    if((Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))]))==(Integer.parseInt(jugadores[2][w]))){
                                    jugada=true;
                                    jugg=w;
                                    }
                                    }
                                if(jugada)
                                {
                                    System.out.print("|  "+jugadores[1][jugg]+ " |");  
                                }
                                else
                                {
                                    System.out.print("|    |");  
                                }
                                
                                
                            }
                        
                        }
                        System.out.println("");  
                        for (int i=1; i<=x; i++){
                            if(r2!=0){
                                 boolean baj=false;
                                boolean sub=false;
                                   for (int w=0; w<subidas; w++){
                                   if((Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))]))==ab[0][w]){
                                   sub=true;
                                   }
                                    }
                                   for (int w=0; w<bajadas; w++){
                                   if((Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))]))==ab[1][w]){
                                   baj=true;
                                   }
                                    }
                                   if(Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))])==(rangox*rangoy)){
                                        System.out.print("|  $  |"); 
                                   }
                                   else if(sub){
                                        System.out.print("|  +  |"); 
                                   }
                                   else if(baj){
                                        System.out.print("|  -  |");
                                   }
                                   else{
                                        System.out.print("|     |");  
                                   }
                                 
                            }
                            else
                            {
                                boolean baj=false;
                                boolean sub=false;
                                   for (int w=0; w<subidas; w++){
                                   if((Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))]))==ab[0][w]){
                                   sub=true;
                                   }
                                    }
                                   for (int w=0; w<bajadas; w++){
                                   if((Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))]))==ab[1][w]){
                                   baj=true;
                                   }
                                    }
                                   if(Integer.parseInt(tablero[(i-1)][((y-1)-(f-1))])==(rangox*rangoy)){
                                       System.out.print("|  $ |"); 
                                   }
                                   else if(sub){
                                        System.out.print("|  + |"); 
                                   }
                                   else if(baj){
                                        System.out.print("|  - |");
                                   }
                                   else{
                                       System.out.print("|    |"); 
                                   }
                            
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
            if(jugadores[1][i]==null){
                simbolo=true;
            }
        }
        if(simbolo){
          SimboloJugadores();  
        } 
        Llenado();
        Tablero(rangox,rangoy);
        int pos=0; 
        Ganar=false;
        while(!Ganar){
            boolean simb=false;
            boolean baj=false;
            for(int u=0; u<subidas; u++){
                if(ab[0][u]==Integer.parseInt(jugadores[2][pos])){
                    simb=true;
                }
            }
            for(int u=0; u<bajadas; u++){
                if(ab[1][u]==Integer.parseInt(jugadores[2][pos])){
                    baj=true;
                }
            }
            if(simb){
                SubidasYBajones(pos,false);
            }
            else if(baj){
                SubidasYBajones(pos,true);
            }
            else{
                Jugadas(pos);
            }
            if(Integer.parseInt(jugadores[2][pos])>=(rangox*rangoy)){
                Scanner in = new Scanner(System.in);
                Ganar=true;
                limpiar_pantalla(20);
                System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡Felicidades jugador "+jugadores[0][pos]+" ha ganado!!!!!!!!!!!!!");
                System.out.println("Presiona Enter para continuar...");
                String pausa;
                pausa=in.nextLine();
               
            }
            if(pos==(cantJugadores-1)){
                pos=0;
            }
            else
            {
            pos++;
             }
        }
    }
    public static void Jugadas(int j){
        Scanner in = new Scanner(System.in);
        int movimiento=0, tiro=0;
        if(Dificultad){
            tiro=12;
        }
        else{
            tiro=6;
        }
        movimiento = (int) (Math.random()*tiro)+1;
        System.out.println("Posicion Actual: "+jugadores[2][j]);
        jugadores[2][j]= String.valueOf(Integer.parseInt(jugadores[2][j])+movimiento);
        System.out.println("Jugador "+jugadores[0][j]+" Se mueve "+movimiento+" casillas.");
        System.out.println("Posicion Nueva: "+jugadores[2][j]);
        System.out.println("Presiona Enter para continuar...");
        String pausa;
        pausa=in.nextLine();
        limpiar_pantalla(20);
        Tablero(rangox,rangoy);
    }
    public static void SubidasYBajones(int j,boolean tipo){
        int movimiento=0;
        if(tipo){
            movimiento=-bajadas;
        }
        else{
            movimiento=subidas;
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Posicion Actual: "+jugadores[2][j]);
        if((Integer.parseInt(jugadores[2][j])+movimiento)<0){
            jugadores[2][j]="0";
        }
        else{
         jugadores[2][j]= String.valueOf(Integer.parseInt(jugadores[2][j])+movimiento);   
        }
        System.out.println("Jugador "+jugadores[0][j]+" Se mueve "+movimiento+" casillas por caer en una casilla especial.");
        System.out.println("Posicion Nueva: "+jugadores[2][j]);
        System.out.println("Presiona Enter para continuar...");
        String pausa;
        pausa=in.nextLine();
        limpiar_pantalla(20);
        Tablero(rangox,rangoy);
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
       
        int contador=0;
        for (int w=0; w<subidas; w++){
                ab[0][w]= (int)(Math.random()*((rangox*rangoy)-1))+1; 
                for(int i=0; i<=w; i++){
                    if(ab[0][w]==ab[0][i]){
                        contador++;
                    }
                    if(Math.abs(ab[0][w]-ab[0][i])==1){
                        contador++;
                    }
                }
                if(contador>1){
                    w--;
                }
                contador=0;
        }
        for (int w=0; w<bajadas; w++){
                ab[1][w]= (int)(Math.random()*((rangox*rangoy)-1))+1;
                for(int i=0; i<=w; i++){
                    if(ab[1][w]==ab[1][i]){
                        contador++;
                    }
                    if(Math.abs(ab[1][w]-ab[1][i])==1){
                        contador++;
                                
                    }
                }
                for(int h=0; h<subidas; h++){
                    if(ab[1][w]==ab[0][h]){
                        contador++;
                    }
                    if(Math.abs(ab[1][w]-ab[0][h])==1){
                        contador++;
                    }
                }
                if(contador>1){
                    w--;
                }
                contador=0;
        }
        for(int s=0; s<cantJugadores; s++){
            jugadores[2][s]="0";
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
        limpiar_pantalla(20);
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
                IniciarJuego();
            }
        }
        }

    }
            
    
    public static void main(String[] args) {
        menu();
    }
    
}