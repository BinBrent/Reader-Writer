package question_6_pro;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class Writer implements Runnable {
	private String name = "";
	private int time;
	
	private R_W rw = null;

	
	public Writer(R_W rw, int time) {
		this.rw = rw;
		this.time = time;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addList(DefaultListModel<String> model) {
		model.add(model.getSize(), name + "(写)");
	}
	
	public void delList(DefaultListModel<String> model) {
		SwingUtilities.invokeLater(() -> {
			for (int i = 0; i < model.getSize(); i++) {
				if (model.get(i).equals(name + "(写)")) {
					model.remove(i);
					return ;
				}
			}
		});
	}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		R_W.Wmutex.P();
		R_W.write_count++;
		if (R_W.write_count == 1) {
			R_W.Rsem.P();
		}
		R_W.Wmutex.V();
		R_W.Wsem.P();
		delList(rw.ui.wmodel);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		addList(rw.ui.omodel);
		System.out.println("I am " + name + ", I am writing.");
		try {
			Thread.sleep(this.time * 1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		R_W.Wsem.V();
		R_W.Wmutex.P();
		delList(rw.ui.omodel);
		R_W.write_count--;
		if (R_W.write_count == 0) {
			R_W.Rsem.V();
		}
		R_W.Wmutex.V();
		try {
			int sec = (int)(Math.random() * 20000);
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
