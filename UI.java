package question_6_pro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UI extends JFrame {

	private JPanel contentPane;
	
	private JComboBox<Integer> writerTime;
	private JComboBox<Integer> readerTime;
	private JComboBox<Integer> readerCombo;
	private JComboBox<Integer> writerCombo;
	
	public DefaultListModel<String> omodel;
	public DefaultListModel<String> rmodel;
	public DefaultListModel<String> wmodel;
	
	private R_W rw = new R_W(this);
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {126, 119, 179, 26, 100};
		gbl_contentPane.rowHeights = new int[] {71, 69, 43, 72, 216};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8BFB\u8005\u6570\u91CF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		readerCombo = new JComboBox<Integer>();
		readerCombo.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5}));
		GridBagConstraints gbc_readerCombo = new GridBagConstraints();
		gbc_readerCombo.insets = new Insets(0, 0, 5, 5);
		gbc_readerCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_readerCombo.gridx = 1;
		gbc_readerCombo.gridy = 0;
		contentPane.add(readerCombo, gbc_readerCombo);
		
		JLabel lblNewLabel_1 = new JLabel("\u64CD\u4F5C\u65F6\u95F4");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		readerTime = new JComboBox<Integer>();
		readerTime.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5}));
		GridBagConstraints gbc_readerTime = new GridBagConstraints();
		gbc_readerTime.insets = new Insets(0, 0, 5, 5);
		gbc_readerTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_readerTime.gridx = 3;
		gbc_readerTime.gridy = 0;
		contentPane.add(readerTime, gbc_readerTime);
		
		JButton readerButton = new JButton("\u6DFB\u52A0\u8BFB\u8005");
		readerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI.this.rw.addReader((int)UI.this.readerCombo.getSelectedItem(), (int)UI.this.readerTime.getSelectedItem());
			}
		});
		readerButton.setFont(new Font("宋体", Font.BOLD, 18));
		GridBagConstraints gbc_readerButton = new GridBagConstraints();
		gbc_readerButton.insets = new Insets(0, 0, 5, 0);
		gbc_readerButton.gridx = 4;
		gbc_readerButton.gridy = 0;
		contentPane.add(readerButton, gbc_readerButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u5199\u8005\u6570\u91CF");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		writerCombo = new JComboBox<Integer>();
		writerCombo.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5}));
		GridBagConstraints gbc_writerCombo = new GridBagConstraints();
		gbc_writerCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_writerCombo.insets = new Insets(0, 0, 5, 5);
		gbc_writerCombo.gridx = 1;
		gbc_writerCombo.gridy = 1;
		contentPane.add(writerCombo, gbc_writerCombo);
		
		JLabel lblNewLabel_3 = new JLabel("\u64CD\u4F5C\u65F6\u95F4");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 1;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		writerTime = new JComboBox<Integer>();
		writerTime.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5}));
		GridBagConstraints gbc_writerTime = new GridBagConstraints();
		gbc_writerTime.insets = new Insets(0, 0, 5, 5);
		gbc_writerTime.fill = GridBagConstraints.HORIZONTAL;
		gbc_writerTime.gridx = 3;
		gbc_writerTime.gridy = 1;
		contentPane.add(writerTime, gbc_writerTime);
		
		JButton writerButton = new JButton("\u6DFB\u52A0\u5199\u8005");
		writerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI.this.rw.addWriter((int)UI.this.writerCombo.getSelectedItem(), (int)UI.this.writerTime.getSelectedItem());
			}
		});
		writerButton.setFont(new Font("宋体", Font.BOLD, 18));
		GridBagConstraints gbc_writerButton = new GridBagConstraints();
		gbc_writerButton.insets = new Insets(0, 0, 5, 0);
		gbc_writerButton.gridx = 4;
		gbc_writerButton.gridy = 1;
		contentPane.add(writerButton, gbc_writerButton);
		
		JButton fireButton = new JButton("\u542F\u52A8");
		fireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI.this.rw.test();
			}
		});
		fireButton.setFont(new Font("等线", Font.BOLD, 20));
		GridBagConstraints gbc_fireButton = new GridBagConstraints();
		gbc_fireButton.fill = GridBagConstraints.BOTH;
		gbc_fireButton.insets = new Insets(0, 0, 5, 5);
		gbc_fireButton.gridx = 2;
		gbc_fireButton.gridy = 2;
		contentPane.add(fireButton, gbc_fireButton);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BFB\u8005\u7B49\u5F85\u961F\u5217");
		lblNewLabel_4.setFont(new Font("华文新魏", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 3;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u64CD\u4F5C\u533A");
		lblNewLabel_5.setFont(new Font("华文新魏", Font.PLAIN, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 3;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5199\u8005\u7B49\u5F85\u961F\u5217");
		lblNewLabel_6.setFont(new Font("华文新魏", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 3;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		rmodel = new DefaultListModel<String>();
		JList<String> readerList = new JList<String>(rmodel);
		GridBagConstraints gbc_readerList = new GridBagConstraints();
		gbc_readerList.insets = new Insets(0, 0, 5, 5);
		gbc_readerList.fill = GridBagConstraints.BOTH;
		gbc_readerList.gridx = 1;
		gbc_readerList.gridy = 4;
		contentPane.add(readerList, gbc_readerList);
		
		
		omodel = new DefaultListModel<String>();
		JList<String> opList = new JList<String>(omodel);
		GridBagConstraints gbc_opList = new GridBagConstraints();
		gbc_opList.insets = new Insets(0, 0, 5, 5);
		gbc_opList.fill = GridBagConstraints.BOTH;
		gbc_opList.gridx = 2;
		gbc_opList.gridy = 4;
		contentPane.add(opList, gbc_opList);

		wmodel = new DefaultListModel<String>();
		JList<String> writerList = new JList<String>(wmodel);
		GridBagConstraints gbc_writerList = new GridBagConstraints();
		gbc_writerList.insets = new Insets(0, 0, 5, 5);
		gbc_writerList.fill = GridBagConstraints.BOTH;
		gbc_writerList.gridx = 3;
		gbc_writerList.gridy = 4;
		contentPane.add(writerList, gbc_writerList);

	}

}
