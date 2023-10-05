import java.util.Scanner;
public class Gra {

	String p1Name, p2Name;
    Display displayObj = new Display();
    Plansza Plansza = new Plansza();
    public void startGame() {

        displayObj.displayWelcome();
        addPlayers();

        new Gracz(p1Name);
        new Gracz(p2Name);

        Plansza.ZbudujPlansze();
        while(true) {

            displayObj.KogoRuch(p1Name, p2Name);
            displayObj.displayBoard(Plansza);
            Plansza.WezRuch();
            while(!Plansza.LegalnyRuch()) {
                System.out.println("\nNielegalny!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            
            while(!Plansza.czyOdpowiedniAtak()) {
                System.out.println("\nNie atakuj swoich!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            
            while(!Plansza.ruchWieza())
            {
            	System.out.println("\nTak sie nie rusza!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            
            while(!Plansza.ruchSkoczek())
            {
            	System.out.println("\nTak sie nie rusza!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            
            while(!Plansza.ruchGoniec())
            {
            	System.out.println("\nTak sie nie rusza!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            
            while(!Plansza.ruchHetman())
            {
            	System.out.println("\nTak sie nie rusza!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            
            while(!Plansza.ruchKrol())
            {
            	System.out.println("\nTak sie nie rusza!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            
            while(!Plansza.ruchPionek())
            {
            	System.out.println("\nTak sie nie rusza!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            
            while(!Plansza.czyPrzechodziPrzezWieza())
            {
            	System.out.println("\nNie przeskakuj!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            while(!Plansza.czyPrzechodziPrzezGoniec())
            {
            	System.out.println("\nNie przeskakuj!\n");
                displayObj.displayBoard(Plansza);
                Plansza.WezRuch();
            }
            Plansza.zrobRuch();
            displayObj.counter++;
            
            }

        }
    public void addPlayers() {
        System.out.println("Nazwa gracza numer 1: ");
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        p1Name = scanner.nextLine();

        System.out.println("Nazwa gracza numer 2: ");
        p2Name = scanner.nextLine();
    }
}
