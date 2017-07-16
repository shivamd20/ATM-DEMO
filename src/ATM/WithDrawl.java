package ATM;
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
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class WithDrawl {
	 JFrame frmAtm;
	JMenuBar menuBar;
	JToggleButton tglbtnNewToggleButton;
	AskForPin askPin;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bclear,bCancel;
	char keyboardInput;
	Thread keyboardip,buttonip;
	int count=0;

	public WithDrawl() throws Exception {
		
		initialize();
	}

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
	

		JButton lbutton1 = new JButton("New button");
		lbutton1.setBounds(34, 189, 46, 41);
		frmAtm.getContentPane().add(lbutton1);
		
		lblCancel = new JLabel("CANCEL");
		lblCancel.setBounds(113, 425, 140, 41);
		frmAtm.getContentPane().add(lblCancel);
		lblCancel.setForeground(SystemColor.info);
		lblCancel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCancel.setBackground(Color.WHITE);
		
		amount = new JLabel("");
		amount.setForeground(Color.WHITE);
		amount.setHorizontalAlignment(SwingConstants.CENTER);
		amount.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frmAtm.getContentPane().add(amount);
		amount.setBounds(101, 114, 597, 278);
		frmAtm.getContentPane().add(amount);

		JButton lbutton2 = new JButton("New button");
		lbutton2.setBounds(34, 271, 46, 41);
		frmAtm.getContentPane().add(lbutton2);

		JButton lbutton3 = new JButton("New button");
		lbutton3.setBounds(34, 351, 46, 41);
		frmAtm.getContentPane().add(lbutton3);

		JButton lbutton4 = new JButton("New button");
		lbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardDetect.dname="s";
			}
		});
		lbutton4.setBounds(34, 431, 46, 41);
		frmAtm.getContentPane().add(lbutton4);

		JButton rbutton1 = new JButton("New button");
		rbutton1.setBounds(720, 189, 46, 41);
		frmAtm.getContentPane().add(rbutton1);

		JButton rbutton2 = new JButton("New button");
		rbutton2.setBounds(720, 271, 46, 41);
		frmAtm.getContentPane().add(rbutton2);

		JButton rbutton3 = new JButton("New button");
		rbutton3.setBounds(720, 351, 46, 41);
		frmAtm.getContentPane().add(rbutton3);

		JButton rbutton4 = new JButton("New button");
		rbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkAmount();
				
			}
		});
		rbutton4.setBounds(720, 431, 46, 41);
		frmAtm.getContentPane().add(rbutton4);
		
		 menuBar = new JMenuBar();
		 menuBar.addKeyListener(keyada);
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
		 bclear.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		amount.setText("");
		 		count=0;
		 	}
		 });
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
		 tglbtnNewToggleButton.addKeyListener(keyada);
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
				
				lblNewLabel_2 = new JLabel("OK");
				lblNewLabel_2.setForeground(SystemColor.info);
				lblNewLabel_2.setBackground(SystemColor.text);
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
				lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
				lblNewLabel_2.setBounds(555, 431, 140, 41);
				frmAtm.getContentPane().add(lblNewLabel_2);
				
				lblNewLabel_1 = new JLabel("Please enter Your Amount");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel_1.setBackground(Color.BLUE);
				lblNewLabel_1.setBounds(101, 32, 597, 445);
				lblNewLabel_1.setOpaque(true);
				frmAtm.getContentPane().add(lblNewLabel_1);
				
		
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(0, 0, 794, 511);
				frmAtm.getContentPane().add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(main.class.getResource("/st1.jpg")));
				frmAtm.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblNewLabel }));
		frmAtm.setResizable(false);
		frmAtm.setFocusable(true);
		frmAtm.addKeyListener(keyada);
		lblNewLabel.addKeyListener(keyada);
		lblNewLabel_1.addKeyListener(keyada);
		
		b1.addKeyListener(keyada);
		b2.addKeyListener(keyada);
		b3.addKeyListener(keyada);
		b4.addKeyListener(keyada);
		b5.addKeyListener(keyada);
		b6.addKeyListener(keyada);
		b7.addKeyListener(keyada);
		b8.addKeyListener(keyada);
		b9.addKeyListener(keyada);
		b0.addKeyListener(keyada);
		bclear.addKeyListener(keyada);
		bCancel.addKeyListener(keyada);
		lbutton1.addKeyListener(keyada);
		lbutton2.addKeyListener(keyada);
		lbutton3.addKeyListener(keyada);
		lbutton4.addKeyListener(keyada);
		rbutton1.addKeyListener(keyada);
		rbutton2.addKeyListener(keyada);
		rbutton3.addKeyListener(keyada);
		rbutton4.addKeyListener(keyada);
	
	}
	void checkAmount()
	{
		if(!(amount.getText().equals("")))
		{
		CardDetails cD=new CardDetails();
		cD.btnNewButton.doClick();
		if(!((Integer.parseInt(amount.getText())+0)%10==0))
		{
			JOptionPane.showMessageDialog(lblNewLabel_1, "amount entered is not valid. please enter amount in the multiple of 100");
			CardDetect.dname="s";
		}
		else if((Integer.parseInt(amount.getText())+0)>(Integer.parseInt(cD.accbalance)+0))
		{
			JOptionPane.showMessageDialog(lblNewLabel_1, "You dont have sufficient balance to make this transaction");
			CardDetect.dname="s";
		}
		else
		{
			new CreateATM().UpdateDataBase(((Integer.parseInt(amount.getText())+0)),(Integer.parseInt(cD.accbalance)+0) ,(Integer.parseInt(cD.accno)+0));
			JOptionPane.showMessageDialog(null, "Transaction Complete");
			CardDetect.dname="s";
		}
		}
		else
		{
			JOptionPane.showMessageDialog(lblNewLabel_1, "please enter the amount");
			CardDetect.dname="s";
		}
	}
	ActionListener btnact=new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 		if(count<5)
	 		{
	 		System.out.println(e.getActionCommand());
	 		keyboardInput=e.getActionCommand().charAt(0);
	 		amount.setText(amount.getText()+e.getActionCommand());
	 		count++;
	 		}
	 	
	 	}
	 };

	 KeyAdapter keyada=new KeyAdapter() {
			@Override 
			public void keyPressed(KeyEvent e) {
				/*if(count<4){
			 		System.out.println(e.getKeyChar());
			 		keyboardInput=e.getKeyChar();
			 		PIN.setText(PIN.getText()+"*");
			 		pin=pin+e.getKeyChar();
			 		count++;
			 	}
				*/
				if(e.getKeyCode()==8)bclear.doClick();
				
				else switch(e.getKeyChar())
				{
				case '1':
					b1.doClick(10);
					break;
				case '2':
					b2.doClick(10);
					break;
				case '3':
					b3.doClick(10);
					break;
				case '4':
					b4.doClick(10);
					break;
				case '5':
					b5.doClick(10);
					break;
				case '6':
					b6.doClick(10);
					break;
				case '7':
					b7.doClick(10);
					break;
				case '8':
					b8.doClick(10);
					break;
				case '9':
					b9.doClick(10);
					break;
				case '0':
					b0.doClick(10);
					break;
				
				
				}
				
				
			}
		};
	private JPanel panel;
	private JLabel amount;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblCancel;
}
