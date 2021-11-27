package BussinessLogicLayer;

import java.util.*;

import DataLayer.DoubleLinkedList;
import DataLayer.DynamicArray;
import DataLayer.Negocio;
import UILayer.Menu;
import UILayer.UIAuxiliar;

import java.util.*;

public class Test {
  
  private DoubleLinkedList list;
  private DynamicArray list1;

  public Test(DoubleLinkedList list,DynamicArray list1) {
    
	UIAuxiliar.clearScreen();

    this.list = list;
    this.list1 = list1;
    this.display();
  }


  public void display() {
    System.out.println("\nIngresa el numero de elementos a agregar (-1 para volver al menú):");

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();


    if(n > 0) {
      UIAuxiliar.clearScreen();
      this.testing(n);
    }
    Menu menu = new Menu(list,list1);
  }

  public void testing(int n) {
    
    //DoubleLinkedList list = new DoubleLinkedList();
    long startTime = System.nanoTime();
    for(int i = 0 ; i < n ; i++) {  
      String currentName = "Negocio"+i;
      String currentClave = "clave"+i; 
      
      Negocio current = new Negocio(currentName, currentClave);
      
      list.add(current);
    }
    long endTime = System.nanoTime() - startTime ;

    System.out.println("Se agregaron " + n + " elementos a la lista doblemente enlazada!!!");
    
    //Conversion de nanosegundos a segundos
    double secTime = endTime / 1000000000.0;
    System.out.println("El tiempo de inserción es: "+String.format("%.6f", secTime)+" (s)");
    System.out.println("La lista tiene ahora " + list.getSize() + " elementos. \n");
    
    System.out.println("#=========================================#");
    //Arraglo dinamico
    long startTime1 = System.nanoTime();
    for(int i = 0 ; i < n ; i++) {
      String currentName = "Negocio"+i;
      String currentClave = "clave"+i; 

      Negocio current = new Negocio(currentName, currentClave);
      
      list1.insert(current);
    }
    long endTime1 = System.nanoTime() - startTime ;

    System.out.println("Se agregaron " + n + " elementos al array dinamico!!!");
    System.out.println("La lista dinamica tiene ahora " + list1.size() + " elementos.");
    
    //Conversion de nanosegundos a segundos
    double secTime1 = endTime1 / 1000000000.0;
    System.out.println("El tiempo de inserción es: "+String.format("%.6f", secTime1)+" (s)");
    System.out.println("La lista dinamica tiene ahora " + list1.size() + " elementos. \n");
    System.out.println();
    
    Scanner scan = new Scanner(System.in);
    
    UIAuxiliar.continueRequest();

    // Testeando busqueda
    Menu menu = new Menu(list,list1);
  }

}