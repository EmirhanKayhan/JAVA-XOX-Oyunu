import java.util.Scanner;

public class XOXOyunum {
static char[][] oyunalani;
public static void main(String[] args) {
		
		Scanner scr = new Scanner(System.in);
		
		oyunalani= new char[3][3];
		
		oyunalani[0][0]=' ';
		oyunalani[0][1]=' ';
		oyunalani[0][2]=' ';
		oyunalani[1][0]=' ';
		oyunalani[1][1]=' ';
		oyunalani[1][2]=' ';
		oyunalani[2][0]=' ';
		oyunalani[2][1]=' ';
		oyunalani[2][2]=' ';

		
		char [][]oyunalanikonumlari = {{'1', '2', '3'},
	      						       {'4', '5', '6'}, 
	      						       {'7', '8', '9'}};
		
		yazdir(oyunalanikonumlari);
		
		while (true) {
			OyuncuX(oyunalani, scr);
			if (oyunSonucu(oyunalani)){
				break;
			}
			yazdir(oyunalani);
			
			OyuncuO(oyunalani, scr);
			if (oyunSonucu(oyunalani)){
				break;
			}
			yazdir(oyunalani);
		}
		scr.close();
	}

	private static boolean kazananKontrol(char[][] oyunalani, char sembol) {
		if ((oyunalani[0][0] == sembol && oyunalani [0][1] == sembol && oyunalani [0][2] == sembol) ||
			(oyunalani[1][0] == sembol && oyunalani [1][1] == sembol && oyunalani [1][2] == sembol) ||
			(oyunalani[2][0] == sembol && oyunalani [2][1] == sembol && oyunalani [2][2] == sembol) ||
			
			(oyunalani[0][0] == sembol && oyunalani [1][0] == sembol && oyunalani [2][0] == sembol) ||
			(oyunalani[0][1] == sembol && oyunalani [1][1] == sembol && oyunalani [2][1] == sembol) ||
			(oyunalani[0][2] == sembol && oyunalani [1][2] == sembol && oyunalani [2][2] == sembol) ||
			
			(oyunalani[0][0] == sembol && oyunalani [1][1] == sembol && oyunalani [2][2] == sembol) ||
			(oyunalani[0][2] == sembol && oyunalani [1][1] == sembol && oyunalani [2][0] == sembol) ) {
			return true;
		}
		return false;
	}
	
		private static boolean oyunSonucu(char[][] oyunalani) {
		
		if (kazananKontrol(oyunalani, 'X')) {	
			yazdir(oyunalani);
			System.out.println("OYUNCU X KAZANDI!!!");
			return true;
		}
		
		if (kazananKontrol(oyunalani, 'O')) {	
			yazdir(oyunalani);
			System.out.println("OYUNCU O KAZANDI!!!");
			return true;
		}
		
		for (int i = 0; i < oyunalani.length; i++) {
			for (int j = 0; j < oyunalani[i].length; j++) {
				if (oyunalani[i][j] == ' ') {
					return false;
				}
			}
		}
		yazdir(oyunalani);
		System.out.println("!!!BERABERE!!!");
		return true;
	}
	
	private static void OyuncuX(char[][] oyunalani, Scanner scanner) {
		String oyuncuGiris;
		while (true) {
			System.out.println("(Oyuncu X) X koymak istedigin yeri gir.(1-9)");
			oyuncuGiris = scanner.nextLine();
			if (yerKontrol(oyunalani, oyuncuGiris)){
				break;
			} else {
				System.out.println("Sadece 1 ve 9 arasindaki bos bir yeri secebilirsin");
			}
		}
		sembolYerlestirme(oyunalani, oyuncuGiris, 'X');
	}
	
	private static void OyuncuO(char[][] oyunalani, Scanner scanner) {
		String oyuncuGiris;
		while (true) {
			System.out.println("(Oyuncu O) O koymak istedigin yeri gir.(1-9)");
			oyuncuGiris = scanner.nextLine();
			if (yerKontrol(oyunalani, oyuncuGiris)){
				break;
			} else {
				System.out.println("Sadece 1 ve 9 arasindaki bos bir yeri secebilirsin");
			}
		}
		sembolYerlestirme(oyunalani, oyuncuGiris, 'O');
	}


	private static boolean yerKontrol (char[][] oyunalani, String yer) {
		switch(yer) {
			case "1":
				return (oyunalani[0][0] == ' ');
			case "2":
				return (oyunalani[0][1] == ' ');
			case "3":
				return (oyunalani[0][2] == ' ');
			case "4":
				return (oyunalani[1][0] == ' ');
			case "5":
				return (oyunalani[1][1] == ' ');
			case "6":
				return (oyunalani[1][2] == ' ');
			case "7":
				return (oyunalani[2][0] == ' ');
			case "8":
				return (oyunalani[2][1] == ' ');
			case "9":
				return (oyunalani[2][2] == ' ');
			default:
				return false;
		}
	}
	
	private static void sembolYerlestirme(char[][] oyunalani, String yer, char sembol) {
		switch(yer) {
			case "1":
				oyunalani[0][0] = sembol;
				break;
			case "2":
				oyunalani[0][1] = sembol;
				break;
			case "3":
				oyunalani[0][2] = sembol;
				break;
			case "4":
				oyunalani[1][0] = sembol;
				break;
			case "5":
				oyunalani[1][1] = sembol;
				break;
			case "6":
				oyunalani[1][2] = sembol;
				break;
			case "7":
				oyunalani[2][0] = sembol;
				break;
			case "8":
				oyunalani[2][1] = sembol;
				break;
			case "9":
				oyunalani[2][2] = sembol;
				break;
			default:
				System.out.println(":(");
		}
	}
			
	private static void yazdir(char[][] oyunalani) {
		System.out.println(oyunalani[0][0] + "|" +  oyunalani[0][1] + "|" +  oyunalani[0][2] );
		System.out.println("-+-+-");
		System.out.println(oyunalani[1][0] + "|" +  oyunalani[1][1] + "|" +  oyunalani[1][2] );
		System.out.println("-+-+-");
		System.out.println(oyunalani[2][0] + "|" +  oyunalani[2][1] + "|" +  oyunalani[2][2] );
	}
	
}
