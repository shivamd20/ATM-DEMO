package ATM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;

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

public class main {
	 JFrame frmAtm;
	JMenuBar menuBar;
	JToggleButton tglbtnNewToggleButton;
	AskForPin askPin;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bclear,bCancel;
	char keyboardInput;
	ActionListener btnact;
	Thread keyboardip,buttonip;
	
	public main() throws Exception {
	initialize();
	}

	private void initialize() {
		frmAtm = new JFrame();
		frmAtm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\shiva\\Desktop\\Snap.png"));
		frmAtm.setTitle("ATM");
		KeyboardInput();
		ButtonInput();
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
				if(CardDetect.dname=="s")
				{
					JOptionPane.showMessageDialog(panel_1, "Please Insert Your Card Properly", "Card Not Detected", JOptionPane.WARNING_MESSAGE);
				}else{
				new CardDetails().frame.setVisible(true);}
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
				
				panel_1 = new JPanel();
				panel_1.setBounds(0, 0, 794, 511);
				frmAtm.getContentPane().add(panel_1);
				panel_1.setLayout(null);
		
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setBounds(0, 0, 794, 511);
				panel_1.add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(main.class.getResource("/st1.jpg")));
				frmAtm.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblNewLabel }));
		frmAtm.setResizable(false);
		frmAtm.setFocusable(true);
		t.start();
	}
	Thread t=new Thread(new Runnable() {
		public void run(){ 
			cd.t.start();
			while(CardDetect.dname=="s")
			{
				try {
					Thread.sleep(100);
			
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
	
			}
			try {
				frmAtm.setVisible(false);
				
				frmAtm.dispose();
				  Frame[] ob=	JFrame.getFrames();
				    for(Frame x :ob) {
				 	   x.setVisible(false);
				 	   x.dispose();
				 	  
				 	   }
				    if(!(CardDetect.dname.equals("s")))
				    {
				  //  new CreateATM().UpdateATM();
				    new AskForPin();
				    Thread.currentThread().stop();
				    }
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
	char KeyboardInput()
	{
		
		frmAtm.addKeyListener(keyada);
		return keyboardInput;
	
	}
	char ButtonInput()
	{
		
		btnact=new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		System.out.println(e.getActionCommand());
		 		keyboardInput=e.getActionCommand().charAt(0);
		 	}
		};
		
	return keyboardInput;
	}
	KeyAdapter keyada=new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			keyboardInput=e.getKeyChar();
			//JOptionPane.showMessageDialog(frmAtm,e.getKeyChar()+"");
		}
	};
	private JPanel panel;
	private JPanel panel_1;
	CardDetect cd = new CardDetect();
	
}
