package com.yanfei.udemy;

import java.util.Random;

public class Student implements Runnable {
	private int id;
	private Book[] books;
	
	public Student(int id, Book[] books) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.books = books;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random = new Random();
		while(true) {
			// generate a random book to read
			int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
			try {
				books[bookId].read(this);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "Student #" + id;
	}
}
