package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.naming.ldap.Rdn;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import jsint.Scheme;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class porcentajeGrasa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JRadioButton rdbtnFemenino;
	JRadioButton rdbtnMasculino;
	JSpinner spnAltura;
	JSpinner spnPeso;
	JSpinner spnEdad;
	//Scheme scheme = new Scheme();

	public porcentajeGrasa() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setTitle("Porcentaje de Grasa Corporal");
		setBounds(100, 100, 325, 359);
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
			lblPesoEnKilogrmos.setBounds(10, 44, 97, 14);
			panel.add(lblPesoEnKilogrmos);
			
			JLabel lblAlturaEnMetros = new JLabel("Altura en metros:");
			lblAlturaEnMetros.setBounds(10, 102, 97, 14);
			panel.add(lblAlturaEnMetros);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(10, 160, 97, 14);
			panel.add(lblEdad);
			
			JLabel lblGnero = new JLabel("G\u00E9nero:");
			lblGnero.setBounds(10, 218, 97, 14);
			panel.add(lblGnero);
			
			rdbtnMasculino = new JRadioButton("Masculino");
			rdbtnMasculino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnMasculino.setSelected(true);
					rdbtnFemenino.setSelected(false);
				}
			});
			rdbtnMasculino.setBounds(204, 214, 76, 23);
			panel.add(rdbtnMasculino);
			
			rdbtnFemenino = new JRadioButton("Femenino");
			rdbtnFemenino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					rdbtnMasculino.setSelected(false);
					rdbtnFemenino.setSelected(true);
				}
			});
			rdbtnFemenino.setBounds(113, 214, 109, 23);
			panel.add(rdbtnFemenino);
			
			spnAltura = new JSpinner();
			spnAltura.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnAltura.setBounds(117, 99, 162, 20);
			panel.add(spnAltura);
			
			spnPeso = new JSpinner();
			spnPeso.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
			spnPeso.setBounds(118, 41, 162, 20);
			panel.add(spnPeso);
			
			spnEdad = new JSpinner();
			spnEdad.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnEdad.setBounds(117, 157, 162, 20);
			panel.add(spnEdad);
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
						float peso = (float) spnPeso.getValue();
						float altura = (float) spnAltura.getValue();
						int edad = (int) spnEdad.getValue();
						int genero = -1;
						
						if(rdbtnFemenino.isSelected())
						{
							genero = 0;
							valor = logic.Scheme.porcentajeGrasa(peso, altura, edad, genero);
							JOptionPane.showMessageDialog(null, "Su porcentaje de grasa corporal es de: " + valor + '%', "Notificación", JOptionPane.INFORMATION_MESSAGE);
						}
						else if(rdbtnMasculino.isSelected())
						{
							genero = 1;
							valor = logic.Scheme.porcentajeGrasa(peso, altura, edad, genero);
							JOptionPane.showMessageDialog(null, "Su porcentaje de grasa corporal es de: " + valor + '%', "Notificación", JOptionPane.INFORMATION_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "Selecione un género", "Error", JOptionPane.WARNING_MESSAGE);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
