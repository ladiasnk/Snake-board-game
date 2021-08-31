
import java.util.Random;

public class Board {
public int N,M;
int[][] tiles;
public snake[] snakes;
public Ladder[] ladders;
public Apple[] apples;
void SetN(int l) {
	l=N;
}
void SetM(int p) {
	p=M;
}
void Settiles(int[][]t) {
	tiles=t;
}
void Setsnakes(snake[]s) {
	s=snakes;
}
void Setladders(Ladder[]l) {
	l=ladders;
}
void Setapples(Apple[]a) {
	a=apples;
}
int getN() {
	return N;
}
int GetM() {
	return M;
}
int[][] Gettiles(){
	return tiles;
}
snake[] Getsnakes() {
	return snakes;
}
Ladder[] Getladders() {
	return ladders;
}
Apple[] Getapples() {
	return apples;
}

public Board(int l,int p,int snakesnumber,int applesnumber,int laddersnumber)
{
N=l;
M=p;


snakes=new snake[snakesnumber];
	for(int i=0; i<snakes.length; i++)
	{
		snakes[i] = new snake();
	}
ladders=new Ladder[laddersnumber];
for(int j=0; j<ladders.length; j++)
{
	ladders[j]= new Ladder();
}
apples=new Apple[applesnumber];
for(int r=0; r<apples.length; r++)
{
	apples[r] = new Apple();
}

}




public Board() {
	for (int i=0; i<N; i++)
		for(int j=0; j<M; j++)
			tiles[i][j]=0;

	snakes = new snake[0];
	ladders =new Ladder[0];
	apples=new Apple[0];
	for(int k=0; k<snakes.length; k++)
	{
	snakes[k].SetheadID(0);
	snakes[k].SetsnakeID(0);
	snakes[k].SettailID(0);}
	for (int o=0; o<ladders.length; o++)
	{	ladders[o].SetdownStepId(0);
	ladders[o].SetLadderID(0);
	ladders[o].SetupStepID(0);
	ladders[o].Setbroken(false);}
	for (int y=0; y<apples.length; y++)
	{
		apples[y].SetappleID(0);
		apples[y].SetappleTileID(0);
		apples[y].Setpoints(0);
		apples[y].Setcolor("");
	}

	
}



//constructor p pairnei san orisma antikeimeno typoy board
public Board(Board b) {
    
	this.Setapples(b.Getapples());
	this.Setladders(b.Getladders());
	this.Setsnakes(b.Getsnakes());
	this.SetN(b.getN());
	this.SetM(b.GetM());
	this.Settiles(b.Gettiles());
	
	
}
public void createBoard() {
	

	Random randomnumber=new Random();
	//prota ftiaxnoyme ton pinaka tiles me ids ton plakidiwn
	tiles =new int[N][M];
	
	int j;
	int cat=1;
	tiles[N-1][0]=1;
	for(int i=N-1; i>=0; i--)
	{
		if(cat==1) {
			for(j=0; j<M-1; j++)
				tiles[i][j+1]=tiles[i][j]+1;
			if(tiles[i][M-1]!=N*M)
			{tiles[i-1][M-1]=tiles[i][M-1]+1;}
			cat=2;
			}
			else if(cat==2)
			{
				for(j=M-1; j>0; j--)
					tiles[i][j-1]=tiles[i][j]+1;
				if(tiles[i][0]!=N*M)
				{tiles[i-1][0]=tiles[i][0]+1;}
				cat=1;
			}
		
	}
	// deinoyme se ka8e fidi to id toy kai meta enan tyxaio arithmo sto tamplo gia thn oyra toy

	
		
	
	for(int k=0; k<snakes.length; k++)
	{ 
	 snakes[k].SetsnakeID(k);
	 snakes[k].SettailID(1+randomnumber.nextInt((N-1)*M));
	
	}
	
	/*se olo to tamplo tsekarw p einai h oyra toy kathe enos fidioy(h opoia den ginetai na einai sto anotato epipedo) kai deinw enan 
	 * opoiondhpote tyxaio arithmo gia to kefali meta efoson brisketai sigoyra ena epipedo pio panw apo
	 * thn oyra,epishs taytoxrona tsekarw sth naia timh p deinw kathe fora na mhn simpiptei to kefali
	 * me kapoio allo fidioy
	 */
	for(int i=0; i<N; i++)
		for(j=0; j<M; j++)
		  for(int k=0; k<snakes.length; k++)
		  {   if(tiles[i][j]==snakes[k].GettailID())
             {
            	 int w=i-1;
            	 if(w>0)
           snakes[k].SetheadID(tiles[i-1][0]+randomnumber.nextInt((i-1)*M-1));
            	 else if(N%2==0)
            		 snakes[k].SetheadID(tiles[0][0]-randomnumber.nextInt(M-1));
            	 else
            		 snakes[k].SetheadID(tiles[0][0]+randomnumber.nextInt(M-1));
			    int c=1;
						while(c!=0)
				   {   
					c=0;
					 int v=i-1;
	            	 if(v>0)
	           snakes[k].SetheadID(tiles[i-1][0]+randomnumber.nextInt((i-1)*M-1));
	            	 else
	            		 snakes[k].SetheadID(tiles[0][0]+randomnumber.nextInt(M-1));
					for(int r=0; r<snakes.length; r++)
					if(snakes[r].GetheadID()==snakes[k].GetheadID() && r!=k)
					c++;
			       }
			}
		  }
	
	//akribws idies diadikasies gia tis skales , edw
	//tsekarw kai epishs na mhn arxizei h skala ekei p yparxei kefali fidioy
	//kai TAYTOXRONA TSEKARW Na mhn simpiptei bebaia to katw meros skalas me allhs skalas
	
	
	//System.out.println("This is your god speaking Nick Ladias");
	
	
	for(int k=0; k<ladders.length; k++)
	{ 
		ladders[k].LadderID=k;	    
		   int c=1;
			while(c!=0)
	   {   
		c=0;
		ladders[k].SetupStepID(randomnumber.nextInt((N-1)*M));
		for(int p=0; p<ladders.length; p++)
			if(ladders[p].GetupStepID()==ladders[k].GetupStepID() && p!=k)
				c++;
		for(int i=0; i<snakes.length; i++)
		if(snakes[i].GetheadID()==ladders[k].GetupStepID() )
		c++;
      }
	   
	}
	//System.out.println("κερασι με ριγανη");
	//idia gia skales ,briskw kathe fora p einai to katw meros
	// kai meta bazw tyxaio airthmo gia to panw meros efoson bebaia brisketai panw
	//apo to katw meros
	
	
	for(int i=0; i<N; i++)
		for(j=0; j<M; j++)
		  for(int k=0; k<ladders.length; k++)
		{      if(tiles[i][j]==ladders[k].GetupStepID())
		{
			 int w=i-1;
        	 if(w>0)
       ladders[k].SetdownStepId(tiles[i-1][0]+randomnumber.nextInt(w*M-1));
        	 else if(N%2==0)
        		 ladders[k].SetdownStepId(tiles[0][0]-randomnumber.nextInt(M-1));
        	 else
        		 ladders[k].SetdownStepId(tiles[0][0]+randomnumber.nextInt(M-1));
		}
		}
	
	
	//deinw id kai tileid sta mhla kai elegxw na mhn  briskontai profanws ekei p yparxei
	//kefali fidioy,opws kai parapanw,gia na to kanoyme ayto kratame enan metrhth c
	//kathe fora p dinoyme tyxai timh sto appleTileid kai ton ay3anoyme se mia while an
	//ksanadwsame kata lathos pali sthn tyxaia timh poy dwsame kefali fidioy mexri na mhn ginei
	//ayto , toy deinoyme kai xrwma kai dinei pontoys an einai kokkino afairei an einai mayro
	int d;
	for(d=0; d<apples.length; d++)
	{
		apples[d].SetappleID(d);
		apples[d].SetappleTileID(randomnumber.nextInt(N*M));
		int randomcolor=randomnumber.nextInt(10);
		if(randomcolor<5)
			apples[d].Setcolor("red");
		else
			apples[d].Setcolor("black");
		if(apples[d].color=="red")
		{	int l=1+randomnumber.nextInt(3);
		     apples[d].Setpoints(5*l);}
		else
			{  
			int l=1+randomnumber.nextInt(3);
	        apples[d].Setpoints(5*l);  }
		int c=1;
		for(int i=0; i<snakes.length; i++)
		{	
			
			if (snakes[i].GetheadID()==apples[d].GetappleTileID())
			{		while(c>0)
			 {    
				c=0;
				apples[d].SetappleTileID(randomnumber.nextInt(N*M));
				for(i=0; i<snakes.length; i++)
				if(snakes[i].GetheadID()==apples[d].GetappleTileID())
				c++;
		     }
			}
	}
			
	
}
             
}

void createElementBoard() {
	
	// dhlwnwoyme prwta toys treis zhtoymenoys pinakes
String[][] elementBoardsnakes=new String[N][M];
String[][]  elementBoardapples=new String[N][M];
String[][] elementBoardLadders= new String[N][M];
// gemizoyme ton pinaka elementBoardsnakes opws maw zhtatai kai me paromoio tropo toys ypoloipoys
//taytoxrona toys typwnoyme enan enan
System.out.println("snake head: SH. snake tail: ST ");
System.out.println(" ladderdownstep : LD. ladderupstep: LU");
System.out.println("red apple: AR. black apple: AB");
	for (int i=0; i<N; i++)
	{   System.out.println();
		for(int j=0; j<M; j++)
		{
			for(int k=0; k<snakes.length; k++ )
			{
				if(tiles[i][j]==snakes[k].GetheadID())
				{	elementBoardsnakes[i][j]="SH" + snakes[k].GetsnakeID();
			break;}
				else if(tiles[i][j]==snakes[k].GettailID())
				{	elementBoardsnakes[i][j]="ST" + snakes[k].GetsnakeID();
			break;}
			 else
					elementBoardsnakes[i][j]="___";		
				
			
			
		}
			System.out.print(elementBoardsnakes[i][j]+" ");
	}
	}
	System.out.println();
	System.out.println();
	System.out.println();
	//oi skales
	for (int i=0; i<N; i++)
		{System.out.println();
		for(int j=0; j<M; j++)
		{
			for(int k=0; k<ladders.length; k++ )
			{
				if(tiles[i][j]==ladders[k].GetupStepID())
					{elementBoardLadders[i][j]="LU" + ladders[k].GetLadderID();
					break;}
					
				else if(tiles[i][j]==ladders[k].GetdownStepID())
					{elementBoardLadders[i][j]="LD" + ladders[k].GetLadderID();
					break;}
				else
					elementBoardLadders[i][j]="___";
			
			}
			System.out.print(elementBoardLadders[i][j]+" ");
		}
		}
	// ta mhla
	System.out.println();
	System.out.println();
	System.out.println();
	for (int i=0; i<N; i++)
	{	System.out.println();
		for(int j=0; j<M; j++)
		{
			for(int k=0; k<apples.length; k++ )
			{
				if(tiles[i][j]==apples[k].GetappleTileID())
					{if(apples[k].Getcolor()=="black")
						{elementBoardapples[i][j]="AB"+apples[k].GetappleId();
						break;}
						
					else
						{elementBoardapples[i][j]="AR" + apples[k].GetappleId();
						break;
						}
					}
		       else
		    	   elementBoardapples[i][j]="___";
				
			}	
			System.out.print(elementBoardapples[i][j]+" ");
}
	}
	System.out.println();
	







}
}

