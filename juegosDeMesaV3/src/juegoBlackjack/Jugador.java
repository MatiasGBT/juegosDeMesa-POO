package juegoBlackjack;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Jugador {
	String nombre, res;
	int n, tot=0, totc=0, x=1;
	Carta array[]=new Carta[5];
	
	public Jugador(String nombre) {
		this.nombre=nombre;
	}
	
	public Jugador() {
		
	}
	
	public void ingresarNombre() {
		String nombre=JOptionPane.showInputDialog("Ingresa tu nombre jugador");
		this.nombre=nombre;
	}
	
	public void rellenarMano() {
		for (int i = 0; i < array.length; i++) {
			array[i]=new Carta((int)(Math.random()*12+1));
			if (array[i].valor==11 || array[i].valor==12) {
				array[i].valor=10;
			}
			System.out.print(array[i].valor + " ");
		}
		tot=tot+array[0].valor;
		System.out.println();
	}
	
	public void mostrarCartaInicial(Jugador j1, Jugador j2) {
		JOptionPane.showMessageDialog(null, "Su carta es: " + j1.array[0].valor + "\nY la del Croupier es: " + j2.array[0].valor, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Jugador.class.getResource("/img/carta" + j1.array[0].valor + ".png")));
	}
	
	public boolean jugadaTipo1() {
		boolean valid;
		do {
			valid=true;
			res=(String)JOptionPane.showInputDialog(null, "¿Qué desea hacer?\n1-Pedir otra carta\n2-Duplicar apuesta\n3-Plantarse", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Jugador.class.getResource("/img/preg.jpg")), null, null);		
			n=Integer.parseInt(res);
			if (n<1 || n>3) {
				JOptionPane.showMessageDialog(null, "Jugada inválida, repita");
				valid=false;
			}
		} while (valid==false);
		
		if (n==1) {
			tot=tot+array[x].valor;
			JOptionPane.showMessageDialog(null, "Su carta es: " + array[x].valor + 
					"\nLa suma es: " + tot, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Jugador.class.getResource("/img/carta" + array[x].valor + ".png")));
			x++;
			return false;
		} else if (n==2) {
			tot=tot+array[x].valor;
			JOptionPane.showMessageDialog(null, "Su carta es: " + array[x].valor + 
					"\nLa suma es: " + tot, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Jugador.class.getResource("/img/carta" + array[x].valor + ".png")));
			return true;
		} else if (n==3){
			return true;
		}
		return false;
	}
	
	public boolean jugadaTipo2() {
		do {
			res=(String)JOptionPane.showInputDialog(null, "¿Qué desea hacer?\n1-Pedir otra carta\n2-Plantarse", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Jugador.class.getResource("/img/preg.jpg")), null, null);		
			n=Integer.parseInt(res);
			if (n<1 || n>2) {
				JOptionPane.showMessageDialog(null, "Jugada inválida, repita");
			}
		} while (n!=1 && n!=2);
		
		if (n==1) {
			tot=tot+array[3].valor;
			x=3;
			JOptionPane.showMessageDialog(null, "Su carta es: " + array[x].valor + 
					"\nLa suma es: " + tot, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Jugador.class.getResource("/img/carta" + array[x].valor + ".png")));
			x++;
			return false;
		} else {
			return true;
		}
	}
	
	public void valorCroupier() {
		totc=array[0].valor;
		if (totc<16) {
			totc=totc+array[1].valor;
			if (totc<16) {
				totc=totc+array[2].valor;
				if (totc<16) {
					totc=totc+array[3].valor;
				}
				if (totc<16) {
					totc=totc+array[4].valor;
				}
			}
		}
		System.out.println(totc);
	}
}
