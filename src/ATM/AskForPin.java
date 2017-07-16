package ATM;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class AskForPin {
	 JFrame frmAtm;
	JMenuBar menuBar;
	JToggleButton tglbtnNewToggleButton;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bclear,bCancel;
	char keyboardInput='s';
	JLabel lblNewLabel_1;
	String pin="";
	int count =0;
	private JPanel panel;
	private JLabel PIN;
	
	public AskForPin() throws Exception {
		
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
				
			CreateATM cA=new CreateATM();
				cA.frame.setVisible(true);
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
		 bclear.addActionListener(btnact);
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
				
				PIN = new JLabel("");
				PIN.setHorizontalAlignment(SwingConstants.CENTER);
				PIN.setFont(new Font("Tahoma", Font.PLAIN, 43));
				PIN.setBounds(295, 189, 254, 115);
				frmAtm.getContentPane().add(PIN);
				
				 lblNewLabel_1 = new JLabel("Please Enter Your PIN");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
				lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBackground(Color.BLUE);
				lblNewLabel_1.setIcon(null);
				lblNewLabel_1.setBounds(101, 32, 596, 440);
				lblNewLabel_1.setOpaque(true);
				frmAtm.getContentPane().add(lblNewLabel_1);
		
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(0, 0, 794, 511);
				frmAtm.getContentPane().add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(main.class.getResource("/st1.jpg")));
				frmAtm.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblNewLabel }));
		frmAtm.setResizable(false);
		frmAtm.setFocusable(true);
		frmAtm.setVisible(true);
		frmAtm.addKeyListener(keyada);


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
		tglbtnNewToggleButton.addKeyListener(keyada);
		frmAtm.addKeyListener(keyada);
		checkPin.start();
		checkPin.setPriority(Thread.MAX_PRIORITY );
		frmAtm.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
	}
	Thread checkPin=new Thread(new Runnable() {
		public void run(){ 
			try{
				boolean c=true;
			while(c)
			{
				Thread.sleep(100);
			if(count==4)
			{
			System.out.println("Pin Entered");
			
			CardDetails cd=new CardDetails();
			cd.fileOpen();
			cd.getContent();
			if(String.valueOf(pin).compareTo(String.valueOf(cd.atmpin))==0)
			{
				
				new ChooseOption().frmAtm.setVisible(true);
				frmAtm.setVisible(false);
				frmAtm.dispose();
				bclear.doClick(100);
				bclear.setFocusable(false);
				c=false;
			}
			}
			
			}}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		}});

	
		
	ActionListener btnact=new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		System.out.println(e.getActionCommand());
		 		if(String.valueOf(e.getActionCommand()).equals("Clear")){
		 			
		 			 		pin="";
		 			 		count=0;
		 			 		PIN.setText("");
		 			 		frmAtm.addKeyListener(keyada);
		 			 		
		 			 }
		 		
		 		else if(count<4){
		 		System.out.println(e.getActionCommand());
		 		keyboardInput=e.getActionCommand().charAt(0);
		 		PIN.setText(PIN.getText()+"*");
		 		pin=pin+e.getActionCommand();
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
			
			else if(count<4)
			switch(e.getKeyChar())
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
}
		
	
	
	

