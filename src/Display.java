import java.util.Scanner;

public class Display {
	
	
	int counter = 1;
	
	
	public void displayBoard(Plansza board){
        System.out.println("        1     2     3     4     5     6     7     8 ");
        char letter = 'A';

        System.out.println("     -------------------------------------------------  ");
        for (int  i = 0; i < board.size; i++){
            System.out.print("  "+ (char)(letter+i)+ " ");
            for(int j = 0; j < board.size; j++){
                System.out.print(" |  " + board.planszaGry[j][i].symbol + " ");
            }
            System.out.print(" |");
            System.out.println("");
            System.out.println("     -------------------------------------------------  ");
            
        }
        System.out.println("W- wieza, g- goniec, s- skoczek, h- hetman, k-krol");
	}
    public void KogoRuch(String name1, String name2){
            if(counter % 2 != 0)
                System.out.println("Teraz " + name1 + " ruch.\n");
            else
                System.out.println("Teraz " + name2 + " ruch.\n");
    }
    public void displayWelcome(){
            System.out.println("Nacisnij Enter zeby zaczac! ");
            @SuppressWarnings("resource")
			Scanner s = new Scanner(System.in);
            s.nextLine();
    }
    public void displayResults(String name){
            if(counter % 2 != 0)
                System.out.println("Gracz " + name + " wygral!\n");
    }
}
