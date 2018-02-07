package app;

import utils.DataReader;
import data.Book;
import data.Library;

public class LibraryControl {
	public final int exit=0;
	public final int addBook=1;
	public final int printBooks=2;

	private DataReader dataReader;  // zmienna do komunikacji z u�ytkownikiem
	
	private Library library; // "biblioteka" przechowuj�ca dane
	
	public LibraryControl() {
		dataReader = new DataReader();
		library = new Library();
	}
	
	public void controlLoop() {
		int option;
		printOptions();
		while ((option = dataReader.getInt()) != exit) {
			switch (option) {
			case addBook:
				addBook();
				break;
			case printBooks:
				printBooks();
				break;
			default:
				System.out.println("Nie ma takiej opcji, wprowad� ponownie: ");
			}
			printOptions();
		}
		//zamykamy strumie� wej�cia
		dataReader.close();
	}
	
	private void printOptions() {
        System.out.println("Wybierz opcj�: ");
        System.out.println("0 - wyj�cie z programu");
        System.out.println("1 - dodanie nowej ksi��ki");
        System.out.println("2 - wy�wietl dost�pne ksi��ki");
	}
	
	private void addBook() {
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
	}
	
	private void printBooks() {
		library.printBooks();
	}
	
}
