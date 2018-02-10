package app;

import utils.DataReader;
import data.Book;
import data.Library;
import data.Magazine;

public class LibraryControl {
	private DataReader dataReader;  // zmienna do komunikacji z u�ytkownikiem
	private Library library; // "biblioteka" przechowuj�ca dane
	public LibraryControl() {
		dataReader = new DataReader();
		library = new Library();
	}
	/*
	 * G��wna p�tla programu, kt�ra pozwala na wyb�r opcji i interakcj�
	 */
	public void controlLoop() {
		Option option;
		printOptions();
		while ((option = Option.createFromInt(dataReader.getInt())) != Option.EXIT) {
			switch (option) {
			case ADD_BOOK:
				addBook();
				break;
			case ADD_MAGAZINE:
				addMagazine();
				break;
			case PRINT_BOOKS:
				printBooks();
				break;
			case PRINT_MAGAZINES:
				printMagazines();
				break;
			case EXIT:
				;
			}
			printOptions();
		}
		//zamykamy strumie� wej�cia
		dataReader.close();
	}
	
	private void printOptions() {
        System.out.println("Wybierz opcj�: ");
        for(Option o: Option.values()) {
        	System.out.println(o);
        }
	}
	
	private void addBook() {
		Book book = dataReader.readAndCreateBook();
		library.addBook(book);
	}
	
	private void printBooks() {
		library.printBooks();
	}
	
	private void addMagazine() {
		Magazine magazine =dataReader.readAndCreateMagazine();
		library.addMagazine(magazine);
	}
	
	private void printMagazines() {
		library.printMagazines();
	}
}
