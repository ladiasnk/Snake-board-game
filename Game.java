
import java.util.Random;

public class Game {
public int round;
Game(){
	round=0;
}
Game(int l)
{
	round=l;
}
public void Setround(int l) {
	round=l;
}
public int Getround() {
	return round;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Game game=new Game();
	int whowonfirst1=0;
	int whowonfirst2=0;
	int t=0;
	int k=0;

	//aploi metrhtes p me eksipiretoyne sthn while
//tha doyme se ligo ti kanei ayto

		Random r=new Random();
	int	player1firstroll=1+r.nextInt(6);
	int player2firstroll=1+r.nextInt(6);
	Board b=new Board(20,10,3,6,3);
  b.createBoard();
  Player player1=new Player(1,"Nick",0,b);
  Player player2=new Player(2,"John",0,b);
  System.out.println("Welcome to snakes and ladders\t"+player1.getname()+" and "+player2.getname());
  System.out.println("This is your board!\tGood luck!	"+ "\t\t");
  for(int i =0; i<b.getN(); i++)
  {  System.out.println();
	  for(int j=0; j<b.GetM(); j++)
		  System.out.print(b.Gettiles()[i][j]+"\t");}
	System.out.println("\t\t\t\t");
  b.createElementBoard();
  System.out.println(player1.getname()+" 's first roll was "+player1firstroll);
  System.out.println(player2.getname()+" 's first roll was "+player2firstroll);
  int player1id=b.tiles[b.getN()-1][0];
  int player2id=b.tiles[b.getN()-1][0];
  if(player1firstroll>player2firstroll)
  { //blepw poios paizei prwtos kanei kinhsh,meta kanei kai o allos kai
	  //synexizei h diadikasia,aytos p termatizei prwtos tha apothikeytei 
	  //kai AN kai oi dio termatisoyn me idio score tha einai o nikhths
	  //tha doyme parakatw pws to epitigxanw ayto
	  System.out.println("So "+player1.getname()+" goes first");
	  int random1 = r.nextInt(6)+1;
	  player1id =  player1.move(1, random1)[0];
	  
	  
	  int random2=r.nextInt(6)+1;
	  player2id=player2.move(1, random2)[0];

	  game.Setround( game.Getround()+1);
	  while(player1id<b.getN()*b.GetM() && player2id<b.getN()*b.GetM()) {
		  int die1=r.nextInt(6)+1;
		  int die2=r.nextInt(6)+1;
		  if(player1id<b.GetM()*b.getN())
		  player1id=player1.move( player1id , die1)[0];
		  else
			  t=whowonfirst1;
		 

		  if(player2id<b.GetM()*b.getN())
	player2id=	   player2.move(player2id, die2)[0];
		  else
			  k=whowonfirst2;
		 
		
		  game.Setround( game.Getround()+1);
	   t++;
	   k++;
	  }
	  
  }
  
  else
  {
	  System.out.println("So "+player2.getname()+" goes first");
  int random1=r.nextInt(6)+1;
  //idia logikh blepw poios paei prwtos kai kanei kinhsh meta kai o allos
  //kai meta ginetai epanalipsi
  //akribws ta idia apla o allos epaikse prwtos twra
  player2id=player2.move(1, random1)[0];
 
  
  int random2=r.nextInt(6)+1;
player1id=  player1.move(1, random2)[0];

  game.Setround( game.Getround()+1);
 while(player1id<b.getN()*b.GetM() && player2id<b.getN()*b.GetM()) {
	  int die1=r.nextInt(6)+1;
	  int die2=r.nextInt(6)+1;
	  if(player2id<b.GetM()*b.getN())
	    player2id=player2.move( player2id , die1)[0];
	  else
	  k=whowonfirst1;

	  if(player1id<b.GetM()*b.getN())
          player1id= player1.move(player1id, die2)[0];
	  else
		  t=whowonfirst2;
	 

	  game.Setround( game.Getround()+1);
    t++;
    k++;
  }
 
 
  }
  //twra blepoyme poios nikhse..nikaei aytos p teleionei me megalytero score
  //enw an teliosane me idio score
  //edw einai p xrhsimepsan ta whowonfirst kai kserw poio
  //einai mikrotero kai ara poios nikhse prwtos
  if( player1.getscore()>player2.getscore())
  {
	  System.out.println("Well,"+player1.getname()+" wins after "+game.Getround()+" rounds with a score of "+player1.getscore()+"!"+" .Congratulations!");
	  System.out.println(player2.getname()+" finished with "+player2.getscore()+" points."
	  		+ "Next time "+player2.getname()+"...");
  }
  else if( player2.getscore()>player1.getscore())
  {
	  {
		  System.out.println("Well,"+player2.getname()+" wins after "+game.Getround()+" rounds with a score of "+player2.getscore()+" ! .Congratulations!");
		  System.out.println(player1.getname()+" finished with "+player1.getscore()+" points."
		  		+ " Next time "+player1.getname()+"...");
	  } 
	  
  }
  else if(whowonfirst1<whowonfirst2) {
	  System.out.println("Well,"+player1.getname()+" wins after "+game.Getround()+" rounds with a score of "+player1.getscore()+"!"+" .Congratulations!");
	  System.out.println(player2.getname()+" finished with "+player2.getscore()+" points too but he was second."
	  		+ "Next time "+player2.getname()+"...");
  }
  else 
  {
	  System.out.println("Well,"+player2.getname()+" wins after "+game.Getround()+" rounds with a score of "+player2.getscore()+" ! .Congratulations!");
	  System.out.println(player1.getname()+" finished with "+player1.getscore()+" points too but he was second."
	  		+ " Next time "+player1.getname()+"...");
  }
  
	  
  
	}

}
