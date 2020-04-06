package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class mantenerPeso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JRadioButton rdbtnFemenino;
	JRadioButton rdbtnMasculino;
	JSpinner spnAltura;
	JSpinner spnPeso;
	JSpinner spnEdad;
	JComboBox cbxNivelEJ;

	public mantenerPeso() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setTitle("Calor\u00EDas para mantener el peso");
		setBounds(100, 100, 325, 351);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n requerida", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblPesoEnKilogrmos = new JLabel("Peso en Kilogr\u00E1mos:");
			lblPesoEnKilogrmos.setBounds(10, 34, 97, 14);
			panel.add(lblPesoEnKilogrmos);
			
			JLabel lblAlturaEnMetros = new JLabel("Altura en metros:");
			lblAlturaEnMetros.setBounds(10, 82, 97, 14);
			panel.add(lblAlturaEnMetros);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(10, 130, 97, 14);
			panel.add(lblEdad);
			
			JLabel lblGnero = new JLabel("G\u00E9nero:");
			lblGnero.setBounds(10, 178, 97, 14);
			panel.add(lblGnero);
			
			rdbtnMasculino = new JRadioButton("Masculino");
			rdbtnMasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMasculino.setSelected(true);
					rdbtnFemenino.setSelected(false);
				}
			});
			rdbtnMasculino.setBounds(204, 174, 76, 23);
			panel.add(rdbtnMasculino);
			
			rdbtnFemenino = new JRadioButton("Femenino");
			rdbtnFemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnMasculino.setSelected(false);
					rdbtnFemenino.setSelected(true);
				}
			});
			rdbtnFemenino.setBounds(113, 174, 109, 23);
			panel.add(rdbtnFemenino);
			
			spnAltura = new JSpinner();
			spnAltura.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnAltura.setBounds(117, 79, 162, 20);
			panel.add(spnAltura);
			
			spnPeso = new JSpinner();
			spnPeso.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnPeso.setBounds(118, 31, 162, 20);
			panel.add(spnPeso);
			
			spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnEdad.setBounds(117, 127, 162, 20);
			panel.add(spnEdad);
			
			JLabel lblNivelDeEjercicio = new JLabel("Nivel de Ejercicio");
			lblNivelDeEjercicio.setBounds(10, 226, 97, 14);
			panel.add(lblNivelDeEjercicio);
			
			cbxNivelEJ = new JComboBox();
			cbxNivelEJ.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Poco o Ning\u00FAn Ejercicio", "Ejercicio Ligero", "Ejercicio Moderado", "Deportista", "Atleta"}));
			cbxNivelEJ.setBounds(123, 223, 162, 20);
			panel.add(cbxNivelEJ);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton okButton = new JButton("Calcular");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						double valor;
						double valor2;
						float peso = (float) spnPeso.getValue();
						float altura = (float) spnAltura.getValue();
						int edad = (int) spnEdad.getValue();
						int nivelEJ = cbxNivelEJ.getSelectedIndex();
						int genero = -1;
						
						
						if(cbxNivelEJ.getSelectedIndex()>0)
						{
							if(rdbtnFemenino.isSelected())
							{
								genero = 0;
								valor = logic.Scheme.caloriasMantenerPeso(peso, altura, edad, genero, nivelEJ);
								valor2 = logic.Scheme.caloriasBajarPeso(peso, altura, edad, genero, nivelEJ);
								JOptionPane.showMessageDialog(null, "Las calorías diarias que le hacen mantener su peso actual: " + String.format("%.0f", valor)
								+ "\n"
								+ "Calorías diarias que puede consumir para perder peso a la semana: " + String.format("%.0f", valor2), "Notificación", JOptionPane.INFORMATION_MESSAGE);
							}
							else if(rdbtnMasculino.isSelected())
							{
								genero = 1;
								valor = logic.Scheme.caloriasMantenerPeso(peso, altura, edad, genero, nivelEJ);
								valor2 = logic.Scheme.caloriasBajarPeso(peso, altura, edad, genero, nivelEJ);
								JOptionPane.showMessageDialog(null, "Las calorías diarias que le hacen mantener su peso actual: " + String.format("%.0f", valor)
								+ "\n"
								+ "Calorías diarias que puede consumir para perder peso a la semana: " + String.format("%.0f", valor2), "Notificación", JOptionPane.INFORMATION_MESSAGE);
							}
							else
								JOptionPane.showMessageDialog(null, "Selecione un género", "Error", JOptionPane.WARNING_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "Elija cuanto ejercicio realiza", "Error", JOptionPane.WARNING_MESSAGE);
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
