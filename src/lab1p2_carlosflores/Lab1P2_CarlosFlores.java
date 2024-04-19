package lab1p2_carlosflores;

import java.util.Scanner;
import java.util.Random;

public class Lab1P2_CarlosFlores {

    static Random rand = new Random();
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Ingrese el tamaño de la matriz: ");
        int tam = leer.nextInt();
        while(tam % 2 == 0 || tam < 5){
            System.out.print("ERROR, ingrese el tamaño: ");
            tam = leer.nextInt();
        }
        int [][] mat = create(tam);
        print(mat);
    }
    
    public static int [][] create(int tam){
        int [][] mat = new int [tam][tam];
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                int data = rand.nextInt(9-0)+1-0;
                mat[i][j] = data;
            }
        }
        return mat;
    }
    
    public static void print(int [][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("["+mat[i][j]+"]");
            }
            System.out.println();
        }
    }
    
}
