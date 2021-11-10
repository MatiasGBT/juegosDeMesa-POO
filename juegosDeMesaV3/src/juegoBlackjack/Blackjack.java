package juegoBlackjack;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Blackjack {
	public void finalizacion(Jugador j, Jugador c) {
		if (j.tot==21 && c.totc!=21) {
			JOptionPane.showMessageDialog(null,"¡Ganó con Blackjack!\nSumo " + j.tot + " y el " + c.nombre + " "  + c.totc, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/win_bj.gif")));
		} else if (j.tot!=21 && c.totc==21) {
			JOptionPane.showMessageDialog(null,"Perdió con Blackjack\nSumo " + j.tot + " y el " + c.nombre + " "  + c.totc, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/lose_bj.gif")));
		} else if ((j.tot<=20 && j.tot>c.totc) || (j.tot<=20 && c.totc>21)) {
			JOptionPane.showMessageDialog(null,"Ganó\nSumo " + j.tot + " y el " + c.nombre + " " + c.totc, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/win.jpg")));
		} else if ((c.totc<=20 && c.totc>j.tot) || (c.totc<=20 && j.tot>21)) {
			JOptionPane.showMessageDialog(null,"Perdió\nSumo " + j.tot + " y el " + c.nombre + " "  + c.totc, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/lose.jpg")));
		} else if (j.tot>21 && c.totc>21 && j.tot!=c.totc) {
			JOptionPane.showMessageDialog(null,"Empate" + "\nAmbos sumaron más de 21" + "\n" + j.nombre + ": " + j.tot + "\n" + c.nombre + ": " + c.totc, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/draw.jpg")));
		} else if (j.tot==c.totc){
			JOptionPane.showMessageDialog(null,"Empate" + "\nAmbos sumaron " + j.tot, "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/draw.jpg")));
		}
	}
	
	public void iniciarJuego() {
		Jugador j1=new Jugador();
		Jugador c1=new Jugador("Croupier");
		j1.ingresarNombre();
		j1.rellenarMano();
		c1.rellenarMano();
		j1.mostrarCartaInicial(j1, c1);
		c1.valorCroupier();
		if (j1.jugadaTipo1()==false) {
			if (j1.jugadaTipo1()==false) {
				if (j1.tot>=21) {
					finalizacion(j1, c1);
				} else {
					if (j1.jugadaTipo2() || j1.tot>=21) {
						finalizacion(j1, c1);
					} else {
						if (j1.jugadaTipo2() || j1.tot>=21) {
							finalizacion(j1, c1);
						} else {
							finalizacion(j1, c1);
						}
					}
				}
			} else {
				finalizacion(j1, c1);
			}
		} else {
			finalizacion(j1, c1);
		}
	}
}
