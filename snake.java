

public class snake {
int snakeID;
int headID;
int tailID;
public snake(){
	snakeID = 0;
	headID = 0;
	tailID = 0;
}
public snake(int l,int m,int p) {
	snakeID=l;
	headID=m;
	tailID=p;
}
// ftiaxnw kai enan constructor p na pernei os orisma antikeimeno typoy snake
public snake(snake a) {
	this.SetsnakeID(a.GetsnakeID());
	this.SetheadID(a.GetheadID());
	this.SettailID(a.GettailID());
}
public void SetsnakeID(int newValue) {
	snakeID=newValue;
}
public void SetheadID(int newValue) {
	headID=newValue;
}
public void SettailID(int newValue) {
	tailID=newValue;
}
public int GetsnakeID() {
	return snakeID;
}
public int GetheadID() {
	return headID;
}
public int GettailID() {
	return tailID;
}
}
