package com.yanfei.udemy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
	private int id;
	private Lock lock;
	
	public Book(int id) {
		this.id = id;
		this.lock = new ReentrantLock();
	}
	// student lock book when reading 
	public void read(Student student) throws InterruptedException{
		// if student is reading the booking currently lock for 10 millisecond
		// tryLock API : if lock can be acquired,return true, proceed, or else return false
		if(lock.tryLock(1, TimeUnit.MINUTES)) {
			// lock.lock();
		System.out.println(student + " start reading " + this);
		Thread.sleep(2000);
		lock.unlock();
		System.out.println(student + " has finished " + this);
		}
	}
	
	@Override
	public String toString() {
		return "Book # " + id;
	}
	
	
}
