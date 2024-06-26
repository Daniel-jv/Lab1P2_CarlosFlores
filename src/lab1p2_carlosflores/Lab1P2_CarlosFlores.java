package lab1p2_carlosflores;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab1P2_CarlosFlores {

    /*
    |¯¯¯  |   |       /\    ¯|       /\    |¯¯¯  ¯¯|¯¯  |¯¯¯  |\  |  ¯¯|¯¯  |¯¯¯|  |    |
    |__   |   |      /  \    |      /  \   |__     |    |---  | \ |    |    |   |  |____|_
    |     |   |___  /¯¯¯¯\   |     /¯¯¯¯\  ___|  __|__  |___  |  \|    |    |___|       |
    */
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
        System.out.println("\nMATRIZ GENERADA: ");
        print(mat);
        tam = tam-1;
        int fix = 0;
        int mat_ord [][] = bublesort(mat, tam, fix);
        System.out.println("\nMATRIZ ORDENADA: ");
        print(mat_ord);
        System.out.println("\nARREGLO DE MEDIANAS: ");
        ArrayList <Integer> array = calc_medianas(mat);
        print_array(array);
        int x = 5;
        array = array_bublesort(array,x);
        System.out.println("\nARREGLO DE MEDIANAS ORDENADO: ");
        print_array(array);
        int LA_MERA_MEDIANA = mediana_FINAL(array);
        System.out.print("\nMEDIANA DE LAS MEDIANAS: "+LA_MERA_MEDIANA);
        
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
    
    public static int [][] bublesort(int [][] mat, int tam, int fix){
        int x = 1000;//ES SOLO PARA ASEGURARME QUE SE ARREGLE AL 100
        while(x > 0){
            for (int i = 0; i < mat.length-1; i++) {
                if(mat[fix][i] > mat[fix][i+1]){
                    int x1 = mat[fix][i];
                    int x2 = mat[fix][i+1];
                    mat[fix][i] = x2;
                    mat[fix][i+1] = x1;
                }
            }
            x--;
        }
        while(tam > fix){
            fix++;
            bublesort(mat,tam,fix);
        }
        return mat;
    }
    
    public static ArrayList calc_medianas(int [][] mat){
        ArrayList <Integer> array = new ArrayList();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(j == (mat.length-1)/2){
                    array.add(mat[i][j]);
                }
            }
        }
        return array;
    }
    
    public static void print_array(ArrayList array){
        for (int i = 0; i < array.size(); i++) {
            System.out.print("["+array.get(i)+"]");
        }
    }
    
    public static ArrayList array_bublesort(ArrayList<Integer> array, int x){
         for (int i = 0; i < array.size()-1; i++) {
             if(array.get(i) > array.get(i+1)){
                  int x1 = array.get(i);
                  int x2 = array.get(i+1);
                  array.set(i, x2);
                  array.set(i+1, x1);
             }
         }
         while(x > 0){
             x--;
             array_bublesort(array,x);
         }
        return array;
    }
    
    //ESTE METODO, OK....
    public static int mediana_FINAL(ArrayList <Integer> array){
        int i = (array.size()-1)/2;
        int x = array.get(i);
        return x;
    }
}
