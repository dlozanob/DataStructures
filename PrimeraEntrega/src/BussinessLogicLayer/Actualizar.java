package BussinessLogicLayer;

import java.util.*;

import DataLayer.DoubleLinkedList;
import DataLayer.DynamicArray;
import UILayer.Menu;
import UILayer.UIAuxiliar;

public class Actualizar {
  
  private DoubleLinkedList list;
  private DynamicArray list1;
  
  public Actualizar(DoubleLinkedList list,DynamicArray list1){
    
	UIAuxiliar.clearScreen();

    this.list = list;
    this.list1 = list1;
    this.Display();
  }
  public void Display(){
    
	  if(list.isEmpty()) {
      System.out.println("La lista está vacia\n");
      UIAuxiliar.continueRequest();
      Menu menu = new Menu(list,list1);
    }
	  
    System.out.println("\nDigite el indice del elemento a Actualizar (-1 para salir):");

    Scanner scan = new Scanner(System.in);

    int index = scan.nextInt();
    if (index < 0){
      Menu menu = new Menu(list,list1);
    }else if (index >= list.getSize()){
      System.out.println("++El tamaño de la lista es más pequeño que la posición ingresada");
      Display();
    }
    

    UIAuxiliar.clearScreen();

    System.out.println("\nDigite 1 para actualizar el nombre o 2 para actualizar la clave (-1 para salir):");
    
    int d = scan.nextInt();
    
    if(d < 0){
      Menu menu = new Menu(list,list1);
    }else if(d > 2){
      System.out.println("Dato Invalido");
      Display();
    }

    UIAuxiliar.clearScreen();

    System.out.println("\nDigite el nuevo valor a ingresar:");
    
    String dato = scan.next();
    
    long startTime;
    long endTime;
    double secTime1 = 0.0;
    double secTime2;
    
    try{
      startTime = System.nanoTime();
      list.Upgrade(index, dato, d);
      endTime = System.nanoTime() - startTime ;
      secTime1 = endTime / 1000000000.0;
    }
    catch(Exception e){
      System.out.println("\nFallo");
    }
    startTime = System.nanoTime();
    list1.Upgrade(index,dato,d);
    endTime = System.nanoTime() - startTime ;
    secTime2 = endTime / 1000000000.0;

    UIAuxiliar.clearScreen();
    
    System.out.println("Nueva lista:\n");
    list1.printArray();
    System.out.println("Tiempo de actualización en arreglo dinamico: "+String.format("%.6f", secTime2)+" (s)");
    System.out.println();
    try{
      list.printList();
      System.out.println("Tiempo de actualización en lista doblemente enlazada: "+String.format("%.6f", secTime1)+" (s)");
    System.out.println();
    }catch(Exception ex){
      System.out.println("not found");
    }
    
    
    UIAuxiliar.continueRequest();
    
    Menu menu = new Menu(list,list1);
  }
}