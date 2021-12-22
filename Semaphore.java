package question_6_pro;

public class Semaphore {
	private int count = 0;
	
	public Semaphore() {}
	
	public Semaphore(int count) {
		this.count = count;
	}
	
	synchronized public void P() {
		count--;
		if (count < 0) {
			try {
				this.wait();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	synchronized public void V() {
		count++;
		if (count <= 0) {
			this.notify();
		}
	}
}
