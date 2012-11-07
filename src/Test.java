

public class Test extends Thread {
	public static void main(String[] args) {
	}

	private SingleClass clazz;

	public Test(SingleClass clazz) {
		this.clazz = clazz;
	}

	@Override
	public void run() {
		clazz.test();
	}
}

class Thread2 extends Thread {

	private SingleClass clazz;

	public Thread2(SingleClass clazz) {
		this.clazz = clazz;
	}

	@Override
	public void run() {
		clazz.test();
	}
}

class SingleClass {
	private String test;
	
	private boolean syscn = true;

	public void test() {
		synchronized (this) {
			while (syscn) {
				System.out.println(Thread.currentThread() + "test method"
						+ test);
			}
		}
	}

	public void me() {
		test = "me";
		syscn = false;
		System.out.println(Thread.currentThread() + "me method" + test);
	}
}
