package question_6_pro;

import java.util.ArrayList;
import java.util.List;


public class R_W {
	public List<Reader> reader = new ArrayList<Reader>();
	public List<Writer> writer = new ArrayList<Writer>();
	static public List<Thread> threads = new ArrayList<Thread>();
	static public Semaphore Rmutex = new Semaphore(1);
	static public Semaphore Wmutex = new Semaphore(1);
	static public Semaphore Rsem = new Semaphore(1);
	static public Semaphore Wsem = new Semaphore(1);
	static public Semaphore Reader_wait = new Semaphore(1);
	static public int read_count = 0;
	static public int write_count = 0;
	
	private int r = 0;
	private int w = 0;
	
	public UI ui = null;
	
	public void addReader(int num, int time) {
		for (int i = 0; i < num; i++) {
			Reader rd = new Reader(this, time);
			rd.setName("reader" + (i + this.r));
			reader.add(rd);
			threads.add(new Thread(rd));
			this.ui.rmodel.add(this.ui.rmodel.getSize(), "reader" + (i + this.r) + "(¶Á)");
		}
		this.r += num;
	}
	
	public void addWriter(int num, int time) {
		for (int i = 0; i < num; i++) {
			Writer wt = new Writer(this, time);
			wt.setName("writer" + (i + this.w));
			writer.add(wt);
			threads.add(new Thread(wt));
			this.ui.wmodel.add(this.ui.wmodel.getSize(), "writer" + (i + this.w) + "(Ð´)");
		}
		this.w += num;
	}
	
	public R_W(UI ui) {
		this.ui = ui;
	}
	
	public void test() {
		for (Thread thread : threads) {
			thread.start();
		}
		threads.clear();
		reader.clear();
		writer.clear();
	}
	

}
