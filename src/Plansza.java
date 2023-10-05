import java.util.Scanner;

public class Plansza {
  int size = 8;
  int InX, InY, OutX, OutY; // koordynaty
 
  Figura [][] planszaGry = new Figura[size][size];
  
  public  boolean Zajete(int x, int y) {
	  if(planszaGry[x][y].symbol != ' ')
		  return true;
	  return false;
  }
   
  public void ZbudujPlansze() {
	  
	  planszaGry[0][0] = new Wieza("Wieza", 'w','B');
      planszaGry[1][0] = new Skoczek("Skoczek", 's', 'B');
      planszaGry[2][0] = new Goniec("Goniec", 'g', 'B');
      planszaGry[3][0] = new Hetman("Hetman", 'h', 'B');
      planszaGry[4][0] = new Krol("Krol", 'k', 'B');
      planszaGry[5][0] = new Goniec("Goniec", 'g', 'B');
      planszaGry[6][0] = new Skoczek("Skoczek", 's', 'B');
      planszaGry[7][0] = new Wieza("Wieza", 'w','B');

      for(int i = 0; i < size; i++){
          planszaGry[i][1] = new Pionek("Pionek", 'p', 'B');
          planszaGry[i][2] = new Pusty("NULL", ' ', 'N');
          planszaGry[i][3] = new Pusty("NULL", ' ', 'N');
          planszaGry[i][4] = new Pusty("NULL", ' ', 'N');
          planszaGry[i][5] = new Pusty("NULL", ' ','N');
          planszaGry[i][6] = new Pionek("Pionek", 'P', 'W');
      }

      planszaGry[0][7] = new Wieza("Wieza", 'W','W');
      planszaGry[1][7] = new Skoczek("Skoczek", 'S', 'W');
      planszaGry[2][7] = new Goniec("Goniec", 'G', 'W');
      planszaGry[3][7] = new Hetman("Hetman", 'H', 'W');
      planszaGry[4][7] = new Krol("Krol", 'K', 'W');
      planszaGry[5][7] = new Goniec("Goniec", 'G', 'W');
      planszaGry[6][7] = new Skoczek("Skoczek", 'S', 'W');
      planszaGry[7][7] = new Wieza("Wieza", 'W','W');
	  
	  
  }
  public  void zrobRuch(){

      planszaGry[OutX][OutY].symbol = planszaGry[InX][InY].symbol;
      planszaGry[OutX][OutY].name = planszaGry[InX][InY].name;
      planszaGry[OutX][OutY].colour = planszaGry[InX][InY].colour;
      planszaGry[InX][InY] = new Pusty("NULL", ' ', 'N');
  }
  
  public boolean LegalnyRuch(){
	  if (planszaGry[InX][InY].symbol == ' ')
		  return false;
	  if (InX > 7 && InX <= 0)
		  return false;
	  if (InY > 7 && InY <= 0)
		  return false;
	  if (OutX > 7 && OutX <= 0)
		  return false;
	  if (OutY > 7 && OutY <= 0)
		  return false;
	  return true;
  }
  
  public void WezRuch(){
	System.out.println("Podaj X figury do ruchu: ");
	@SuppressWarnings("resource")
	Scanner A = new Scanner(System.in);
	InX = A.nextInt();

	System.out.println("Podaj Y figury do ruchu: ");
	InY = A.nextInt();

	System.out.println("Podaj X gdzie ma sie udac: ");
	OutX = A.nextInt();

	System.out.println("Podaj Y gdzie ma sie udac: ");
	OutY = A.nextInt();
  }

  public boolean czyOdpowiedniAtak() {
	  return planszaGry[InX][InY].colour != planszaGry[OutX][OutY].colour;
  }
  
  public boolean czyPrzechodziPrzezWieza()
  {
	  if(planszaGry[InX][InY].symbol == 'w') {
		  for(int a = InY + 1; a< OutY; a++) {
			if(planszaGry[InX][a].colour == 'B')
				return false;
			
		  }
		  for(int a = InY - 1; a> OutY; a--) {
				if(planszaGry[InX][a].colour == 'B')
					return false;
				
			  }
		  for(int a = InX - 1; a> OutX; a--) {
				if(planszaGry[a][InY].colour == 'B')
					return false;
		  }
		  for(int a = InX + 1; a< OutX; a++) {
				if(planszaGry[a][InY].colour == 'B')
					return false;
		  }
		  
		  return true;
	  }
	  if(planszaGry[InX][InY].symbol == 'W') {
		  for(int a = InY + 1; a< OutY; a++) {
			if(planszaGry[InX][a].colour == 'W')
				return false;
			
		  }
		  for(int a = InY - 1; a> OutY; a--) {
				if(planszaGry[InX][a].colour == 'W')
					return false;
				
			  }
		  for(int a = InX - 1; a> OutX; a--) {
				if(planszaGry[a][InY].colour == 'W')
					return false;
		  }
		  for(int a = InX + 1; a< OutX; a++) {
				if(planszaGry[a][InY].colour == 'W')
					return false;
		  }
		  
		  return true;
	  }
	  
	  return true;
  }
  public boolean czyPrzechodziPrzezGoniec()
  {
	  if(planszaGry[InX][InY].symbol == 'g') 
	  {
		  if(OutX>InX && OutY>InY) {
			for(int a = 1; a <(OutX+OutY)/2-1; a++) {
				if(planszaGry[InX+a][InY+a].colour == 'B')
					return false;
			}
		  }
		  if(OutX<InX && OutY>InY) {
			for(int a = 1; a <(OutX+OutY)/2-1; a++) {
				if(planszaGry[InX-a][InY+a].colour == 'B')
					return false;
			}
		  }
		  if(OutX>InX && OutY<InY) {
			for(int a = 1; a <(OutX+OutY)/2-1; a++) {
				if(planszaGry[InX+a][InY-a].colour == 'B')
					return false;
			}
		  }
		  if(OutX<InX && OutY<InY) {
			for(int a = 1; a <(OutX+OutY)/2-1; a++) {
				if(planszaGry[InX-a][InY-a].colour == 'B')
					return false;
			}
		  }
		  return true;
	  }
	  if(planszaGry[InX][InY].symbol == 'G') 
	  {
		  if(OutX>InX && OutY>InY) {
			for(int a = 1; a <(OutX+OutY)/2-1; a++) {
				if(planszaGry[InX+a][InY+a].colour == 'W')
					return false;
			}
		  }
		  if(OutX<InX && OutY>InY) {
			for(int a = 1; a <(OutX+OutY)/2-1; a++) {
				if(planszaGry[InX-a][InY+a].colour == 'W')
					return false;
			}
		  }
		  if(OutX>InX && OutY<InY) {
			for(int a = 1; a <(OutX+OutY)/2-1; a++) {
				if(planszaGry[InX+a][InY-a].colour == 'W')
					return false;
			}
		  }
		  if(OutX<InX && OutY<InY) {
			for(int a = 1; a <(OutX+OutY)/2-1; a++) {
				if(planszaGry[InX-a][InY-a].colour == 'W')
					return false;
			}
		  }
		  return true; 
	  }
	  return true;
  }
 
  public boolean ruchWieza()
  {
	  if(planszaGry[InX][InY].symbol == 'w' || planszaGry[InX][InY].symbol == 'W') {
		  for(int a = 0; a <8; a++)
		  {
			  if(a == OutY && InX == OutX)  //ruch pionowy
				  return true;
			  if(InY == OutY && a == OutX) // ruch poziomy
				  return true;  
		  }
		  return false;
	  }
	  return true;
  }
  public boolean ruchSkoczek()
  {
	  if(planszaGry[InX][InY].symbol == 's' || planszaGry[InX][InY].symbol == 'S') {
		  
		  if(OutX == InX - 2 && OutY == InY - 1)
			  return true;
		  if(OutX == InX - 1 && OutY == InY - 2)
			  return true;
		  if(OutX == InX - 2 && OutY == InY + 1)
			  return true;
		  if(OutX == InX - 1 && OutY == InY + 2)
			  return true;
		  if(OutX == InX + 1 && OutY == InY - 2)
			  return true;
		  if(OutX == InX + 2 && OutY == InY - 1)
			  return true;
		  if(OutX == InX + 2 && OutY == InY + 1)
			  return true;
		  if(OutX == InX + 1 && OutY == InY + 2)
			  return true;
		  return false;
	 }
	 return true;
  }
  public boolean ruchGoniec()
  {
	  if(planszaGry[InX][InY].symbol == 'g' || planszaGry[InX][InY].symbol == 'G')
	  {
		  for(int a = 0; a <8; a++)
		  {
			  if(InY+a == OutY && InX+a == OutX)
				  return true;
			  if(InY+a == OutY && InX-a == OutX)
				  return true;
			  if(InY-a == OutY && InX+a == OutX)
				  return true;
			  if(InY-a == OutY && InX-a == OutX)
				  return true; 
		  }
		  return false;
	  }
	  return true;
  }
  public boolean ruchHetman()
  {
	  if(planszaGry[InX][InY].symbol == 'h' || planszaGry[InX][InY].symbol == 'H')
	  {
		  for(int a = 0; a <8; a++)
		  {
			  
			  //wiezowe ruchy
			  if(a == OutY && InX == OutX)
				  return true;
			  if(InY == OutY && a == OutX)
				  return true;  
			  
			  //goncowe ruchy
			  if(InY+a == OutY && InX+a == OutX)
				  return true;
			  if(InY+a == OutY && InX-a == OutX)
				  return true;
			  if(InY-a == OutY && InX+a == OutX)
				  return true;
			  if(InY-a == OutY && InX-a == OutX)
				  return true; 
		  }
		  return false;
		  
	  }
	  return true;
  }
  public boolean ruchKrol()
  {
	  if(planszaGry[InX][InY].symbol == 'k' || planszaGry[InX][InY].symbol == 'K')
	  {
		  int a = 1;
		  //pionowo/poziome ruchy
		  if (InY == OutY && InX + a == OutX)
			  return true;
		  if (InY == OutY && InX - a == OutX)
			  return true;
		  if (InY + a == OutY && InX == OutX)
			  return true;
		  if (InY - a == OutY && InX + a == OutX)
			  return true;
			  
		  //na ukos ruchy
		  if(InY+a == OutY && InX+a == OutX)
			  return true;
		  if(InY+a == OutY && InX-a == OutX)
			  return true;
		  if(InY-a == OutY && InX+a == OutX)
			  return true;
		  if(InY-a == OutY && InX-a == OutX)
			  return true; 
		  return false;
	  }
	  return true;
  }
  public boolean ruchPionek()
  {
	  if(planszaGry[InX][InY].symbol == 'p')
	  {
		 if(InX == OutX && InY + 2 == OutY && InY + 2 < 4)
			 return true;
		 if(InX == OutX && InY + 1 == OutY)
			 return true;
		 // bicie
		 if (InX-1 >= 0)
		 {
			 if(planszaGry[InX-1][InY+1].colour == 'W' )
				 return true;
		 }
		 if (InX+1 <= 7)
		 {
			 if(planszaGry[InX+1][InY+1].colour == 'W' )
				 return true;
		 }
		 return false;
	  }
	  if(planszaGry[InX][InY].symbol == 'P')
	  {
		 if(InX == OutX && InY - 2 == OutY && InY - 2 > 3)
			 return true;
		 if(InX == OutX && InY - 1 == OutY)
			 return true;
		 //bicie
		 if (InX-1 >= 0) 
		 {
			 if(planszaGry[InX-1][InY-1].colour == 'B' )
				 return true;
		 }
		 if (InX+1 <= 7)
		 {
			 if(planszaGry[InX+1][InY-1].colour == 'B' )
				 return true;
		 }
		 return false;
	  }
	  return true;
  }
}
