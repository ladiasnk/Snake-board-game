

public class Player {
int playerID;
String name;
int score;
Board board;
//thelw getters kai setters
void setplayerId(int pid) {
	pid=playerID;
}
void setscore(int sc) {
	sc=score;
}
void setname(String n) {
	n=name;
}
int getscore() {
	return score;
}
int getplayerID() {
	return playerID;
}
String getname() {
	return name;
}
void setboard(Board b) {
	board.Setapples(b.Getapples());
	board.Setladders(b.Getladders());
    board.SetN(b.getN());
    board.SetM(b.GetM());
	board.Settiles(b.Gettiles());
	board.Setsnakes(b.Getsnakes());
}
Board getboard() {
	return board;
}
Player(){
	playerID=0;
	name="";
	score=0;
	Board b=new Board();
	board.Setapples(b.Getapples());
	board.Setladders(b.Getladders());
    board.SetN(b.getN());
    board.SetM(b.GetM());
	board.Settiles(b.Gettiles());
	board.Setsnakes(b.Getsnakes());
}

Player(int pid,String n,int sc,Board b){
	
playerID=pid;
name=n;
score=sc;

board = new Board();
board = b;

board.Setapples(b.Getapples());

board.Setladders(b.Getladders());
board.SetN(b.getN());
board.SetM(b.GetM());
board.Settiles(b.Gettiles());
board.Setsnakes(b.Getsnakes());
}

int[] move(int id,int die)
{ 

	//arxika blepoyme an efage h oxi mhlo kai pairnei h xanei pontoys antistoixa
	  int redappleseaten=0;
	  int blackappleseaten=0;
	  int snakebites=0;
	  int laddersused=0;
	int newid=0;
	
	//System.out.println(board.GetM()*board.getN());
	
	  if((id+die)>=board.getN()*board.GetM())
		  {//System.out.println("if");
		  newid = board.getN()*board.GetM();}
	  else
	  { //System.out.println("else");
		  newid=id+die;}
	 // System.out.println("new id is"+newid);
		for(int i=0; i<board.apples.length; i++)
		{
			if(newid==board.apples[i].GetappleTileID() && board.apples[i].Getcolor()=="red")
				{
				score+=board.apples[i].Getpoints();
				board.apples[i].Setpoints(0);
				redappleseaten++;
				if(board.apples[i].Getpoints()!=0)
				System.out.println("Nice!You ate a red apple "+name+" .You got "+ board.apples[i].points+" now!Your current score is "+score);
				}
			else if(newid==board.apples[i].GetappleTileID() && board.apples[i].Getcolor()=="black")
			{	
				score-=board.apples[i].Getpoints();
				board.apples[i].Setpoints(0);
			     blackappleseaten++;
			 	if(board.apples[i].Getpoints()!=0)
			     System.out.println("Oh!You ate a black apple "+name+" .Now you lost"+ board.apples[i].points+" points.Your current score is "+score);
			   }
		}
	//kanw to u>0 apla mono  gia na mpw sthn while
		//edw anebainei sthn skala o paikths ama den einai spasmenh(gt mporei na xrhsimopoih8i mono mia fora h skala
		// kai an den einai meta blepoyme an ekei p brethike eixe mhlo
		int u=1;
		while(u>0) {
			u=0;
			for(int p=0; p<board.ladders.length; p++)
			{	
				 if(board.ladders[p].GetupStepID()==newid )
					{
					 if(board.ladders[p].Getbroken()!=true)
					{
						 
					newid=board.ladders[p].GetdownStepID();
					board.ladders[p].Setbroken(true);
					laddersused++;		
					System.out.println("Good!You climbed a ladder "+name+" ,keep up!");
					u++;
					//edw ensomatwnw ton elegxo me ta mhla oloidio opws einai 
					//gia na doyme an o paikths
					//efage mhlo otan anebhke thn skala,an eixe mhlo sthn koryfh dhladh
					for(int i=0; i<board.apples.length; i++)
					  {
						if(newid==board.apples[i].GetappleTileID() && board.apples[i].Getcolor()=="red")
							{
							score+=board.apples[i].Getpoints();
							board.apples[i].Setpoints(0);
							redappleseaten++;
							if(board.apples[i].Getpoints()!=0)
							System.out.println("Nice!You ate a red apple "+name+" .You got "+ board.apples[i].points+" now!Your current score is "+score);
							}
						else if(playerID==board.apples[i].GetappleTileID() && board.apples[i].Getcolor()=="black")
						{	
							score-=board.apples[i].Getpoints();
							board.apples[i].Setpoints(0);
						     blackappleseaten++;
						 	if(board.apples[i].Getpoints()!=0)
						     System.out.println("Oh!You ate a black apple "+name+" .Now you lost"+ board.apples[i].points+" points.Your current score is "+score);
						   }
					  }
					}
					}
			}
				 
			//akribws to idio me ta fidia,briskei fidi,katebainei sthn oyra,blepw an exei mhlo
			//ekei
				 for(int y=0; y<board.snakes.length; y++)
				 { if(board.snakes[y].GetheadID()==newid)
				 {
					 u++;
					 newid=board.snakes[y].GettailID();
					 snakebites++;
					 System.out.println("Woah!A snake,well you went down..."+name);
					 for(int i=0; i<board.apples.length; i++)
					  {
						if(newid==board.apples[i].GetappleTileID() && board.apples[i].Getcolor()=="red")
							{
							score+=board.apples[i].Getpoints();
							board.apples[i].Setpoints(0);
							redappleseaten++;
							if(board.apples[i].Getpoints()!=0)
							System.out.println("Nice!You ate a red apple "+name+"You got "+ board.apples[i].points+"now!Your current score is"+score+"\t\t\t");
							}
						else if(newid==board.apples[i].GetappleTileID() && board.apples[i].Getcolor()=="black")
						{	
							score-=board.apples[i].Getpoints();
							board.apples[i].Setpoints(0);
						     blackappleseaten++;
						 	if(board.apples[i].Getpoints()!=0)
						     System.out.println("Oh!You ate a black apple "+name+"Now you lost"+ board.apples[i].points+"points.Your current score is"+score+"\t\t");
						   }
					  }
				 }
				 } 
			
		
		}
		//edw apla o pinakas p zhtaei h ekfwnhsh na epistrefei h move
		int stats_from_round[]= {
				newid,snakebites,laddersused,redappleseaten,blackappleseaten};
		//System.out.println(stats_from_round[0]);
		
	
	return stats_from_round;
	
}

}