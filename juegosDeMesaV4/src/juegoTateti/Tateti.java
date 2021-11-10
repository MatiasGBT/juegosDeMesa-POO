package juegoTateti;

public class Tateti {
	Ficha tablero[][]=new Ficha[3][3];
	boolean gan=false;
	
	public boolean victoria(Jugador j) {
		Ficha res=j.ficha;
		
		//ascendente
		if (tablero[2][0]!=null && tablero[1][1]!=null && tablero[0][2]!=null) {
			if (tablero[2][0].ficha.equalsIgnoreCase(tablero[1][1].ficha) &&
					tablero[1][1].ficha.equalsIgnoreCase(tablero[0][2].ficha)) {
				if (tablero[1][1].ficha.equalsIgnoreCase(res.ficha)) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		//descendente
		if (tablero[0][0]!=null && tablero[1][1]!=null && tablero[2][2]!=null) {
			if (tablero[0][0].ficha.equalsIgnoreCase(tablero[1][1].ficha) &&
					tablero[1][1].ficha.equalsIgnoreCase(tablero[2][2].ficha)) {
				if (tablero[1][1].ficha.equalsIgnoreCase(res.ficha)) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		//filas
		for (int f = 0; f < tablero.length; f++) {
			if (tablero[f][0]!=null && tablero[f][1]!=null && tablero[f][2]!=null) {
				if (tablero[f][0].ficha.equalsIgnoreCase(tablero[f][1].ficha) &&
						tablero[f][1].ficha.equalsIgnoreCase(tablero[f][2].ficha)) {
					if (tablero[f][1].ficha.equalsIgnoreCase(res.ficha)) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		
		//columnas
		for (int c = 0; c < tablero.length; c++) {
			if (tablero[0][c]!=null && tablero[1][c]!=null && tablero[2][c]!=null) {
				if (tablero[0][c].ficha.equalsIgnoreCase(tablero[1][c].ficha) &&
						tablero[1][c].ficha.equalsIgnoreCase(tablero[2][c].ficha)) {
					if (tablero[1][c].ficha.equalsIgnoreCase(res.ficha)) {
						return true;
					} else {
						return false;
					}
				}
			}
		}
		return false;
	}
	
	public boolean empate() {
		Jugador emp=new Jugador();
		
		if (tablero[0][0]!=null && tablero[0][1]!=null && tablero[0][2]!=null &&
			tablero[1][0]!=null && tablero[1][1]!=null && tablero[1][2]!=null &&
			tablero[2][0]!=null && tablero[2][1]!=null && tablero[2][2]!=null) {
			
			if (victoria(emp)==false) {
				return true;
			}
		}
		return false;
	}
	
	public void ponerFicha(int f, int c, Ficha fi) {
		if (tablero[f][c]==null) {
			tablero[f][c]=fi;
		} else {
			System.out.println("Jugada inválida");
		}
	}
	
	public void juego(Jugador j) {
		int arr[]=j.jugada();
		if (arr[0]>=0 && arr[1]>=0) {
			ponerFicha(arr[0],arr[1],j.ficha);
		} else {
			System.out.println("Jugada inválida");
		}
	}
	
	public void mostrarTabla() {
		for (int f = 0; f < tablero.length; f++) {
			for (int c = 0; c < tablero.length; c++) {
				if (tablero[f][c]==null) {
					System.out.print("_" + " ");
				} else {
					System.out.print(tablero[f][c].ficha + " ");
				}
			}
			System.out.println();
		}
	}
	
	public void iniciarJuego() {
		Jugador j1=new Jugador();
		j1.datosJug1();
		Jugador j2=new Jugador();
		j2.datosJug2(j1);
		
		do {
			mostrarTabla();
			System.out.println();
			
			juego(j1);
			mostrarTabla();
			System.out.println();
			if (victoria(j1)) {
				System.out.println("Gano " + j1.nombre + ", ¡felicidades!");
				gan=true;
				break;
			}
			
			if (empate()) {
				System.out.println("Empate");
				gan=true;
				break;
			}
			
			juego(j2);
			mostrarTabla();
			System.out.println();
			if (victoria(j2)) {
				System.out.println("Gano " + j2.nombre + ", ¡felicidades!");
				gan=true;
				break;
			}
		} while (gan==false);
	}
}
