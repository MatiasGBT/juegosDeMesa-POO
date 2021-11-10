package juegoTateti;

import javax.swing.JOptionPane;

public class Jugador {
	public String nombre;
	public Ficha ficha;
	public int f,c;
	
	/*public Jugador(String nombre, String ficha) {
		this.nombre=nombre;
		this.ficha=new Ficha(ficha);
	}*/
	
	public boolean ingresarDatos() {
		String nombre=JOptionPane.showInputDialog("Ingresa tu nombre jugador 1");
		this.nombre=nombre;
		
		String fichaEleg=JOptionPane.showInputDialog("Decime que ficha queres (X/O)");
		if (!(fichaEleg.equalsIgnoreCase("X") || fichaEleg.equalsIgnoreCase("O"))) {
			
			do {
				JOptionPane.showMessageDialog(null, "Elección inválida, repite");
				fichaEleg=JOptionPane.showInputDialog("Decime que ficha queres (X/O)");
			} while (!(fichaEleg.equalsIgnoreCase("X") || fichaEleg.equalsIgnoreCase("O")));
			
			if (fichaEleg.equalsIgnoreCase("X")) {
				return true;
			} else {
				return false;
			}
			
		} else {
			if (fichaEleg.equalsIgnoreCase("X")) {
				return true;
			} else {
				this.ficha=new Ficha(fichaEleg);
				return false;
			}
		}
	}
	
	public void datosJug1() {
		if (ingresarDatos()) {
			String fichaEleg="X";
			this.ficha=new Ficha(fichaEleg);
		} else {
			String fichaEleg="O";
			this.ficha=new Ficha(fichaEleg);
		}
	}
	
	public void datosJug2(Jugador j) {
		String nombre=JOptionPane.showInputDialog("Ingresa tu nombre jugador 2");
		this.nombre=nombre;
		
		Ficha res=j.ficha;
		if (res.ficha=="X") {
			String fichaEleg="O";
			this.ficha=new Ficha(fichaEleg);
		} else {
			String fichaEleg="X";
			this.ficha=new Ficha(fichaEleg);
		}
	}
	
	
	public boolean posicionFicha() {
		int x=Integer.parseInt(JOptionPane.showInputDialog(nombre + " ingrese la posicion en base al numpad"));
		
		switch (x) {
		case 7: f=0; c=0; break;
		case 8: f=0; c=1; break;
		case 9: f=0; c=2; break;
		
		case 4: f=1; c=0; break;
		case 5: f=1; c=1; break;
		case 6: f=1; c=2; break;
		
		case 1: f=2; c=0; break;
		case 2: f=2; c=1; break;
		case 3: f=2; c=2; break;

		default: return false;
		}
		return true;
	}
	
	public int[] jugada() {
		int array[]=new int[2];
		if (posicionFicha()) {
			array[0]=f;
			array[1]=c;
			return array;
		} else {
			array[0]=-1;
			array[1]=-2;
			return array;
		}
	}
}
