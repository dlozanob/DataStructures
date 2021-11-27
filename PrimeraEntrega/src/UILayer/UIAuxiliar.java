package UILayer;

import java.util.Scanner;

public class UIAuxiliar {

	public static void continueRequest() {
      
		Scanner scan = new Scanner(System.in);
		System.out.println("\nDigite cualquier tecla para continuar...");
		try {
		  int input = scan.nextInt();
		} catch (Exception e){
		    try {
		      if(!scan.hasNext()) {
		        scan.nextLine();
		      }
		      String input = scan.nextLine();
		    } catch (Exception e1){
		    }
		}
	}
	
	public static void clearScreen() {
	    System.out.print("\033[H\033[2J");  
	    System.out.flush(); 
	}
	
	
}
