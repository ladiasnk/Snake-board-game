

public class Ladder {
int LadderID;
int upStepID;
int downStepID;
boolean broken;
public Ladder() {
LadderID=0;
upStepID=0;
downStepID=0;
}
public Ladder(int l,int m,int p,boolean k) {
	LadderID=l;
	upStepID=m;
	downStepID=p;
	broken=k;
}
// ftiaxnw kai enan constructor p pairnei san orisma antikeimenoy typoy ladder
public Ladder(Ladder l) {
	this.SetLadderID(l.GetLadderID());
	this.SetdownStepId(l.GetdownStepID());
	this.SetupStepID(l.GetupStepID());
	this.Setbroken(l.Getbroken());
}
public void SetLadderID(int newValue) {
	LadderID=newValue;
}
public void SetupStepID(int newValue) {
	upStepID=newValue;
}
public void SetdownStepId(int newValue) {
	downStepID=newValue;
}
public void Setbroken(boolean p) {
	broken=p;
}
public int GetLadderID() {
	return LadderID;
}
public int  GetupStepID() {
	return upStepID;
}
public int GetdownStepID() {
	return downStepID;
}
public boolean Getbroken() {
	return broken;
}
}
