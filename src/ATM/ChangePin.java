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
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class ChangePin {
	 JFrame frmAtm;
	JMenuBar menuBar;
	JToggleButton tglbtnNewToggleButton;
	AskForPin askPin;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bclear,bCancel;
	char keyboardInput;
	int count;
	Thread keyboardip,buttonip;
	String oldPin="",newPin="";

	
	public ChangePin() throws Exception {
		
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

		JButton lbutton2 = new JButton("New button");
		lbutton2.setBounds(34, 271, 46, 41);
		frmAtm.getContentPane().add(lbutton2);

		JButton lbutton3 = new JButton("New button");
		lbutton3.setBounds(34, 351, 46, 41);
		frmAtm.getContentPane().add(lbutton3);

		JButton lbutton4 = new JButton("New button");
		lbutton4.setBounds(34, 431, 46, 41);
		frmAtm.getContentPane().add(lbutton4);
		
		lblNewLabel_3 = new JLabel("Please Enter Your Old PIN");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_3.setBounds(272, 152, 287, 27);
		frmAtm.getContentPane().add(lblNewLabel_3);

		JButton rbutton1 = new JButton("New button");
		rbutton1.setBounds(720, 189, 46, 41);
		frmAtm.getContentPane().add(rbutton1);
		
		lblCancel = new JLabel("Cancel");
		lblCancel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCancel.setForeground(Color.WHITE);
		lblCancel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblCancel.setBounds(102, 444, 115, 27);
		frmAtm.getContentPane().add(lblCancel);
		
		lblNewLabel_2 = new JLabel("Change");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(586, 445, 115, 27);
		frmAtm.getContentPane().add(lblNewLabel_2);

		JButton rbutton2 = new JButton("New button");
		rbutton2.setBounds(720, 271, 46, 41);
		frmAtm.getContentPane().add(rbutton2);
		
		pin = new JLabel("");
		pin.setFont(new Font("Tahoma", Font.PLAIN, 29));
		pin.setHorizontalAlignment(SwingConstants.CENTER);
		pin.setBounds(221, 226, 388, 36);
		frmAtm.getContentPane().add(pin);
		
		JLabel lblNewLabel_1 = new JLabel("Change Pin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.BLUE);
		lblNewLabel_1.setBounds(100, 32, 602, 448);
		lblNewLabel_1.setOpaque(true);
		frmAtm.getContentPane().add(lblNewLabel_1);

		JButton rbutton3 = new JButton("New button");
		rbutton3.setBounds(720, 351, 46, 41);
		frmAtm.getContentPane().add(rbutton3);

		JButton rbutton4 = new JButton("New button");
		rbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePin();
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

	}
	ActionListener btnact=new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 		if(count<4)
	 		{
	 		lblNewLabel_3.setText("please enter your old PIN");
	 		System.out.println(e.getActionCommand());
	 		keyboardInput=e.getActionCommand().charAt(0);
	 		oldPin=oldPin+e.getActionCommand();
	 		pin.setText(pin.getText()+"*");
	 		count++;
	 		if(count==4)
	 		{
	 			lblNewLabel_3.setText("please enter your new PIN");
	 			pin.setText("");
	 			
	 		}
	 		}
	 		else if(count==4)
	 		{
	 			pin.setText("*");
	 			newPin=newPin+e.getActionCommand();
	 			count++;
	 		}
	 		else if(count<8)
	 		{
	 			newPin=newPin+e.getActionCommand();
	 			pin.setText(pin.getText()+"*");
	 			count++;
	 		}
	 	}
	 };
	 
	 KeyAdapter keyada=new KeyAdapter() {
			@Override 
			public void keyPressed(KeyEvent e) {
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
		void changePin()
		{CardDetails cd=new CardDetails();
		cd.fileOpen();
			cd.getContent();
			if(count==8)
			{
				System.out.println("newpin\t"+newPin+"\toldpin\t"+oldPin);
				if(oldPin.equals(cd.atmpin))
				{
					CreateATM cA=new CreateATM();
					cA.UpdateDataBasePin(Integer.parseInt(newPin), Integer.parseInt(cd.accno));
				}
				else
				{
					JOptionPane.showMessageDialog(frmAtm, "old pin is incorrect");
					CardDetect.dname="s";
				}
			}
		}
	private JPanel panel;
	private JLabel lblNewLabel_2;
	private JLabel lblCancel;
	private JLabel lblNewLabel_3;
	private JLabel pin;
}
