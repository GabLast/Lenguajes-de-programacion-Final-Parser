package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setTitle("Proyecto Final Lenguajes de Programaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 484);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnConsultas = new JMenu("Consultas");
		menuBar.add(mnConsultas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Hacer consulta");
		mnConsultas.add(mntmNewMenuItem);
		
		JMenu mnClculos = new JMenu("C\u00E1lculos");
		menuBar.add(mnClculos);
		
		JMenuItem mntmPorcentajeDeGrasa = new JMenuItem("Porcentaje de Grasa");
		mntmPorcentajeDeGrasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new porcentajeGrasa().setVisible(true);
			}
		});
		mnClculos.add(mntmPorcentajeDeGrasa);
		
		JMenuItem mntmPlatosParaMantener = new JMenuItem("Platos para Mantener Peso Actual");
		mntmPlatosParaMantener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new mantenerPeso().setVisible(true);
			}
		});
		mnClculos.add(mntmPlatosParaMantener);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
