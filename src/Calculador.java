import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.util.Stack;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
public class Calculador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int LayoutX;
	private int LayoutY;
	protected String contenido; 
	JButton close = new JButton("");
	JButton guard = new JButton("");
	ScriptEngineManager sem = new ScriptEngineManager();
	ScriptEngine se = sem.getEngineByName("JavaScript");
	private JTextField txt_operacion;

	/**
	 * Create the frame.
	 */
	
	
	
	public Calculador() {
		 Evaluador_de_expresiones evaluador= new Evaluador_de_expresiones();
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 25, 510, 109);
		panel.setBackground(new java.awt.Color(27,27,31));	
		contentPane.add(panel);
		panel.setLayout(null);
		
		txt_operacion = new JTextField();
		txt_operacion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter=e.getKeyChar();
				if(caracter<'(' || caracter>'9' || caracter==',')
					if(caracter!='[' && caracter!=']' && caracter!='{' && caracter!='}' && caracter!='^')
						e.consume();
			}
		});
		txt_operacion.setBorder(null);
		txt_operacion.setOpaque(false);
		txt_operacion.setForeground(Color.LIGHT_GRAY);
		txt_operacion.setHorizontalAlignment(SwingConstants.LEFT);
		txt_operacion.setFont(new Font("Consolas", Font.BOLD, 21));
		txt_operacion.setBounds(10, 11, 490, 33);
		panel.add(txt_operacion);
		txt_operacion.setColumns(10);

		JLabel txt_resul = new JLabel("");
		txt_resul.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txt_resul.setForeground(Color.WHITE);
		txt_resul.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_resul.setFont(new Font("Consolas", Font.BOLD, 36));
		txt_resul.setBounds(10, 55, 490, 54);
		panel.add(txt_resul);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cadena=txt_operacion.getText();
				String mensaje=evaluador.verifica1(cadena);
				if(mensaje!=null)
					JOptionPane.showMessageDialog(null,""+mensaje, "Error", JOptionPane.WARNING_MESSAGE);
				else {
					mensaje=evaluador.verifica3(cadena);
					if(mensaje!=null)
						JOptionPane.showMessageDialog(null,""+mensaje, "Error", JOptionPane.WARNING_MESSAGE);
					else {
						mensaje=evaluador.verifica2(cadena);
						if(mensaje!=null)
							JOptionPane.showMessageDialog(null,""+mensaje, "Error", JOptionPane.WARNING_MESSAGE);
						else {
							mensaje=evaluador.verifica4(cadena);
							if(mensaje!=null)
								JOptionPane.showMessageDialog(null,""+mensaje, "Error", JOptionPane.WARNING_MESSAGE);
							
						}
					}
					
				}
				
					
				System.out.println("Presionaste = ");
				
				if(mensaje==null){
					ArbolExpresiones arbol=new ArbolExpresiones(cadena);
					arbol.generaArbolExp();
					arbol.PosOrden(arbol.raiz);
					String res=arbol.evaluaExp();
					txt_resul.setText(res);
					/*try { 
						String res = se.eval(txt_operacion.getText()).toString();
						txt_resul.setText(res);
					} catch (ScriptException e) {
						txt_resul.setText("ERROR");
					}*/
				}

			}
			
		});
		btnEqual.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEqual.setForeground(Color.WHITE);
		btnEqual.setFont(new Font("Consolas", Font.BOLD, 25));
		btnEqual.setFocusPainted(false);
		btnEqual.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEqual.setBackground(new Color(0, 0, 51));
		btnEqual.setBounds(409, 349, 90, 40);
		contentPane.add(btnEqual);
		
		JButton btnParAp = new JButton("(");
		btnParAp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste ( ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "(");
				}else
					txt_operacion.setText(txt_operacion.getText() + "(");
			}
		});
		btnParAp.setFocusPainted(false);
		btnParAp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnParAp.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnParAp.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnParAp.setForeground(Color.WHITE);
		btnParAp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnParAp.setBackground(new Color(47, 79, 79));
		btnParAp.setFont(new Font("Consolas", Font.BOLD, 25));
		btnParAp.setBounds(10, 145, 90, 40);
		contentPane.add(btnParAp);
		
		
		JButton btnParCer = new JButton(")");
		btnParCer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste ) ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + ")");
				}else
					txt_operacion.setText(txt_operacion.getText() + ")");
			}
		});
		btnParCer.setFocusPainted(false);
		btnParCer.setHorizontalTextPosition(SwingConstants.CENTER);
		btnParCer.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnParCer.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnParCer.setForeground(Color.WHITE);
		btnParCer.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnParCer.setBackground(new Color(47, 79, 79));
		btnParCer.setFont(new Font("Consolas", Font.BOLD, 25));
		btnParCer.setBounds(109, 145, 90, 40);
		contentPane.add(btnParCer);
		
		JButton btnCorAp = new JButton("[");
		btnCorAp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste [ ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "[");
				}else
					txt_operacion.setText(txt_operacion.getText() + "[");
			}
		});
		btnCorAp.setFocusPainted(false);
		btnCorAp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCorAp.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnCorAp.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnCorAp.setForeground(Color.WHITE);
		btnCorAp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCorAp.setBackground(new Color(47, 79, 79));
		btnCorAp.setFont(new Font("Consolas", Font.BOLD, 25));
		btnCorAp.setBounds(209, 145, 90, 40);
		contentPane.add(btnCorAp);
		
		JButton btnCorCer = new JButton("]");
		btnCorCer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste ] ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "]");
				}else
					txt_operacion.setText(txt_operacion.getText() + "]");
			}
		});
		btnCorCer.setFocusPainted(false);
		btnCorCer.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCorCer.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnCorCer.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnCorCer.setForeground(Color.WHITE);
		btnCorCer.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCorCer.setBackground(new Color(47, 79, 79));
		btnCorCer.setFont(new Font("Consolas", Font.BOLD, 25));
		btnCorCer.setBounds(309, 145, 90, 40);
		contentPane.add(btnCorCer);
		
		JButton btnC = new JButton("C");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste C ");
				if(txt_operacion.getText().length() > 0) {
					txt_operacion.setText(txt_operacion.getText().substring(0, txt_operacion.getText().length()-1));
					txt_resul.setText("");
				}
			}
		});
		btnC.setFocusPainted(false);
		btnC.setHorizontalTextPosition(SwingConstants.CENTER);
		btnC.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnC.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnC.setForeground(Color.WHITE);
		btnC.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnC.setBackground(new Color(153, 0, 0));
		btnC.setFont(new Font("Consolas", Font.BOLD, 25));
		btnC.setBounds(409, 145, 90, 40);
		contentPane.add(btnC);
		
		JButton btnLlaAp = new JButton("{");
		btnLlaAp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste { ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "{");
				}else
					txt_operacion.setText(txt_operacion.getText() + "{");
			}
		});
		btnLlaAp.setFocusPainted(false);
		btnLlaAp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLlaAp.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnLlaAp.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnLlaAp.setForeground(Color.WHITE);
		btnLlaAp.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLlaAp.setBackground(new Color(47, 79, 79));
		btnLlaAp.setFont(new Font("Consolas", Font.BOLD, 25));
		btnLlaAp.setBounds(309, 196, 90, 40);
		contentPane.add(btnLlaAp);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 6 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "6");
				}else
					txt_operacion.setText(txt_operacion.getText() + "6");
			}
		});
		btn6.setFocusPainted(false);
		btn6.setHorizontalTextPosition(SwingConstants.CENTER);
		btn6.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn6.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn6.setForeground(Color.WHITE);
		btn6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn6.setBackground(new Color(32, 34, 37,255));
		btn6.setFont(new Font("Consolas", Font.BOLD, 25));
		btn6.setBounds(209, 247, 90, 40);
		contentPane.add(btn6);
		
		JButton btnPun = new JButton(".");
		btnPun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste . ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + ".");
				}else
					txt_operacion.setText(txt_operacion.getText() + ".");
			}
		});
		btnPun.setFocusPainted(false);
		btnPun.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPun.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnPun.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnPun.setForeground(Color.WHITE);
		btnPun.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPun.setBackground(new Color(32, 34, 37,255));
		btnPun.setFont(new Font("Consolas", Font.BOLD, 25));
		btnPun.setBounds(10, 349, 90, 40);
		contentPane.add(btnPun);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 8 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "8");
				}else
					txt_operacion.setText(txt_operacion.getText() + "8");
			}
		});
		btn8.setFocusPainted(false);
		btn8.setHorizontalTextPosition(SwingConstants.CENTER);
		btn8.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn8.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn8.setForeground(Color.WHITE);
		btn8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn8.setBackground(new Color(32, 34, 37,255));
		btn8.setFont(new Font("Consolas", Font.BOLD, 25));
		btn8.setBounds(109, 298, 90, 40);
		contentPane.add(btn8);
		this.repaint();
		setLocationRelativeTo(null);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 1 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "1");
				}else
					txt_operacion.setText(txt_operacion.getText() + "1");
			}
		});
		btn1.setFocusPainted(false);
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn1.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("Consolas", Font.BOLD, 25));
		btn1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn1.setBackground(new Color(32, 34, 37));
		btn1.setBounds(10, 196, 90, 40);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 2 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "2");
				}else
					txt_operacion.setText(txt_operacion.getText() + "2");
			}
		});
		btn2.setFocusPainted(false);
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		btn2.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn2.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("Consolas", Font.BOLD, 25));
		btn2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn2.setBackground(new Color(32, 34, 37));
		btn2.setBounds(109, 196, 90, 40);
		contentPane.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 3 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "3");
				}else
					txt_operacion.setText(txt_operacion.getText() + "3");
			}
		});
		btn3.setFocusPainted(false);
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn3.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn3.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("Consolas", Font.BOLD, 25));
		btn3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn3.setBackground(new Color(32, 34, 37));
		btn3.setBounds(209, 196, 90, 40);
		contentPane.add(btn3);
		
		JButton btnCE = new JButton("CE");
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste CE ");
				txt_operacion.setText("");
				txt_resul.setText("");
			}
		});
		btnCE.setFocusPainted(false);
		btnCE.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCE.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnCE.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnCE.setForeground(Color.WHITE);
		btnCE.setFont(new Font("Consolas", Font.BOLD, 25));
		btnCE.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCE.setBackground(new Color(153, 0, 0));
		btnCE.setBounds(409, 196, 91, 40);
		contentPane.add(btnCE);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 4 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "4");
				}else
					txt_operacion.setText(txt_operacion.getText() + "4");
			}
		});
		btn4.setFocusPainted(false);
		btn4.setHorizontalTextPosition(SwingConstants.CENTER);
		btn4.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn4.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn4.setForeground(Color.WHITE);
		btn4.setFont(new Font("Consolas", Font.BOLD, 25));
		btn4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn4.setBackground(new Color(32, 34, 37));
		btn4.setBounds(10, 247, 90, 40);
		contentPane.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 5 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "5");
				}else
					txt_operacion.setText(txt_operacion.getText() + "5");
			}
		});
		btn5.setFocusPainted(false);
		btn5.setHorizontalTextPosition(SwingConstants.CENTER);
		btn5.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn5.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn5.setForeground(Color.WHITE);
		btn5.setFont(new Font("Consolas", Font.BOLD, 25));
		btn5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn5.setBackground(new Color(32, 34, 37));
		btn5.setBounds(109, 247, 90, 40);
		contentPane.add(btn5);
		
		JButton btnLlaCer = new JButton("}");
		btnLlaCer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste } ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "}");
				}else
					txt_operacion.setText(txt_operacion.getText() + "}");
			}
		});
		btnLlaCer.setFocusPainted(false);
		btnLlaCer.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLlaCer.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnLlaCer.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnLlaCer.setForeground(Color.WHITE);
		btnLlaCer.setFont(new Font("Consolas", Font.BOLD, 25));
		btnLlaCer.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLlaCer.setBackground(new Color(47, 79, 79));
		btnLlaCer.setBounds(309, 247, 90, 40);
		contentPane.add(btnLlaCer);
		
		JButton btnSum = new JButton("+");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste + ");
				txt_operacion.setText(txt_operacion.getText() + "+");
			}
		});
		btnSum.setFocusPainted(false);
		btnSum.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSum.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnSum.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnSum.setForeground(Color.WHITE);
		btnSum.setFont(new Font("Consolas", Font.BOLD, 25));
		btnSum.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSum.setBackground(new Color(47, 79, 79));
		btnSum.setBounds(409, 247, 91, 40);
		contentPane.add(btnSum);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 7 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "7");
				}else
					txt_operacion.setText(txt_operacion.getText() + "7");
			}
		});
		btn7.setFocusPainted(false);
		btn7.setHorizontalTextPosition(SwingConstants.CENTER);
		btn7.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn7.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn7.setForeground(Color.WHITE);
		btn7.setFont(new Font("Consolas", Font.BOLD, 25));
		btn7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn7.setBackground(new Color(32, 34, 37));
		btn7.setBounds(10, 298, 90, 40);
		contentPane.add(btn7);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 9 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "9");
				}else
					txt_operacion.setText(txt_operacion.getText() + "9");
			}
		});
		btn9.setFocusPainted(false);
		btn9.setHorizontalTextPosition(SwingConstants.CENTER);
		btn9.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn9.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn9.setForeground(Color.WHITE);
		btn9.setFont(new Font("Consolas", Font.BOLD, 25));
		btn9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn9.setBackground(new Color(32, 34, 37));
		btn9.setBounds(209, 298, 90, 40);
		contentPane.add(btn9);
		
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste * ");
				txt_operacion.setText(txt_operacion.getText() + "*");
			}
		});
		btnMul.setFocusPainted(false);
		btnMul.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMul.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnMul.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnMul.setForeground(Color.WHITE);
		btnMul.setFont(new Font("Consolas", Font.BOLD, 25));
		btnMul.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnMul.setBackground(new Color(47, 79, 79));
		btnMul.setBounds(309, 298, 90, 40);
		contentPane.add(btnMul);
		
		JButton btnRes = new JButton("-");
		btnRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste - ");
				txt_operacion.setText(txt_operacion.getText() + "-");
			}
		});
		btnRes.setFocusPainted(false);
		btnRes.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRes.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnRes.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnRes.setForeground(Color.WHITE);
		btnRes.setFont(new Font("Consolas", Font.BOLD, 25));
		btnRes.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRes.setBackground(new Color(47, 79, 79));
		btnRes.setBounds(409, 298, 91, 40);
		contentPane.add(btnRes);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste 0 ");
				if(txt_resul.getText().length() > 0) {
					txt_operacion.setText("");
					txt_resul.setText("");
					txt_operacion.setText(txt_operacion.getText() + "0");
				}else
					txt_operacion.setText(txt_operacion.getText() + "0");
			}
		});
		btn0.setFocusPainted(false);
		btn0.setHorizontalTextPosition(SwingConstants.CENTER);
		btn0.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btn0.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btn0.setForeground(Color.WHITE);
		btn0.setFont(new Font("Consolas", Font.BOLD, 25));
		btn0.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btn0.setBackground(new Color(32, 34, 37));
		btn0.setBounds(109, 349, 90, 40);
		contentPane.add(btn0);
		
		JButton btnPot = new JButton("^");
		btnPot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste ^ ");
				txt_operacion.setText(txt_operacion.getText() + "^");
			}
		});
		btnPot.setFocusPainted(false);
		btnPot.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPot.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnPot.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnPot.setForeground(Color.WHITE);
		btnPot.setFont(new Font("Consolas", Font.BOLD, 25));
		btnPot.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPot.setBackground(new Color(32, 34, 37));
		btnPot.setBounds(209, 349, 90, 40);
		contentPane.add(btnPot);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Presionaste / ");
				txt_operacion.setText(txt_operacion.getText() + "/");
			}
		});
		btnDiv.setFocusPainted(false);
		btnDiv.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDiv.setPressedIcon(new ImageIcon("images\btn3_pressed_dark.png"));
		btnDiv.setRolloverIcon(new ImageIcon("images\btn3_dark.png"));
		btnDiv.setForeground(Color.WHITE);
		btnDiv.setFont(new Font("Consolas", Font.BOLD, 25));
		btnDiv.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDiv.setBackground(new Color(47, 79, 79));
		btnDiv.setBounds(309, 349, 90, 40);
		contentPane.add(btnDiv);
		
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