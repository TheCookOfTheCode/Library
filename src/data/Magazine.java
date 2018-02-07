package data;

public class Magazine extends Publication {
private int mont;
private int day;
private String language;
public int getMont() {
	return mont;
}
public void setMont(int mont) {
	this.mont = mont;
}
public int getDay() {
	return day;
}
public void setDay(int day) {
	this.day = day;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}

public Magazine(String title, String publisher, String language, int year, int month, int day) {
	setTitle(title);
	setPublisher(publisher);
	setLanguage(language);
	setYear(year);
	setMont(month);
	setDay(day);
}
public void printInfo() {
	String info= getTitle() +"; "+ getPublisher()+"; "+getYear()+"-"+getMont()+"-"+getDay()+"; "+getLanguage();
	System.out.println(info);
}
}
