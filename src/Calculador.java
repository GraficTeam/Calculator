import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int LayoutX;
	private int LayoutY;
	JButton close = new JButton("");
	JButton guard = new JButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculador frame = new Calculador();
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
	public Calculador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_24 = new JButton("=");
		btnNewButton_24.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_24.setForeground(Color.WHITE);
		btnNewButton_24.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_24.setFocusPainted(false);
		btnNewButton_24.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_24.setBackground(new Color(0, 0, 51));
		btnNewButton_24.setBounds(409, 349, 90, 40);
		contentPane.add(btnNewButton_24);
		
		JButton btnNewButton = new JButton("(");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton.setBounds(10, 145, 90, 40);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 25, 510, 109);
		panel.setBackground(new java.awt.Color(27,27,31));	
		contentPane.add(panel);
		panel.setLayout(null);
	
		JLabel txt_operacion = new JLabel("(5x10+20)");
		txt_operacion.setForeground(Color.LIGHT_GRAY);
		txt_operacion.setHorizontalAlignment(SwingConstants.LEFT);
		txt_operacion.setFont(new Font("Consolas", Font.BOLD, 21));
		txt_operacion.setBounds(10, 11, 490, 33);
		panel.add(txt_operacion);
	
		JLabel txt_resul = new JLabel("120");
		txt_resul.setForeground(Color.WHITE);
		txt_resul.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_resul.setFont(new Font("Consolas", Font.BOLD, 36));
		txt_resul.setBounds(10, 55, 490, 54);
		panel.add(txt_resul);
		
		
		JButton btnNewButton_1 = new JButton(")");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_1.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_1.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.setBackground(new Color(47, 79, 79));
		btnNewButton_1.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_1.setBounds(109, 145, 90, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("[");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_2.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_2.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setBackground(new Color(47, 79, 79));
		btnNewButton_2.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_2.setBounds(209, 145, 90, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("]");
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_3.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_3.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_3.setBackground(new Color(47, 79, 79));
		btnNewButton_3.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_3.setBounds(309, 145, 90, 40);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("C");
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_4.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_4.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_4.setBackground(new Color(153, 0, 0));
		btnNewButton_4.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_4.setBounds(409, 145, 90, 40);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("{");
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_5.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_5.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_5.setBackground(new Color(47, 79, 79));
		btnNewButton_5.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_5.setBounds(309, 196, 90, 40);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("6");
		btnNewButton_6.setFocusPainted(false);
		btnNewButton_6.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_6.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_6.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_6.setBackground(new Color(32, 34, 37,255));
		btnNewButton_6.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_6.setBounds(209, 247, 90, 40);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton(".");
		btnNewButton_7.setFocusPainted(false);
		btnNewButton_7.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_7.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_7.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_7.setBackground(new Color(32, 34, 37,255));
		btnNewButton_7.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_7.setBounds(10, 349, 90, 40);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("8");
		btnNewButton_8.setFocusPainted(false);
		btnNewButton_8.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_8.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_8.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_8.setBackground(new Color(32, 34, 37,255));
		btnNewButton_8.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_8.setBounds(109, 298, 90, 40);
		contentPane.add(btnNewButton_8);
		this.repaint();
		setLocationRelativeTo(null);
		
		JButton btnNewButton_9 = new JButton("1");
		btnNewButton_9.setFocusPainted(false);
		btnNewButton_9.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_9.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_9.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_9.setForeground(Color.WHITE);
		btnNewButton_9.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_9.setBackground(new Color(32, 34, 37));
		btnNewButton_9.setBounds(10, 196, 90, 40);
		contentPane.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("2");
		btnNewButton_10.setFocusPainted(false);
		btnNewButton_10.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_10.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_10.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_10.setForeground(Color.WHITE);
		btnNewButton_10.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_10.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_10.setBackground(new Color(32, 34, 37));
		btnNewButton_10.setBounds(109, 196, 90, 40);
		contentPane.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("3");
		btnNewButton_11.setFocusPainted(false);
		btnNewButton_11.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_11.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_11.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_11.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_11.setBackground(new Color(32, 34, 37));
		btnNewButton_11.setBounds(209, 196, 90, 40);
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("CE");
		btnNewButton_12.setFocusPainted(false);
		btnNewButton_12.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_12.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_12.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_12.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_12.setBackground(new Color(153, 0, 0));
		btnNewButton_12.setBounds(409, 196, 91, 40);
		contentPane.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("4");
		btnNewButton_13.setFocusPainted(false);
		btnNewButton_13.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_13.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_13.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_13.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_13.setBackground(new Color(32, 34, 37));
		btnNewButton_13.setBounds(10, 247, 90, 40);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("5");
		btnNewButton_14.setFocusPainted(false);
		btnNewButton_14.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_14.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_14.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_14.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_14.setBackground(new Color(32, 34, 37));
		btnNewButton_14.setBounds(109, 247, 90, 40);
		contentPane.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("}");
		btnNewButton_15.setFocusPainted(false);
		btnNewButton_15.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_15.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_15.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_15.setForeground(Color.WHITE);
		btnNewButton_15.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_15.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_15.setBackground(new Color(47, 79, 79));
		btnNewButton_15.setBounds(309, 247, 90, 40);
		contentPane.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("+");
		btnNewButton_16.setFocusPainted(false);
		btnNewButton_16.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_16.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_16.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_16.setForeground(Color.WHITE);
		btnNewButton_16.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_16.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_16.setBackground(new Color(47, 79, 79));
		btnNewButton_16.setBounds(409, 247, 91, 40);
		contentPane.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("7");
		btnNewButton_17.setFocusPainted(false);
		btnNewButton_17.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_17.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_17.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_17.setForeground(Color.WHITE);
		btnNewButton_17.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_17.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_17.setBackground(new Color(32, 34, 37));
		btnNewButton_17.setBounds(10, 298, 90, 40);
		contentPane.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("9");
		btnNewButton_18.setFocusPainted(false);
		btnNewButton_18.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_18.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_18.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_18.setForeground(Color.WHITE);
		btnNewButton_18.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_18.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_18.setBackground(new Color(32, 34, 37));
		btnNewButton_18.setBounds(209, 298, 90, 40);
		contentPane.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("*");
		btnNewButton_19.setFocusPainted(false);
		btnNewButton_19.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_19.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_19.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_19.setForeground(Color.WHITE);
		btnNewButton_19.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_19.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_19.setBackground(new Color(47, 79, 79));
		btnNewButton_19.setBounds(309, 298, 90, 40);
		contentPane.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("-");
		btnNewButton_20.setFocusPainted(false);
		btnNewButton_20.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_20.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_20.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_20.setForeground(Color.WHITE);
		btnNewButton_20.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_20.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_20.setBackground(new Color(47, 79, 79));
		btnNewButton_20.setBounds(409, 298, 91, 40);
		contentPane.add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("0");
		btnNewButton_21.setFocusPainted(false);
		btnNewButton_21.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_21.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_21.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_21.setForeground(Color.WHITE);
		btnNewButton_21.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_21.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_21.setBackground(new Color(32, 34, 37));
		btnNewButton_21.setBounds(109, 349, 90, 40);
		contentPane.add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("^");
		btnNewButton_22.setFocusPainted(false);
		btnNewButton_22.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_22.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_22.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_22.setForeground(Color.WHITE);
		btnNewButton_22.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_22.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_22.setBackground(new Color(32, 34, 37));
		btnNewButton_22.setBounds(209, 349, 90, 40);
		contentPane.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("/");
		btnNewButton_23.setFocusPainted(false);
		btnNewButton_23.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton_23.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnNewButton_23.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnNewButton_23.setForeground(Color.WHITE);
		btnNewButton_23.setFont(new Font("Consolas", Font.BOLD, 25));
		btnNewButton_23.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_23.setBackground(new Color(47, 79, 79));
		btnNewButton_23.setBounds(309, 349, 90, 40);
		contentPane.add(btnNewButton_23);
		
		JLabel mate = new JLabel("");
		mate.setBounds(0, 134, 510, 266);
		contentPane.add(mate);
		setLocationRelativeTo(null);
		
		ImageIcon logo = new ImageIcon("images/01.png");
		Icon icono1 = new ImageIcon(logo.getImage().getScaledInstance(mate.getWidth(),
				mate.getHeight(),Image.SCALE_DEFAULT));
		mate.setIcon(icono1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				mover(e);
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				motion(e);
			}
		});
		panel_1.setBounds(0, 0, 510, 25);
		panel_1.setBackground(new java.awt.Color(32, 34, 37));	
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrar(e);
			}
		});
		close.setBorder(null);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setFocusPainted(false);
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setIcon(new ImageIcon("images/Cerrar.png"));
		close.setBounds(464, 0, 46, 25);
		close.setBackground(new Color(32, 34, 37));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				close.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				close.setBackground(new Color(32, 34, 37));
			}
		});
		panel_1.add(close);
		guard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minimizar(e);
			}
		});
		guard.setBorder(null);
		
		guard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		guard.setFocusPainted(false);
		guard.setBackground(new Color(32, 34, 37));
		guard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				guard.setBackground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				guard.setBackground(new Color(32, 34, 37));
			}
		});
		guard.setVerticalAlignment(SwingConstants.BOTTOM);
		guard.setHorizontalAlignment(SwingConstants.CENTER);
		guard.setIcon(new ImageIcon("images/Minimizar.png"));
		guard.setBounds(418, 0, 46, 25);
		panel_1.add(guard);
		
		JLabel lblNewLabel_2 = new JLabel("Tree Calculator");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(202, 0, 106, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("f (x)");
		lblNewLabel.setBounds(0, 4, 56, 33);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 18));
		
	}
	
	private void cerrar(ActionEvent evt) {
        	System.exit(0);
    }

    private void minimizar(ActionEvent evt) {
    		this.setState(Frame.ICONIFIED);
    }
    
    private void mover(java.awt.event.MouseEvent evt) {
    		this.setLocation(evt.getXOnScreen()-LayoutX,evt.getYOnScreen()-LayoutY);
    }
    
    private void motion(java.awt.event.MouseEvent evt) {
    	if(evt.getButton()==java.awt.event.MouseEvent.BUTTON1) {
    		LayoutX = evt.getX();
    		LayoutY = evt.getY();
    	}
    }
}