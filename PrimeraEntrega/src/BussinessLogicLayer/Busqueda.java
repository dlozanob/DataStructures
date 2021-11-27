package BussinessLogicLayer;

import java.util.*;

import DataLayer.DoubleLinkedList;
import DataLayer.DynamicArray;
import DataLayer.Negocio;
import UILayer.Menu;
import UILayer.UIAuxiliar;

public class Busqueda {
  
  private DoubleLinkedList list;
  private DynamicArray list1;

  public Busqueda(DoubleLinkedList list,DynamicArray list1) {
    
	UIAuxiliar.clearScreen();

    this.list = list;
    this.list1 = list1;
    this.display();
  }

  public void display() {
    
    Scanner scan = new Scanner(System.in);
    
    if(list.isEmpty()){
      System.out.println("La lista está vacia\n");
      UIAuxiliar.continueRequest();
      Menu menu = new Menu(list,list1);
    }
    System.out.println("\nDigite el indice del elemento a buscar (-1 para salir):");


    int index = scan.nextInt();

    if (index < 0) {
      Menu menu = new Menu(list,list1);
    }
    if (index >= list.getSize()){
      System.out.println("++El tamaño de la lista es más pequeño que la posición ingresada");  
      display();
    }

    try {
      long startTime = System.nanoTime();
      Negocio element = list.getElement(index); 
      long endTime = System.nanoTime() - startTime ;
      
      UIAuxiliar.clearScreen();
      
      System.out.println("Imprimiendo info para elemento " + index + " utilizando una lista doblemente enlazada \n");
      displayElement(element,endTime);

       System.out.println("#=========================================#");
      //Busqueda en la lista dinamica
      long startTime1 = System.nanoTime();
      Negocio element1 = list1.get(index); 
      long endTime1 = System.nanoTime() - startTime ;
      System.out.println("Imprimiendo info para elemento " + index + " utilizando un arreglo dinamico \n");
      displayElement(element1,endTime1);

      UIAuxiliar.continueRequest();      
      Menu menu = new Menu(list,list1);

    } catch(Exception e) {
      System.out.println("Entrada inválida");
    }

  }
  

  public void displayElement(Negocio element, long timeNano) {
    
	//Conversion de nanosegundos a segundos
    double secTime = timeNano / 1000000000.0;
    System.out.println("INFORMACIÓN:");

    System.out.println("Nombre del negocio:\t" + element.getNombre());
    System.out.println("Clave del negocio:\t" + element.getClave());
    // Tiempo de prueba para busqueda en segundos
    System.out.println("El tiempo de busqueda es: "+String.format("%.6f", secTime)+" (s)");
    System.out.println();

  }

}