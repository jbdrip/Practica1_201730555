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
    public static void DificultadDelJuego (){
        Scanner in = new Scanner(System.in);
        int op=0;
        while(op!=3){
        limpiar_pantalla(8);
        System.out.println("Dificultad del juego\n\n 1. Fácil\n 2. Difícil\n 3. Regresar\n");
        System.out.println("Elige una opción: ");
        op=in.nextInt();
        switch(op){
            case 1:{
                
            }break;
            case 2:{
                
            }break;
        }
        }
        
        
    }   
    public static void ParametrosInciales (){
        Scanner in = new Scanner(System.in);
        int op=0;
        while(op!=3){
        limpiar_pantalla(8);
        System.out.println("Parámetros iniciales\n\n 1. Jugadores\n 2. Subidas y bajones\n 3. Regresar\n");
        System.out.println("Elige una opción: ");
        op=in.nextInt();
        switch(op){
            case 1:{
                
            }break;
            case 2:{
                
            }break;
        }
        }
        
        
    }
    public static void Tablero(int x, int y){
        for (int i=1; i<=x; i++){
        System.out.println("---");
        
        }
        for (int i=1; i<=y; i++){
        System.out.println("---");    
        }
        
    }
    public static void IniciarJuegos (){
        
    }
    
    static void limpiar_pantalla(int espacios){
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
                Tablero(0,0);
            }break;
            case 3:{
                
            }
        }
        }

    }
            
    
    public static void main(String[] args) {
        menu();
    }
    
}
