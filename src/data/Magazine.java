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

	super(year,title,publisher);
	setLanguage(language);
	setMont(month);
	setDay(day);
}
@Override
public String toString() {
	return getTitle() +"; "+ getPublisher()+"; "+getYear()+"-"+getMont()+"-"+getDay()+"; "+getLanguage();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + day;
	result = prime * result + ((language == null) ? 0 : language.hashCode());
	result = prime * result + mont;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Magazine other = (Magazine) obj;
	if (day != other.day)
		return false;
	if (language == null) {
		if (other.language != null)
			return false;
	} else if (!language.equals(other.language))
		return false;
	if (mont != other.mont)
		return false;
	return true;
}

}
