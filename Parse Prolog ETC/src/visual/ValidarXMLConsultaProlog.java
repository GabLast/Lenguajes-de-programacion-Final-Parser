package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import org.jpl7.Term;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class ValidarXMLConsultaProlog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox cbxConsulta;
	private JTextArea txtResultado;

	public ValidarXMLConsultaProlog() {
		setTitle("Consultas");
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setBounds(100, 100, 519, 503);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblConsulta = new JLabel("Consulta:");
			lblConsulta.setBounds(10, 34, 56, 14);
			panel.add(lblConsulta);
			
			cbxConsulta = new JComboBox();
			cbxConsulta.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "abuelo(X,Y)"}));
			cbxConsulta.setBounds(76, 31, 407, 20);
			panel.add(cbxConsulta);
			
			JLabel lblRespuesta = new JLabel("Respuesta:");
			lblRespuesta.setBounds(10, 157, 56, 14);
			panel.add(lblRespuesta);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(76, 152, 407, 258);
			panel.add(scrollPane);
			
			JPanel panel_1 = new JPanel();
			scrollPane.setViewportView(panel_1);
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.setLayout(new BorderLayout(0, 0));
			
			txtResultado = new JTextArea();
			txtResultado.setEditable(false);
			txtResultado.setWrapStyleWord(true);
			txtResultado.setLineWrap(true);
			panel_1.add(txtResultado, BorderLayout.CENTER);
			txtResultado.setColumns(10);
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
				JButton okButton = new JButton("Consultar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						txtResultado.setText("");
						if(cbxConsulta.getSelectedIndex() < 1)
						{
							JOptionPane.showMessageDialog(null, "Elija la consulta deseada", "Error", JOptionPane.WARNING_MESSAGE);
						}
						else
						{					
							String consulta = cbxConsulta.getSelectedItem().toString();
							ArrayList<String> respuestas = new ArrayList<>();
							
							Map<String, Term>[] respuestasMaps = logic.Consulta.consultar(consulta);
							
							for(int i = 0; i < respuestasMaps.length; i++)
							{
								respuestas.add(String.valueOf(respuestasMaps[i].get("X")));
								//System.out.println("X = "+ (respuestasMaps[i].get("X")));
								//System.out.println(String.valueOf(respuestasMaps[i].get("X")));
							}
							
							for(String x : respuestas)
							{
								txtResultado.append(x + "\n");
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
