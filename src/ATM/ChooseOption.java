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
import javax.swing.UIManager;

public class ChooseOption {
	 JFrame frmAtm;
	JMenuBar menuBar;
	JToggleButton tglbtnNewToggleButton;
	AskForPin askPin;
	JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bclear,bCancel;
	ActionListener btnact;
	public ChooseOption() throws Exception {
		
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

		
		lblChangePin = new JLabel("Change PIN");
		lblChangePin.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionForeground"));
		lblChangePin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		lblChangePin.setBounds(100, 423, 202, 56);
		frmAtm.getContentPane().add(lblChangePin);
		
		lblFastCash = new JLabel("Fast Cash");
		lblFastCash.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionForeground"));
		lblFastCash.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFastCash.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		lblFastCash.setBounds(495, 349, 202, 56);
		frmAtm.getContentPane().add(lblFastCash);
		
		lblWithdrawl = new JLabel("WithDrawal");
		lblWithdrawl.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionForeground"));
		lblWithdrawl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWithdrawl.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		lblWithdrawl.setBounds(495, 267, 202, 56);
		frmAtm.getContentPane().add(lblWithdrawl);
		
		lblBalanceTransfer = new JLabel("Balance Transfer");
		lblBalanceTransfer.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionForeground"));
		lblBalanceTransfer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalanceTransfer.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		lblBalanceTransfer.setBounds(434, 423, 261, 56);
		frmAtm.getContentPane().add(lblBalanceTransfer);
		
		lblBalanceInquriy = new JLabel("Balance Inquriy");
		lblBalanceInquriy.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionForeground"));
		lblBalanceInquriy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBalanceInquriy.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		lblBalanceInquriy.setBounds(445, 193, 248, 56);
		frmAtm.getContentPane().add(lblBalanceInquriy);
		
		JLabel lblBvn = new JLabel("Please Choose One Option");
		lblBvn.setOpaque(true);
		lblBvn.setVerticalAlignment(SwingConstants.TOP);
		lblBvn.setHorizontalAlignment(SwingConstants.CENTER);
		lblBvn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 29));
		lblBvn.setForeground(Color.BLACK);
		lblBvn.setBackground(Color.BLUE);
		lblBvn.setBounds(100, 32, 597, 447);
		frmAtm.getContentPane().add(lblBvn);

		JButton lbutton1 = new JButton("New button");
		lbutton1.setBounds(34, 189, 46, 41);
		frmAtm.getContentPane().add(lbutton1);

		JButton btnChangePin = new JButton("New button");
		btnChangePin.setBounds(34, 271, 46, 41);
		frmAtm.getContentPane().add(btnChangePin);

		JButton lbutton3 = new JButton("New button");
		lbutton3.setBounds(34, 351, 46, 41);
		frmAtm.getContentPane().add(lbutton3);

		JButton lbutton4 = new JButton("New button");
		lbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ChangePin().frmAtm.setVisible(true);
					frmAtm.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lbutton4.setBounds(34, 431, 46, 41);
		frmAtm.getContentPane().add(lbutton4);

		JButton btnBalInq = new JButton("New button");
		btnBalInq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new BalanceInquriy().frmAtm.setVisible(true);
					frmAtm.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBalInq.setBounds(720, 189, 46, 41);
		frmAtm.getContentPane().add(btnBalInq);

		JButton btnWithDrawl = new JButton("New button");
		btnWithDrawl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new WithDrawl().frmAtm.setVisible(true);
					frmAtm.setVisible(false);
					frmAtm.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnWithDrawl.setBounds(720, 271, 46, 41);
		frmAtm.getContentPane().add(btnWithDrawl);

		JButton BtnFastCash = new JButton("New button");
		BtnFastCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new FastCash().frmAtm.setVisible(true);
					frmAtm.setVisible(false);
					frmAtm.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		BtnFastCash.setBounds(720, 351, 46, 41);
		frmAtm.getContentPane().add(BtnFastCash);

		JButton BtnBalTrans = new JButton("New button");
		BtnBalTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new BalanceTransfer().frmAtm.setVisible(true);
					frmAtm.dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		BtnBalTrans.setBounds(720, 431, 46, 41);
		frmAtm.getContentPane().add(BtnBalTrans);
		
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
		 bCancel.setIcon(null);
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
				lblNewLabel.setIcon(new ImageIcon(ChooseOption.class.getResource("/st1.jpg")));
				frmAtm.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblNewLabel }));
		frmAtm.setResizable(false);
		frmAtm.setFocusable(true);
		
	}

	private JPanel panel;
	private JLabel lblBalanceInquriy;
	private JLabel lblWithdrawl;
	private JLabel lblFastCash;
	private JLabel lblBalanceTransfer;
	private JLabel lblChangePin;
}
