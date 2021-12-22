package question_6_pro;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class Reader implements Runnable {
	private String name = "";
	private int time;
	
	private R_W rw = null;
	
	public Reader(R_W rw, int time) {
		this.rw = rw;
		this.time = time;
	}
	
	public void addList(DefaultListModel<String> model) {
		model.add(model.getSize(), name + "(读)");
	}
	
	public void delList(DefaultListModel<String> model) {
		SwingUtilities.invokeLater(() -> {
			for (int i = 0; i < model.getSize(); i++) {
				if (model.get(i).equals(name + "(读)")) {
					model.remove(i);
					return ;
				}
			}
		});
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		R_W.Reader_wait.P();
		R_W.Rsem.P();
		R_W.Rmutex.P();
		R_W.read_count++;
		if (R_W.read_count == 1) {
			R_W.Wsem.P();
		}
		R_W.Rmutex.V();
		R_W.Rsem.V();
		R_W.Reader_wait.V();
		delList(rw.ui.rmodel);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		addList(rw.ui.omodel);
		System.out.println("I am " + name + ", I am reading.");
		try {
			Thread.sleep(this.time * 1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		R_W.Rmutex.P();
		R_W.read_count--;
		delList(rw.ui.omodel);
		if (R_W.read_count == 0) {
			R_W.Wsem.V();
		}
		R_W.Rmutex.V();

		try {
			int sec = (int)(Math.random() * 10000);
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
