package BussinessLogicLayer;

import java.util.*;

import DataLayer.DoubleLinkedList;
import DataLayer.DynamicArray;
import UILayer.Menu;

public class Main {
  public static void main(String[] args) {
    DynamicArray list1 = new DynamicArray();
    DoubleLinkedList list = new DoubleLinkedList();
    
    Menu menu = new Menu(list,list1);

  }
}