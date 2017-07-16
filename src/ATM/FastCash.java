package ATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import java.awt.Color;

public class FastCash {
	 JFrame frmAtm;
	JMenuBar menuBar;
	JToggleButton tglbtnNewToggleButton;
	AskForPin askPin;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bclear,bCancel;
	char keyboardInput;
	ActionListener btnact;
	Thread keyboardip,buttonip;
	String amount;

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public FastCash() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAtm = new JFrame();
		frmAtm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shiva\\Desktop\\Snap.png"));
		frmAtm.setTitle("ATM");
		frmAtm.setBounds(100, 100, 685, 491);
		frmAtm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAtm.getContentPane().setLayout(null);
		// frame.setSize(icon.getIconWidth(),icon.getIconHeight());
		frmAtm.setSize(1100, 540);
		frmAtm.getContentPane().setLayout(null);
		
		label = new JLabel("5000");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label.setBounds(104, 186, 202, 56);
		frmAtm.getContentPane().add(label);
		
		label_4 = new JLabel("2000");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label_4.setBounds(438, 416, 261, 56);
		frmAtm.getContentPane().add(label_4);
		
		label_5 = new JLabel("1000");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label_5.setBounds(499, 342, 202, 56);
		frmAtm.getContentPane().add(label_5);
		
		label_6 = new JLabel("500");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label_6.setBounds(499, 260, 202, 56);
		frmAtm.getContentPane().add(label_6);
		
		label_7 = new JLabel("100");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label_7.setBounds(449, 186, 248, 56);
		frmAtm.getContentPane().add(label_7);
		
		label_3 = new JLabel("20000");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label_3.setBounds(104, 416, 202, 56);
		frmAtm.getContentPane().add(label_3);
		
		label_1 = new JLabel("10000");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label_1.setBounds(104, 260, 202, 56);
		frmAtm.getContentPane().add(label_1);
		
		label_2 = new JLabel("15000");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		label_2.setBounds(104, 342, 202, 56);
		frmAtm.getContentPane().add(label_2);
		
		lblNewLabel_1 = new JLabel("Please Choose One Option");
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(100, 32, 601, 440);
		lblNewLabel_1.setOpaque(true);
		frmAtm.getContentPane().add(lblNewLabel_1);

		JButton lbutton1 = new JButton("New button");
		lbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount(5000);
			}
		});
		lbutton1.setBounds(34, 189, 46, 41);
		frmAtm.getContentPane().add(lbutton1);

		JButton lbutton2 = new JButton("New button");
		lbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount(10000);
			}
		});
		lbutton2.setBounds(34, 271, 46, 41);
		frmAtm.getContentPane().add(lbutton2);

		JButton lbutton3 = new JButton("New button");
		lbutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount(15000);
			}
		});
		lbutton3.setBounds(34, 351, 46, 41);
		frmAtm.getContentPane().add(lbutton3);

		JButton lbutton4 = new JButton("New button");
		lbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount(20000);
			}
		});
		lbutton4.setBounds(34, 431, 46, 41);
		frmAtm.getContentPane().add(lbutton4);

		JButton rbutton1 = new JButton("New button");
		rbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount(100);
			}
		});
		rbutton1.setBounds(720, 189, 46, 41);
		frmAtm.getContentPane().add(rbutton1);

		JButton rbutton2 = new JButton("New button");
		rbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount(500);
				
			}
		});
		rbutton2.setBounds(720, 271, 46, 41);
		frmAtm.getContentPane().add(rbutton2);

		JButton rbutton3 = new JButton("New button");
		rbutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount(1000);
			}
		});
		rbutton3.setBounds(720, 351, 46, 41);
		frmAtm.getContentPane().add(rbutton3);

		JButton rbutton4 = new JButton("New button");
		rbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount(2000);
			}
		});
		rbutton4.setBounds(720, 431, 46, 41);
		frmAtm.getContentPane().add(rbutton4);
		
		 menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 21);
		frmAtm.getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("ATM");
		menuBar.add(mnNewMenu);

		JMenuItem mntmManageAcconts = new JMenuItem("Check your Card Details");
		mntmManageAcconts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CardDetails().frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmManageAcconts);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Create Atm Card");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateATM().frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		menuBar.setVisible(false);
		 
		 panel = new JPanel();
		 panel.setBorder(new TitledBorder(null, "NumPad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		 panel.setBounds(816, 95, 274, 300);
		 frmAtm.getContentPane().add(panel);
		 panel.setLayout(null);
		
		 b7 = new JButton("7");
		 b7.addActionListener(btnact);
		 b7.setBounds(6, 16, 72, 50);
		 panel.add(b7);
		
		b7.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 b8 = new JButton("8");
		 b8.addActionListener(btnact);
		 b8.setBounds(101, 16, 72, 50);
		 panel.add(b8);
		 
		 
		b8.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 b9 = new JButton("9");
		 b9.addActionListener(btnact);
		 b9.setBounds(196, 16, 72, 50);
		 panel.add(b9);
		 
		b9.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 b4 = new JButton("4");
		 b4.addActionListener(btnact);
		 b4.setBounds(6, 94, 72, 50);
		 panel.add(b4);
	b4.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 b5 = new JButton("5");
		 b5.addActionListener(btnact);
		 b5.setBounds(101, 94, 72, 50);
		 panel.add(b5);
	
		b5.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 b6 = new JButton("6");
		 b6.setBounds(196, 94, 72, 50);
		 panel.add(b6);
		 b6.addActionListener(btnact);
	
		b6.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 b1 = new JButton("1");
		 b1.setBounds(6, 167, 72, 50);
		 panel.add(b1);
		 b1.addActionListener(btnact);
	
		b1.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 b2 = new JButton("2");
		 b2.setBounds(101, 167, 72, 50);
		 panel.add(b2);
		 b2.addActionListener(btnact);
		
		b2.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 b3 = new JButton("3");
		b3.setBounds(196, 167, 72, 50);
		panel.add(b3);
	
		b3.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		b3.addActionListener(btnact);
		
		 bclear = new JButton("Clear");
		 bclear.setBounds(6, 243, 72, 50);
		 panel.add(bclear);
		
		 b0 = new JButton("0");
		 b0.setBounds(101, 243, 72, 50);
		 panel.add(b0);
		 b0.addActionListener(btnact);
	
		b0.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		
		 bCancel = new JButton("Cancel");
		 bCancel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		CardDetect.dname="s";
		 	}
		 });
		 bCancel.setBounds(196, 243, 72, 50);
		 panel.add(bCancel);
		
		 tglbtnNewToggleButton = new JToggleButton("v");
		//tglbtnNewToggleButton.setSelectedIcon(new ImageIcon(main.class.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
		tglbtnNewToggleButton.setFont(new Font("Tahoma", Font.PLAIN, 5));
		
		tglbtnNewToggleButton.setMnemonic('c');
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnNewToggleButton.isSelected()==true){
					tglbtnNewToggleButton.setText("^");
				menuBar.setVisible(true);}
				if(tglbtnNewToggleButton.isSelected()==false){
					tglbtnNewToggleButton.setText("v");
					menuBar.setVisible(false);}
			}
		});
		tglbtnNewToggleButton.setBounds(801, 0, -5, 3);
		frmAtm.getContentPane().add(tglbtnNewToggleButton);
		
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(0, 0, 794, 511);
				frmAtm.getContentPane().add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(main.class.getResource("/st1.jpg")));
				frmAtm.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblNewLabel }));
		frmAtm.setResizable(false);
		frmAtm.setFocusable(true);
		t.start();
	}
	Thread t=new Thread(new Runnable() {
		public void run(){ 
			new CardDetect().t.start();
			while(CardDetect.dname=="s")
			{
				try {
					Thread.sleep(1000);
			
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
	
			}
		}
	});

	void checkAmount(int amount)
	{
		
		CardDetails cD=new CardDetails();
		cD.btnNewButton.doClick();
	 if(((amount)+0)>(Integer.parseInt(cD.accbalance)+0))
		{
			JOptionPane.showMessageDialog(lblNewLabel_1, "You dont have sufficient balance to make this transaction");
			CardDetect.dname="s";
		}
		else
		{
			new CreateATM().UpdateDataBase(((amount+0)),(Integer.parseInt(cD.accbalance)+0) ,(Integer.parseInt(cD.accno)+0));
			CardDetect.dname="s";
		}
	}
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;

}
