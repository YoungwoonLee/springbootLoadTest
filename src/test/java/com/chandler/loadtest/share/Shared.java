package com.chandler.loadtest.share;

public class Shared {

	private static Shared instance = new Shared(); // 싱글톤 패턴의 인스턴스

	public static Shared getInstance() {
		return instance;
	}

	private long count = 0l;

	private Shared() {
	} // 싱글톤으로 하기 위해서 private 생성자로 함.

	public synchronized long getCount() {
		return count;
	}

	public synchronized void setCount(long count) {
		this.count = count;
	}

	public synchronized long increment() {
		return ++count;
	}

	public long decrement() {
		return --count;
	}

	public long increment(long x) {
		return (count += x);
	}

	public long decrement(long x) {
		return (count -= x);
	}

}
