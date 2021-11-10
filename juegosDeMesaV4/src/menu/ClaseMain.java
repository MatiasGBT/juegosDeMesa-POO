package menu;

import javax.swing.JOptionPane;

public class ClaseMain {

	public static void main(String[] args) {
		String res;
		
		do {
			int elec=Integer.parseInt(JOptionPane.showInputDialog("Ingresa el juego que queres jugar:\n1-Tateti (2 jugadores)\n2-Blackjack (1 jugador)"));
			
			switch (elec) {
			case 1:
				juegoTateti.ClaseMain.main(null);;
				break;
				
			case 2:
				
				break;

			default:
				break;
			}
			
			res=JOptionPane.showInputDialog("¿Quieres volver a jugar? si/no");
		} while (res.equalsIgnoreCase("si"));


	}

}
