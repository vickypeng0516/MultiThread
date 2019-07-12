package com.yanfei.udemy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args) {
		Student[] students = null;
		Book[] books = null;

		ExecutorService executorService = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);

		try {
			books = new Book[Constants.NUMBER_OF_BOOKS];
			students = new Student[Constants.NUMBER_OF_STUDENTS];
			
			// fill book arrays
			for(int i = 0; i < Constants.NUMBER_OF_BOOKS;i++) {
				books[i] = new Book(i);
			}
			
			// fill student arrays
			for(int i = 0; i < Constants.NUMBER_OF_STUDENTS;i++) {
				students[i] = new Student(i, books);
				// the way to execute runnable
				executorService.execute(students[i]);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			executorService.shutdown();
		} finally {
			executorService.shutdown();
		}
	}
}
