

public class Apple {
int appleID;
int appleTileID;
String color;
int points;
public Apple() {
	appleID=0;
	appleTileID=0;
	color="";
}
public Apple(int l,int m,String k,int o) {
	appleID=l;
	appleTileID=m;
	color=k;
	points=o;
}

// ftiaxnw constructor p pairnei san orisma antikeimeno typoy apple
public Apple(Apple ap) {

	this.SetappleID(ap.GetappleId());
	this.SetappleTileID(ap.GetappleTileID());
	this.Setcolor(ap.Getcolor());
	this.Setpoints(ap.Getpoints());
}
public void SetappleID(int newValue) {
	appleID=newValue;
}
public void SetappleTileID(int newValue) {
	appleTileID=newValue;
}
public void Setcolor(String newValue) {
	color=newValue;
}
public void Setpoints(int newValue) {
	points=newValue;
}
int GetappleId() {
	return appleID;
}
int GetappleTileID() {
	return appleTileID;
}
String Getcolor() {
	return color;
}
int Getpoints() {
	return points;
}
}
