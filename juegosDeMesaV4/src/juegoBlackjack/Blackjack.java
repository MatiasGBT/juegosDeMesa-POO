package juegoBlackjack;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Blackjack {
	public void finalizacion(Jugador j, Jugador c) {
		if (j.tot==21 && c.totc!=21) {
			j.apu=j.apu*3;
			JOptionPane.showMessageDialog(null,"¡Ganó con Blackjack!\n" + j.nombre + " sumo " + j.tot + " y el " + c.nombre + " "  + c.totc + "\nSe quedo con " + j.apu + " dolares.", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/win_bj.gif")));
		} else if (j.tot!=21 && c.totc==21) {
			j.apu=j.apu-j.apu*3;
			JOptionPane.showMessageDialog(null,"Perdió con Blackjack\n" + j.nombre + " sumo " + j.tot + " y el " + c.nombre + " "  + c.totc + "\nSe quedo con " + j.apu + " dolares.", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/lose_bj.gif")));
		} else if ((j.tot<=20 && j.tot>c.totc) || (j.tot<=20 && c.totc>21)) {
			j.apu=j.apu*2;
			JOptionPane.showMessageDialog(null,"Ganó\n" + j.nombre + " sumo "+ j.tot + " y el " + c.nombre + " " + c.totc + "\nSe quedo con " + j.apu + " dolares.", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/win.jpg")));
		} else if ((c.totc<=20 && c.totc>j.tot) || (c.totc<=20 && j.tot>21)) {
			j.apu=j.apu-j.apu*2;
			JOptionPane.showMessageDialog(null,"Perdió\n" + j.nombre + " sumo " + j.tot + " y el " + c.nombre + " "  + c.totc + "\nSe quedo con " + j.apu + " dolares.", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/lose.jpg")));
		} else if (j.tot>21 && c.totc>21 && j.tot!=c.totc) {
			JOptionPane.showMessageDialog(null,"Empate" + "\nAmbos sumaron más de 21" + "\n" + j.nombre + ": " + j.tot + "\n" + c.nombre + ": " + c.totc + "\nLa apuesta se mantiene.", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/draw.jpg")));
		} else if (j.tot==c.totc){
			JOptionPane.showMessageDialog(null,"Empate" + "\nAmbos sumaron " + j.tot + "\nLa apuesta se mantiene.", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
					new ImageIcon(Blackjack.class.getResource("/img/draw.jpg")));
		}
	}
	
	public void iniciarJuego() {
		JOptionPane.showMessageDialog(null,"¡Bienvenido al casino!\nLas reglas del blackjack son las siguientes:"
				+ "\n-Se reparte 1 carta para cada jugador, ambas estarán a la vista.\n"
				+ "Tendrá que elegir si quiere agarrar otra carta, agarrar otra carta y duplicar la apuesta\n(solo en las"
				+ " primeras dos elecciones) o plantarse.\n-El Croupier agarrara cartas hasta tener 16 o más de puntaje"
				+ " (con un máximo de 5 cartas)."
				+ "\n-Gana el jugador que llegue a 21 o más cerca de 21 sin pasarse, si ambos"
				+ " obtienen la misma\npuntuación es empate y la apuesta se mantiene."
				+ "\n-Si ganas por Blackjack (21) ganaras la apuesta por 3. Si pierdes por Blackjack, perderas la apuesta por 3."
				+ "\n-Las figuras valen todas 10 y el As solo vale 1.", "Blackjack - Jugador vs máquina", JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Blackjack.class.getResource("/img/inicio.jpg")));
		
		Jugador j1=new Jugador();
		Jugador c1=new Jugador("Croupier");
		j1.ingresarDatos();
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
